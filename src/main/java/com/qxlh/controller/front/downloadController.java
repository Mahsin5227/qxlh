package com.qxlh.controller.front;

import com.qxlh.core.Const;
import com.qxlh.core.utils.StringUtils;
import com.qxlh.service.user.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;


@Controller
@RequestMapping("/download")
public class downloadController {
    @Resource
    private IUserService userService;

    @RequestMapping("/trainingprogram/{fileName}.{extension}")
    public void down(@PathVariable("fileName") String fileName, @PathVariable("extension") String extension, HttpServletRequest request, HttpServletResponse response)throws Exception{
        if (StringUtils.isEmpty(fileName)) {
            throw new IOException("文件名格式非法 [" + fileName + "]");
        }

        fileName = URLDecoder.decode(fileName, "UTF-8");
        String path = Const.DOWNLOAD_PATH+"/trainprogram/"+fileName+"."+extension;
        String downPath = request.getServletContext().getRealPath(path);
        System.out.println(downPath);
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fullName = fileName+"."+extension;
        fileName = new String(fullName.getBytes("UTF-8"), "ISO-8859-1");
        //Content-disposition属性设置成以附件方式进行下载
        response.setHeader("Content-disposition", "attachment;filename="
                + fileName);

        OutputStream os = null;
        try {
            os = response.getOutputStream();
            File file = new File(downPath);
            FileInputStream fips = new FileInputStream(file);
            byte[] btImg = readStream(fips);
            os.write(btImg);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取管道中的流数据
     */
    public byte[] readStream(InputStream inStream) {
        ByteArrayOutputStream bops = new ByteArrayOutputStream();
        int data = -1;
        try {
            while((data = inStream.read()) != -1){
                bops.write(data);
            }
            return bops.toByteArray();
        }catch(Exception e){
            return null;
        }
    }
}
