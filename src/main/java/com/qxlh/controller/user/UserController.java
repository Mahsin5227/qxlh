package com.qxlh.controller.user;

import com.qxlh.controller.common.BaseController;
import com.qxlh.core.ResponseModel;
import com.qxlh.core.utils.StringUtils;
import com.qxlh.model.User;
import com.qxlh.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;



@Controller("UserIndexController")
@RequestMapping("/user")
public class UserController extends BaseController {
    private static final String User_JSP_PATH = "/user/";

    @Resource
    private IUserService userService;


    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Model model){
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        //需要重新查询用户信息，更新信息
        if(loginUser != null){
            model.addAttribute("loginUser",loginUser);
        }
        return User_JSP_PATH + "index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Model model, @RequestParam(value = "redirectUrl",required = false,defaultValue = "") String redirectUrl){

        User loginUser = (User)request.getSession().getAttribute("loginUser");
        if(loginUser != null){
            return "redirect:/user/index";
        }
        model.addAttribute("redirectUrl",redirectUrl);
        return User_JSP_PATH + "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel<User> login(User User, @RequestParam(value = "redirectUrl",required = false,defaultValue = "") String redirectUrl, HttpServletResponse response){

        System.out.println("---------------------登陆成功-----------------------------------------------------------");
        System.out.println(User.toString());
        String remember = request.getParameter("rememberme");
        System.out.println(remember+"---------------------------------------------------------------------------------------");
        ResponseModel responseModel = userService.login(User,request,response);
        System.out.println(responseModel.toString());
        if (redirectUrl != null && !"".equals(redirectUrl) && responseModel.getCode() >= 0){
            responseModel.setCode(3);
            responseModel.setUrl(redirectUrl);
        }
        return responseModel;
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(){
        request.getSession().setAttribute("loginUser",null);
        return "redirect:/user/login";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        User loginUser =(User) request.getSession().getAttribute("loginUser");
        if(loginUser != null){
            return "redirect:/user/index";
        }
        return User_JSP_PATH + "/register";
    }



    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel register(User User,String repassword){
        /*Map<String,String> config = configService.getConfigToMap();
        if("0".equals(config.get(ConfigUtil.User_REGISTER_OPEN))){
            return new ResponseModel(-1,"注册功能已关闭");
        }*/
        if(User == null){
            return new ResponseModel(-1,"参数错误");
        }
        if(User.getName().length() < 6){
            return new ResponseModel(-1,"用户名长度最少6位");
        }
        if(!StringUtils.checkNickname(User.getName())){
            return new ResponseModel(-1,"用户名只能由中文、字母、数字、下划线(_)或者短横线(-)组成");
        }
        if(!StringUtils.isEmail(User.getEmail())){
            return new ResponseModel(-1,"邮箱格式错误");
        }
        if(User.getPassword().length() < 6){
            return new ResponseModel(-1,"密码长度最少6位");
        }
        if(!User.getPassword().equals(repassword)){
            return new ResponseModel(-1,"两次密码输入不一致");
        }
       System.out.println(User.toString());
        return userService.register(User,request);
    }

}
