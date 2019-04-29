package com.qxlh.dao.user;

import com.qxlh.model.user.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IUserDao {

    //@Param("")        参数名称设置
    //参数是 javabean      根据字段
    User login(User user);
    public Set<String> getRoles(Integer user_id);

    /**
     *  通过用户名查找该用户所有的权限并保存在Set集合中
     *  @param role_id
     *  @return Set<String>
     */
    public Set<String> getPermissions(Integer role_id);

    User managerLogin(User user);
    int loginSuccess(@Param("id") Integer id,@Param("currLoginIp") String currLoginIp);
    int register(User user);
    User findById(@Param("id") Integer id);
    User findByName(@Param("name") String name);
    User findByMobile(@Param("phone") String phone);
    User findByNameAndEmail(@Param("name")String name,@Param("email")String email);
    User findByMobileAndEmail(@Param("phone") String phone,@Param("email")String email);
    int changepwd(@Param("id") Integer id,@Param("password") String password);


    User findByEmail(@Param("email") String email);
}
