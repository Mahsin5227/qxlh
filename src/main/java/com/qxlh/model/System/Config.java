package com.qxlh.model.System;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统设置信息实体类
 */
public class Config implements Serializable {
    private String Skey;

    private String Svalue;

    private String description;

    private Date update_time;


    public String getSkey() {
        return Skey;
    }

    public void setSkey(String skey) {
        Skey = skey;
    }

    public String getSvalue() {
        return Svalue;
    }

    public void setSvalue(String svalue) {
        Svalue = svalue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}