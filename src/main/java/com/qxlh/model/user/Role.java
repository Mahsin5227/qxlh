package com.qxlh.model.user;

import java.util.HashSet;
import java.util.Set;

public class Role {
    private Integer id;
    private String name;
    private String description;
    private Integer avaliable;

    private Set<Object> permissions = new HashSet<Object>();

    public Integer getId() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAvaliable() {
        return avaliable;
    }

    public void setAvaliable(Integer avaliable) {
        this.avaliable = avaliable;
    }

    public Set<Object> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Object> permissions) {
        this.permissions = permissions;
    }
}
