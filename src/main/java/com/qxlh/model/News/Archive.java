package com.qxlh.model.News;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qxlh.model.user.User;

import javax.validation.constraints.Digits;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

public class Archive {
    private Integer archiveId;
    private Integer postType;

    private String title;

    private Integer userId;


    private User user;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String description;

    private String keywords;

    @Digits(integer = 1,fraction = 0,message = "浏览权限只能是数字")
    private Integer viewRank;

    @Digits(integer = 11,fraction = 0,message = "浏览数只能是数字")
    private Integer viewCount;

    private String writer;

    private String source;

    private Date pubTime;

    private Date updateTime;

    private String thumbnail;



    private Integer checkAdmin;


    private String content;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Integer getViewRank() {
        return viewRank;
    }

    public void setViewRank(Integer viewRank) {
        this.viewRank = viewRank;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getThumbnail() {
        return "".equals(thumbnail) ? null:thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }



    public Integer getCheckAdmin() {
        return checkAdmin;
    }

    public void setCheckAdmin(Integer checkAdmin) {
        this.checkAdmin = checkAdmin;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPostType() {
        return postType;
    }

    public void setPostType(Integer postType) {
        this.postType = postType;
    }

    public Archive copy(Object object) throws Exception {
        Class<?> classType = object.getClass();
        //当前对象
        Class<?> newClassType = this.getClass();
        Object objectCopy = classType.getConstructor(new Class[]{}).newInstance(new Object[]{});
        //获得当前对象的所有成员变量
        Field[] fields = newClassType.getDeclaredFields();
        for(Field field : fields) {
            //获取成员变量的名字
            String name = field.getName();
            //获取get和set方法的名字
            String firstLetter = name.substring(0,1).toUpperCase();
            String getMethodName = "get" + firstLetter + name.substring(1);
            String setMethodName = "set" + firstLetter + name.substring(1);
            //获取方法对象
            Method getMethod = classType.getMethod(getMethodName, new Class[]{});
            Method setMethod = classType.getMethod(setMethodName, new Class[]{field.getType()});
            //调用get方法获取旧的对象的值
            Object value = getMethod.invoke(object, new Object[]{});
            //调用set方法将这个值复制到新的对象中去
            setMethod.invoke(objectCopy, new Object[]{value});
        }
        return (Archive) objectCopy;
    }
}
