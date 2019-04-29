package com.qxlh.service.system;

import com.qxlh.core.ResponseModel;
import com.qxlh.model.System.Config;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface IConfigService {
    List<Config> allList();

    Map<String,String> getConfigToMap();

    String getValue(String key);

    ResponseModel update(Map<String,String> params, HttpServletRequest request);
}