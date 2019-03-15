package com.qxlh.dao.user;

import com.qxlh.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao {

    //@Param("")        参数名称设置
    //参数是 javabean      根据字段
    User login(User user);
    int loginSuccess(@Param("id") long id);
    int register(User user);
    User findById(@Param("id") long id);
    User findByName(@Param("name") String name);
    User findByMobile(@Param("mobile") String mobile);
    User findByMobileAndEmail(@Param("mobile") String mobile,@Param("email")String email);
    int changepwd(@Param("id") long id,@Param("password") String password);
}
