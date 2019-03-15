package com.qxlh.service.impl;

import com.qxlh.core.ResponseModel;
import com.qxlh.core.utils.MD5Util;
import com.qxlh.dao.user.IUserDao;
import com.qxlh.model.User;
import com.qxlh.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;



    @Override
    public ResponseModel login(User user, HttpServletRequest request,HttpServletResponse response) {
        String password = user.getPassword();
       // String flag = request.getParameter("flag");
        user.setPassword(MD5Util.getMD5Code(password));
        User findUser = userDao.login(user);//通过用户名 密码登陆  返回信息包括用户状态
        String flag = request.getParameter("rememberme");
        if(findUser != null){
            if(findUser.isState() ==-1){
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
            userDao.loginSuccess(findUser.getId());
            //查询用户所有信息
            findUser = this.findById(findUser.getId());
            request.getSession().setAttribute("loginUser",findUser);

            return new ResponseModel(3,"登录成功",request.getServletContext().getContextPath()+"/user/index");

        }
        return new ResponseModel(-1,"用户名或密码错误");
    }


    @Override
    public User findById(long id) {
        return userDao.findById(id);
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
    public ResponseModel register(User user, HttpServletRequest request) {
        User u =userDao.findByName(user.getName());
        if(u!=null){
            return new ResponseModel(-1,"该用户名已被注册");
        }
        if(userDao.findByMobile(user.getMobile())!=null){
            return new ResponseModel(-1,"该手机号已被注册");
        }
        user.setPassword(MD5Util.getMD5Code(user.getPassword()));
        if(userDao.register(user)==1){
            return new ResponseModel(2,"注册成功",request.getServletContext().getContextPath()+"/user/login");
        }
        return new ResponseModel(-1,"注册失败");
    }
}
