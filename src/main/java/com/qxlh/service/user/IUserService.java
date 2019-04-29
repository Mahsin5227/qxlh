package com.qxlh.service.user;

import com.qxlh.core.ResponseModel;
import com.qxlh.model.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;


public interface IUserService {
    ResponseModel login(User user, HttpServletRequest request,HttpServletResponse response);
    User managerLogin(User user, HttpServletRequest request);
    User findById(Integer id);
    Set<String> getRoles(Integer user_id);
    Set<String> getPermission(Integer role_id);
    User findByName(String name);
    User findByMobile(String mobile);
    User findByMobileAndEmail(String mobile,String email);
    User findByNameAndEmail(String name,String email);
    ResponseModel register(User user,HttpServletRequest request);
    ResponseModel resetpwd(String email,String token,String password, HttpServletRequest request);

    ResponseModel changepwd(User loginUser, Integer id, String password);

    ResponseModel changepwd(User loginUser, String oldPassword, String newPassword);

    ResponseModel forgetpwd(String name, String email, HttpServletRequest request);
}
