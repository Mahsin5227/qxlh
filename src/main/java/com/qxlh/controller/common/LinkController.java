package com.qxlh.controller.common;

import com.qxlh.core.Page;
import com.qxlh.core.ResponseModel;
import com.qxlh.model.System.Config;
import com.qxlh.service.common.ILinkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller("LinkController")
@RequestMapping("/links")
public class LinkController extends BaseController{
    private static final String LINL_JSP_PATH="/links/";
    @Resource
    private ILinkService linkService;


    /**
     * 请求 links/list.jsp 页面  获取所有链接
     * @param model
     * @return
     */
    @RequestMapping(value={"/list"},method = RequestMethod.GET)
    public String link(Model model) {
        ResponseModel linkModel = linkService.allList();
        model.addAttribute("linkModel",linkModel);
        return "front"+ "/links/list";
    }

}
