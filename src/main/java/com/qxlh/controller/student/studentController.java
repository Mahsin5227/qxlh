package com.qxlh.controller.student;

import com.qxlh.controller.common.BaseController;
import com.qxlh.core.ResponseModel;
import com.qxlh.model.student.Student;
import com.qxlh.model.user.User;
import com.qxlh.service.student.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
@Controller("studentController")

@RequestMapping("/student")
public class studentController extends BaseController {
    @Resource
    private IStudentService studentService;
    private static final String STUDENT_JSP_PATH = "/student/";


    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Model model){
        User loginUser = (User) request.getSession().getAttribute("loginUser");

        if(loginUser != null){
            model.addAttribute("loginUser",loginUser);

        }
        return STUDENT_JSP_PATH + "index";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel save(Student student){
        User user = (User) request.getSession().getAttribute("loginUser");
        System.out.println(student.toString());
        ResponseModel responseModel= studentService.save(user,student);

        if(responseModel.getCode() == 0){
            responseModel.setCode(3);
        }
        return responseModel;
    }



}
