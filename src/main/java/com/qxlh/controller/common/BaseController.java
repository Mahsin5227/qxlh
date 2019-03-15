package com.qxlh.controller.common;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BaseController {
    @Resource
    protected HttpServletRequest request;



    protected String getParam(String name){
        return request.getParameter(name);
    }

}
