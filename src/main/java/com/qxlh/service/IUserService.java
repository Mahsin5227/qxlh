package com.qxlh.service;

import com.qxlh.core.ResponseModel;
import com.qxlh.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface IUserService {
    ResponseModel login(User user, HttpServletRequest request,HttpServletResponse response);
    User findById(long id);
    User findByName(String name);
    User findByMobile(String mobile);
    User findByMobileAndEmail(String mobile,String email);
    ResponseModel register(User user,HttpServletRequest request);
}
