package com.qxlh.model;

import java.util.Date;

public class User {

    private Integer id;
    private String mobile;
    private String email;
    private String name;
    private String password;
    private Integer state;

    private Date create_time;
    private Date curr_login_time;
    private Date update_time;
    private Date last_login_time;
    private Integer gender;
    private Date birthday;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Date getCreate_time() {
        return create_time;
    }




    public Integer isState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }


    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getCurr_login_time() {
        return curr_login_time;
    }

    public void setCurr_login_time(Date curr_login_time) {
        this.curr_login_time = curr_login_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Date getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer isGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", mobile=" + mobile +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", state=" + state +
                '}';
    }
}
