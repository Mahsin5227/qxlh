package com.qxlh.controller.collegeinfo;

import com.qxlh.controller.common.BaseController;
import com.qxlh.core.Page;
import com.qxlh.core.ResponseModel;
import com.qxlh.model.core.University;
import com.qxlh.service.News.INewsService;
import com.qxlh.service.core.IUniversityService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/collegeInfo")
public class collegeInfoController extends BaseController {
    @Resource
    INewsService newsService;
    @Resource
    IUniversityService universityService;

    private static final String COLLEGEINFO_JSP_PATH = "/collegeInfo/";


    @RequestMapping(value = {"/","/index"},method = RequestMethod.GET)
    public String index(Model model){

        ResponseModel responseModel = universityService.allList();
        model.addAttribute("model",responseModel);

        return "front"+COLLEGEINFO_JSP_PATH+"index";
    }

    @RequestMapping(value = "/introduce",method = RequestMethod.GET)
    public String introduce(Model model){
        ResponseModel responseModel = universityService.allList();
        model.addAttribute("model",responseModel);

        return "front"+COLLEGEINFO_JSP_PATH+"introduce";
    }

    @RequestMapping(value = "introduce/detail/{key}",method = RequestMethod.GET)
    public String introduceDetail(@PathVariable("key") String key,Model model){
        System.out.println(key);
        return "front"+COLLEGEINFO_JSP_PATH+"introduce/detail";
    }

    @RequestMapping(value = "news/detail/{key}",method = RequestMethod.GET)
    public String newsDetail(@PathVariable("key") String key,Model model){
        System.out.println(key);
        Page page = new Page(request);
        ResponseModel responseModel = newsService.listByPage(page,0,null,0,1,2);
        model.addAttribute("model",responseModel);
        return "front"+COLLEGEINFO_JSP_PATH+"news/detail";
    }

    @RequestMapping(value = "news/list",method = RequestMethod.GET)
    public String newsList(Model model){
        Page page = new Page(request);
        ResponseModel responseModel = newsService.listByPage(page,0,null,0,1,2);
        model.addAttribute("model",responseModel);
        return "front"+COLLEGEINFO_JSP_PATH+"news/list";
    }
}
