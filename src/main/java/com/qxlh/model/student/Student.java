package com.qxlh.model.student;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

public class Student {
    private Integer id;   //流水号
    private Integer uid;
    private Integer number;//学好
    private String password;
    private String username;//姓名
    private String identity_card;//生份证
    private boolean gender; //x性别
    private Date birthday;//生日
    private String mobile;
    private String email;
    private Date create_date;
    private Date update_time;
    private String photo;
    private Integer school;
    private Integer college;
    private Integer mClass;
    private Date create_time;
    private int status;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public void setSchool(Integer school) {
        this.school = school;
    }

    public void setCollege(Integer college) {
        this.college = college;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentity_card() {
        return identity_card;
    }

    public void setIdentity_card(String identity_card) {
        this.identity_card = identity_card;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getSchool() {
        return school;
    }

    public void setSchool(int school) {
        this.school = school;
    }

    public int getCollege() {
        return college;
    }

    public void setCollege(int college) {
        this.college = college;
    }

    public Integer getmClass() {
        return mClass;
    }

    public void setmClass(Integer mClass) {
        this.mClass = mClass;
    }




    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", number=" + number +
                ", username='" + username + '\'' +
                ", identity_card='" + identity_card + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", create_time=" + create_time +
                '}';
    }
}
