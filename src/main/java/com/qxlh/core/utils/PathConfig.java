package com.qxlh.core.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("PathConfig")
public class PathConfig {
    @Value("${managePath}")
    private String managePath;
    @Value("${manageTemplate}")
    private String manageTemplate;
    @Value("${userTemplate}")
    private String userTemplate;
    @Value("${frontTemplate}")
    private String frontTemplate;

    public String getManagePath() {
        return managePath;
    }

    public String getManageTemplate() {
        return manageTemplate;
    }

    public String getUserTemplate() {
        return userTemplate;
    }

    public String getFrontTemplate() {
        return frontTemplate;
    }
}
