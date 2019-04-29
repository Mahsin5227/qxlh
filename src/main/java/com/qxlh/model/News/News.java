package com.qxlh.model.News;

import com.qxlh.model.user.User;

import javax.validation.constraints.Digits;
import java.util.Date;

/**
 * 新闻实体类
 * @author mahsin
 *
 */
public class News extends Archive {
    private Integer id;
    private Integer groupId;
    private Date collectTime;
    @Digits(integer = 11,fraction = 0,message = "分类不能为空")
    private Integer cateId;
    private Integer status;

    private NewsCate newsCate;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public NewsCate getNewsCate() {
        return newsCate;
    }

    public void setNewsCate(NewsCate newsCate) {
        this.newsCate = newsCate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public Integer getStatus() {
        return status;
    }
}
