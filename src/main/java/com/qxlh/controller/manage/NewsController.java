package com.qxlh.controller.manage;

import com.qxlh.controller.common.BaseController;
import com.qxlh.core.Page;
import com.qxlh.core.ResponseModel;
import com.qxlh.model.News.News;
import com.qxlh.model.News.NewsCate;
import com.qxlh.model.user.User;
import com.qxlh.service.News.IArchiveService;
import com.qxlh.service.News.INewsCateService;
import com.qxlh.service.News.INewsService;
import com.qxlh.service.system.IActionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Controller("manageNewsController")
@RequestMapping("/manage/news")
public class NewsController extends BaseController {
    private static final String JSP_PATH="/manage/news/";
    @Resource
    IActionService actionService;

    @Resource
    INewsService newsService;
    @Resource
    INewsCateService newsCateService;

    @RequestMapping("/index")
    public String index(String key, @RequestParam(value = "cateid",defaultValue = "0",required = false) Integer cateid,
                        @RequestParam(value = "status",defaultValue = "2",required = false) Integer status,
                        @RequestParam(value = "userId",defaultValue = "0",required = false) Integer userId, Model model) {
        List<NewsCate> cateList = newsCateService.list();
        Page page = new Page(request);
        int groupId = 0;
        ResponseModel responseModel = newsService.listByPage(page,groupId,key,cateid,status,userId);
        model.addAttribute("model",responseModel);
        model.addAttribute("cateList",cateList);
        model.addAttribute("key",key);
        model.addAttribute("cateid",cateid);
        return JSP_PATH + "index";
    }

    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String add(Model model) {
        List<NewsCate> cateList = newsCateService.list();
        model.addAttribute("cateList",cateList);
        return JSP_PATH + "add";
    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    @ResponseBody
    public Object save(@Valid News news, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            //return new ResponseModel(-1,getErrorMessages(bindingResult));
        }
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        if(loginUser == null){
            return new ResponseModel(-1,"请先登录");
        }
        ResponseModel responseModel = newsService.save(loginUser,news);
        if(responseModel.getCode() == 0){
            responseModel.setCode(2);
            //文章需要审核就跳转到列表页面
            if(news.getStatus() == 0){
                responseModel.setUrl(request.getContextPath()+"/news/list");
            }else {
                responseModel.setUrl(request.getContextPath()+"/news/detail/"+news.getId());
            }
        }
        return responseModel;
    }


    @RequestMapping(value="/edit/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable("id") Integer id, Model model){
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        List<NewsCate> cateList = newsCateService.list();
        model.addAttribute("cateList",cateList);
        News news = newsService.findById(id,loginUser);
        model.addAttribute("news",news);
        return JSP_PATH + "edit";
    }

    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ResponseBody
    public Object update(@Valid News news,BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
           // new ResponseModel(-1,getErrorMessages(bindingResult));
        }
        if(news.getId() == null){
            return new ResponseModel(-2);
        }
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        ResponseModel responseModel = newsService.update(loginUser,news);
        if(responseModel.getCode() == 0){
            responseModel.setCode(2);
            responseModel.setUrl(request.getContextPath() + "/news/detail/"+news.getId());
        }
        return responseModel;
    }


    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("id") Integer id){
        User loginUser =(User) request.getSession().getAttribute("loginUser");
        ResponseModel response = newsService.delete(loginUser,id);
        return response;
    }

    @RequestMapping(value = "audit/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Object audit(@PathVariable("id") Integer id){
        ResponseModel response = newsService.audit(id);
        return response;
    }

}
