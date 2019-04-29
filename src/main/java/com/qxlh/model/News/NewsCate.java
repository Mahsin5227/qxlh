package com.qxlh.model.News;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.Digits;
import java.io.Serializable;
import java.util.Date;

public class NewsCate implements Serializable {
    //新闻类型

    private Integer id;
    private Integer groupId;
    private Date createTime;
    private Integer fid; //上级
    private String name;
    private Integer status;
    private Integer sort;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
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

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
