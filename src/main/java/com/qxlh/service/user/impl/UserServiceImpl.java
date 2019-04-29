package com.qxlh.service.user.impl;

import com.qxlh.core.ResponseModel;
import com.qxlh.core.utils.*;
import com.qxlh.dao.user.IUserDao;
import com.qxlh.model.user.User;
import com.qxlh.model.user.ValidateCode;
import com.qxlh.service.user.IUserService;
import com.qxlh.service.user.IValidateCodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;
    @Resource
    private IValidateCodeService validateCodeService;


    @Override
    public ResponseModel login(User user, HttpServletRequest request,HttpServletResponse response) {
        String password = user.getPassword();
       // String flag = request.getParameter("flag");
        user.setPassword(MD5Util.getMD5Code(password));
        User findUser = userDao.login(user);//通过用户名 密码登陆  返回信息包括用户状态

        String flag = request.getParameter("reuserme");
        if(findUser != null){
            if(findUser.getStatus() ==-1){
                return new ResponseModel(-1,"该账户已被禁用");
            }
            if(flag!=null&&flag.equals("1")){
                Cookie nameCookie = new Cookie("name", user.getName());
             //设置Cookie的有效期为3天
                nameCookie.setMaxAge(60 * 60 * 24 * 3);
                Cookie pwdCookie = new Cookie("password", password);
                pwdCookie.setMaxAge(60 * 60 * 24 * 3);
                response.addCookie(nameCookie);
                response.addCookie(pwdCookie);
            }
            //更新登陆时间信息
            userDao.loginSuccess(findUser.getId(),IpUtil.getIpAddress(request));
            //查询用户所有信息
            findUser = this.findById(findUser.getId());
            request.getSession().setAttribute("loginUser",findUser);

            return new ResponseModel(3,"登录成功",request.getServletContext().getContextPath()+"/user/index");

        }
        return new ResponseModel(-1,"用户名或密码错误");
    }

    @Override
    public User managerLogin(User user, HttpServletRequest request) {
        String password = user.getPassword();
        user.setPassword(MD5Util.getMD5Code(user.getPassword()));
        User findUser = userDao.managerLogin(user);
        if(findUser != null){
            //登录成功更新状态
            userDao.loginSuccess(findUser.getId(), IpUtil.getIpAddress(request));
            findUser = this.findById(findUser.getId());
        }else {
           // actionLogService.save(IpUtil.getIpAddress(request),null,ActionUtil.MEMBER_LOGIN_ERROR,"登录用户名："+user.getName()+"，登录密码："+password);
        }
        return findUser;
    }


    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public Set<String> getRoles(Integer user_id) {
        return userDao.getRoles(user_id);
    }

    @Override
    public Set<String> getPermission(Integer role_id) {
        return userDao.getPermissions(role_id);
    }

    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public User findByMobile(String mobile) {
        return userDao.findByMobile(mobile);
    }

    @Override
    public User findByMobileAndEmail(String mobile, String email) {
        return userDao.findByMobileAndEmail(mobile,email);
    }

    @Override
    public User findByNameAndEmail(String name, String email) {
        return userDao.findByNameAndEmail(name,email);
    }

    @Override
    public ResponseModel register(User user, HttpServletRequest request) {
        User u =userDao.findByName(user.getName());
        if(u!=null){
            return new ResponseModel(-1,"该用户名已被注册");
        }
        if(userDao.findByMobile(user.getPhone())!=null){
            return new ResponseModel(-1,"该手机号已被注册");
        }
        user.setPassword(MD5Util.getMD5Code(user.getPassword()));
        if(userDao.register(user)==1){
            return new ResponseModel(2,"注册成功",request.getServletContext().getContextPath()+"/user/login");
        }
        return new ResponseModel(-1,"注册失败");
    }

    @Override
    public ResponseModel changepwd(User loginUser, Integer id, String password) {
        if(StringUtils.isBlank(password)){
            return new ResponseModel(-1,"密码不能为空");
        }
        if(password.length() < 6){
            return new ResponseModel(-1,"密码不能少于6个字符");
        }
        password = MD5Util.getMD5Code(password);
        if(userDao.changepwd(id,password) == 1){
            return new ResponseModel(3,"密码修改成功");
        }
        return new ResponseModel(-1,"密码修改失败");
    }

    @Override
    public ResponseModel changepwd(User loginUser, String oldPassword, String newPassword) {
        if(StringUtils.isBlank(newPassword)){
            return new ResponseModel(-1,"密码不能为空");
        }
        if(newPassword.length() < 6){
            return new ResponseModel(-1,"密码不能少于6个字符");
        }
        oldPassword = MD5Util.getMD5Code(oldPassword);

        User user = userDao.findById(loginUser.getId());

        if(!oldPassword.equals(user.getPassword())){
            return new ResponseModel(-1,"旧密码错误");
        }
        return this.changepwd(loginUser,user.getId(),newPassword);
    }

    @Override
    public ResponseModel forgetpwd(String name, String email, HttpServletRequest request) {
        User user = this.findByNameAndEmail(name,email);
        if(user == null){
            return new ResponseModel(-1,"会员不存在");
        }
        String randomCode = RandomCodeUtil.uuid();
        ValidateCode validateCode = new ValidateCode(email,randomCode,1);
        if(validateCodeService.save(validateCode)){
            if(EmailSendUtil.forgetpwd(request, email,randomCode)){
                return new ResponseModel(0,"邮件发送成功");
            }
        }

        return new ResponseModel(-1,"邮件发送失败，请重试");
    }

    public ResponseModel resetpwd(String email,String token,String password, HttpServletRequest request) {
        User user = userDao.findByEmail(email);
        if(user == null){
            return new ResponseModel(-1,"会员不存在");
        }
        ValidateCode validateCode = validateCodeService.valid(email,token,1);
        if(validateCode == null){
            return new ResponseModel(-1,"验证码错误");
        }
        password = MD5Util.getMD5Code(password);
        if(userDao.changepwd(user.getId(),password) == 1){
            validateCodeService.used(validateCode.getId());
            //actionLogService.save(IpUtil.getIpAddress(request),user.getId(), ActionUtil.FIND_PWD);
            return new ResponseModel(2,"密码重置成功",request.getContextPath()+"/user/login");
        }
        return new ResponseModel(-1,"密码重置失败");
    }
}
