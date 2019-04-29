package com.qxlh.controller.front;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qxlh.controller.common.BaseController;
import com.qxlh.core.Const;
import com.qxlh.core.ResponseModel;
import com.qxlh.service.user.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 文件上传
 *
 */
@Controller
@RequestMapping("/upload")
public class uploadController extends BaseController {
    @Resource
    private IUserService userService;
    /**
     * 上传
     * @param file
     */
    @RequestMapping(value = "uploadFile")
    @ResponseBody
    public ResponseModel uploadfile(MultipartFile file) {

        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."),fileName.length()).toLowerCase();

        String newFileName = UUID.randomUUID() + suffix;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String ymd = sdf.format(new Date());
        String path = Const.UPLOAD_PATH + "/images/" + ymd + "/";

        System.out.println(path);

        String savePath = request.getServletContext().getRealPath(path);

        System.out.println(savePath);

        File baseDir = new File(savePath);
        if(!baseDir.exists()){
            baseDir.mkdirs();
        }
        File targetFile = new File(baseDir, newFileName);
        try{
            file.transferTo(targetFile);
        }catch (IOException e){
            //写入异常
            e.printStackTrace();
        }
        String url = request.getContextPath() + path + newFileName;
        return new ResponseModel(0,"上传成功",url);
    }


    public String mutilUpload(MultipartFile[] files)throws IllegalStateException, IOException{


        return null;

    }

    /**
     * 上传图片
     * @param file
     */
    @RequestMapping(value = "/uploadImage")
    @ResponseBody
    public String uploadImage(MultipartFile file) {
/*        PrintWriter out = null;
        try {
            response.setCharacterEncoding("utf-8");
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        String fileName;//上传的图片文件名
        String suffix = "";//上传图片的文件扩展名
        //for (MultipartFile file : upload) {

        fileName = file.getOriginalFilename();
        suffix = fileName.substring(fileName.lastIndexOf("."),fileName.length()).toLowerCase();

        String newFileName = UUID.randomUUID() + suffix;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String ymd = sdf.format(new Date());
        String path = Const.UPLOAD_PATH + "/images/" + ymd + "/";

        System.out.println(path);

        String savePath = request.getServletContext().getRealPath(path);

        System.out.println(savePath);

        File baseDir = new File(savePath);
        if(!baseDir.exists()){
            baseDir.mkdirs();
        }
        File targetFile = new File(baseDir, newFileName);
        try{
            file.transferTo(targetFile);
        }catch (IOException e){
            //写入异常
        }
        String imageUrl = request.getContextPath() + path + newFileName;

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        map1.put("code",0);//0表示成功，1失败
        map1.put("msg","上传成功");//提示消息
        map1.put("data",map2);
        map2.put("src",imageUrl);//图片url
        map2.put("title",newFileName);//图片名称，这个会显示在输入框里
        try{
            String jsonResult = mapper.writeValueAsString(map1);
            System.out.println(jsonResult);
            return jsonResult;
        }catch (JsonProcessingException e){
            //转换失败
        }

        //}
        return null;
    }








}

