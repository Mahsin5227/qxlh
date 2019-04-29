package com.qxlh.dao.student;

import com.qxlh.model.student.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentDao {
    int save(Student student);
    Student findById(@Param("id") Integer id);
    Student findByName(@Param("name") String name);
    Student findByUid(@Param("uid") Integer uid);
    Student findByNumber(@Param("number") Integer number);


}
