package com.qxlh.controller.manage;

import com.qxlh.service.user.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/manage/info")
public class UniversityController {
    @Resource
    IUserService userService;
    private static final String JSP_PATH ="/manage/info/";


}
