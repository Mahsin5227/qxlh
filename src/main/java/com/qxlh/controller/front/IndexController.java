package com.qxlh.controller.front;


import com.qxlh.controller.common.BaseController;
import com.qxlh.core.Page;
import com.qxlh.core.ResponseModel;
import com.qxlh.model.user.User;
import com.qxlh.service.News.INewsService;
import com.qxlh.service.common.ILinkService;
import com.qxlh.service.user.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller("indexController")
@RequestMapping("/")
public class IndexController extends BaseController {
    @Resource
    private INewsService newsService;
    @Resource
    private ILinkService linkService;

    @Resource
    private IUserService userService;

    /**
     * 请求前段首页
     * @param key
     * @param cateid
     * @param model
     * @return
     */

    @RequestMapping(value={"/", "index"},method = RequestMethod.GET)
    public String index(@RequestParam(value = "key",required = false,defaultValue = "") String key, Integer cateid, Model model) {
        Page page = new Page(request);
        if(cateid == null){
            cateid = 0;
        }
        User loginUser = (User) request.getAttribute("loginUser");
        int loginUserId = loginUser == null ? 0 : loginUser.getId();
        ResponseModel newsModel = newsService.listByPage(page,0,key,cateid,1,0);

        page.setPageSize(50);

        model.addAttribute("newsModel",newsModel);

        return "/front" + "/index";
    }

//    @RequestMapping(value={"/links"},method = RequestMethod.GET)
//    public String link(Model model) {
//        ResponseModel linkModel = linkService.allList();
//        model.addAttribute("linkModel",linkModel);
//        return "/front"+ "/links/list";
//    }
}