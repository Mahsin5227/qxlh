package com.qxlh.service.student.impl;

import com.qxlh.core.ResponseModel;
import com.qxlh.dao.student.IStudentDao;
import com.qxlh.model.student.Student;
import com.qxlh.model.user.User;
import com.qxlh.service.student.IStudentService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

@Service
public class studentServiceImpl implements IStudentService {
    @Resource
    private IStudentDao studentDao;

    @Override
    public ResponseModel save(User user, Student student) {
        student.setUid(user.getId());
        student.setStatus(0);
        System.out.println(student.toString());
        if(studentDao.save(student)==1){
            return new ResponseModel(1,"保存成功,请等待审核!");

        }


        return new ResponseModel(-1,"保存失败,请重试!");
    }

    @Override
    public Student findById(Integer id) {
        return null;
    }

    @Override
    public Student findByName(String name) {
        return null;
    }

    @Override
    public Student findByMobile(String mobile) {
        return null;
    }

    @Override
    public Student findByMobileAndEmail(String mobile, String email) {
        return null;
    }
}
