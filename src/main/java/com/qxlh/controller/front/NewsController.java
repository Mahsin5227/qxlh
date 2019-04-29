package com.qxlh.controller.front;

import com.qxlh.controller.common.BaseController;
import com.qxlh.core.Const;
import com.qxlh.core.Page;
import com.qxlh.core.ResponseModel;
import com.qxlh.core.utils.ErrorUtil;
import com.qxlh.core.utils.PathConfig;
import com.qxlh.core.utils.StringUtils;
import com.qxlh.model.News.News;
import com.qxlh.model.user.User;
import com.qxlh.service.News.IArchiveService;
import com.qxlh.service.News.INewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller("NewsController")
@RequestMapping("/news")
public class NewsController extends BaseController {
    private static final String  NEWS_JSP_PATH = "/news/";

    @Resource
    private INewsService newsService;
    @Resource
    private IArchiveService archiveService;


    @RequestMapping(value="/list",method = RequestMethod.GET)
    public String list(String key, Model model) {
        if (StringUtils.isNotEmpty(key)){
            try {
                key = new String(key.getBytes("iso-8859-1"),"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        Page page = new Page(request);
        ResponseModel responseModel = newsService.listByPage(page,0,key,0,1,0);
        model.addAttribute("model",responseModel);
       // List<ArticleTag> articleTagList = articleTagService.list();
       // model.addAttribute("articleTagList",articleTagList);
        return  "/front"+NEWS_JSP_PATH + "list";
    }


    @RequestMapping(value="/detail/{id}",method = RequestMethod.GET)
    public String detail(@PathVariable("id") Integer id, Model model){
        User loginUser = (User) request.getAttribute("loginUser");
        News news = newsService.findById(id);

        if(news == null || news.getStatus() == 0){
            //return PathConfig.getFrontTemplate() + ErrorUtil.error(model,-1009, Const.INDEX_ERROR_JSP_PATH);
        }
        //更新文章访问次数
        archiveService.updateViewCount(news.getId());
        model.addAttribute("news",news);
        /*List<ArticleTag> articleTagList = articleTagService.list();
        model.addAttribute("articleTagList",articleTagList);*/
        model.addAttribute("loginUser",loginUser);
        return  "/front"+NEWS_JSP_PATH + "detail";
    }

    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String add(Model model) {
        User loginUser = (User) request.getAttribute("loginUser");
        model.addAttribute("loginUser",loginUser);
        return "/front"+NEWS_JSP_PATH + "add";
    }


}
