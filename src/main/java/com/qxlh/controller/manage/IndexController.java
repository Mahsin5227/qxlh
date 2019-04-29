package com.qxlh.controller.manage;


import com.qxlh.controller.common.BaseController;
import com.qxlh.core.ResponseModel;
import com.qxlh.model.user.User;
import com.qxlh.service.user.IUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Properties;

@Controller("manageIndexController")
@RequestMapping("/manage")
public class IndexController extends BaseController {
    private static final String JSP_PATH = "/manage";
    @Resource
    IUserService userService;

    /**
     * 登录页面
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return JSP_PATH + "/index";
    }


    /**
     * 登录页面
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return JSP_PATH + "/login";
    }

    /**
     * 提交登录信息
     * @param user
     * @return
     */
    
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Object login(User user){
        if(user == null){
            return new ResponseModel(-1,"参数错误");
        }
        if(StringUtils.isEmpty(user.getName())){
            return new ResponseModel(-1,"用户名不能为空");
        }
        if(StringUtils.isEmpty(user.getPassword())){
            return new ResponseModel(-1,"密码不能为空");
        }
        User loginUser = userService.managerLogin(user,request);
        if(loginUser != null){
            request.getSession().setAttribute("loginUser",loginUser);
            return new ResponseModel(2,"登录成功","/");
        }else {
            return new ResponseModel(-1,"用户名或密码错误");
        }
    }
}
