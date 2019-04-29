package com.qxlh.model.System;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.qxlh.model.user.User;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by cubc-luntan 2017/2/14.
 */
public class ActionLog implements Serializable {
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private Integer userId;
    private User user;
    private Integer actionId;
    private Action action;
    private String remark;
    private String actionIp;
    private Integer type;
    private Integer foreignId;

    public ActionLog(){

    }
    public ActionLog(Integer userId,Integer actionId,String remark,String actionIp){
        this.userId = userId;
        this.actionId = actionId;
        this.remark = remark;
        this.actionIp = actionIp;

    }
    public ActionLog(Integer userId,Integer actionId,String remark,String actionIp,Integer type,Integer foreignId){
        this.userId = userId;
        this.actionId = actionId;
        this.remark = remark;
        this.actionIp = actionIp;
        this.type = type;
        this.foreignId = foreignId;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getActionIp() {
        return actionIp;
    }

    public void setActionIp(String actionIp) {
        this.actionIp = actionIp;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getForeignId() {
        return foreignId;
    }

    public void setForeignId(Integer foreignId) {
        this.foreignId = foreignId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
