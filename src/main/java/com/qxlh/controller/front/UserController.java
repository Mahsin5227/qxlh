package com.qxlh.controller.front;

import com.qxlh.controller.common.BaseController;
import com.qxlh.core.ResponseModel;
import com.qxlh.core.utils.StringUtils;
import com.qxlh.model.user.User;
import com.qxlh.service.user.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;



@Controller("UserIndexController")
@RequestMapping("/user")
public class UserController extends BaseController {
    private static final String USER_JSP_PATH = "/user/";

    @Resource
    private IUserService userService;



    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Model model){
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        //需要重新查询用户信息，更新信息
        if(loginUser != null){
            model.addAttribute("loginUser",loginUser);
        }
        return USER_JSP_PATH + "index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Model model, @RequestParam(value = "redirectUrl",required = false,defaultValue = "") String redirectUrl){

        User loginUser = (User)request.getSession().getAttribute("loginUser");
        if(loginUser != null){
            return "redirect:/user/index";
        }
        model.addAttribute("redirectUrl",redirectUrl);
        return USER_JSP_PATH + "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel<User> login(User User, @RequestParam(value = "redirectUrl",required = false,defaultValue = "") String redirectUrl, HttpServletResponse response){

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
        return USER_JSP_PATH + "/register";
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

    @RequestMapping(value = "/forgetpwd",method = RequestMethod.GET)
    public String forgetpwd(){
        return USER_JSP_PATH + "/forgetpwd";
    }


    @RequestMapping(value = "/forgetpwd",method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel forgetpwd(String name,String email){
        return userService.forgetpwd(name, email, request);
    }

    @RequestMapping(value = "/resetpwd",method = RequestMethod.GET)
    public String resetpwd(String email,String token,Model model){
        model.addAttribute("email",email);
        model.addAttribute("token",token);
        return USER_JSP_PATH + "/resetpwd";
    }

    @RequestMapping(value = "/resetpwd",method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel resetpwd(String email,String token,String password,String repassword){
        if(StringUtils.isEmpty(password)){
            return new ResponseModel(-1,"新密码不能为空");
        }
        if(password.length() < 6){
            return new ResponseModel(-1,"密码不能少于6个字符");
        }
        if(!password.equals(repassword)){
            return new ResponseModel(-1,"两次密码输入不一致");
        }
        return userService.resetpwd(email,token,password,request);
    }


    @RequestMapping(value = "/password",method = RequestMethod.GET)
    public String password(Model model){
        User loginMember = (User) request.getSession().getAttribute("loginUser");
        if(loginMember != null){
            model.addAttribute("loginUser",loginMember);
            return USER_JSP_PATH + "changePassword";
        }
        return USER_JSP_PATH + "login";
    }

    @RequestMapping(value = "/changePassword",method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel password(String oldPassword, String newPassword, String renewPassword){
        if(StringUtils.isEmpty(oldPassword)){
            return new ResponseModel(-1,"旧密码不能为空");
        }
        if(StringUtils.isEmpty(newPassword)){
            return new ResponseModel(-1,"新密码不能为空");
        }
        if(!newPassword.equals(renewPassword)){
            return new ResponseModel(-1,"两次密码输入不一致");
        }
        User loginUser =(User) request.getSession().getAttribute("loginUser");
        System.out.println(loginUser.toString());
        return userService.changepwd(loginUser,oldPassword,newPassword);
    }

}
