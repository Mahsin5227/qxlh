package com.qxlh.service.student;

import com.qxlh.core.ResponseModel;
import com.qxlh.model.student.Student;
import com.qxlh.model.user.User;


public interface IStudentService {
    ResponseModel save(User user, Student student);
    Student findById(Integer id);
    Student findByName(String name);
    Student findByMobile(String mobile);
    Student findByMobileAndEmail(String mobile,String email);

}
