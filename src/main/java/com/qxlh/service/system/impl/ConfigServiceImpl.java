package com.qxlh.service.system.impl;

import com.qxlh.core.ResponseModel;
import com.qxlh.dao.system.IConfigDao;
import com.qxlh.model.System.Config;
import com.qxlh.service.system.IConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("ConfigService")
public class ConfigServiceImpl implements IConfigService {

    @Resource
    private IConfigDao configDao;


    @Override
    public List<Config> allList() {
            return configDao.allList();
        }

    @Override
    public Map<String, String> getConfigToMap() {
        List<Config> allList = this.allList();
        Map<String,String> map = new HashMap<String, String>();
        for (Config config : allList) {
            map.put(config.getSkey(),config.getSvalue());
        }
        return map;
    }

    @Override
    public String getValue(String key) {
        return getConfigToMap().get(key);
    }

    @Override
    public ResponseModel update(Map<String, String> params, HttpServletRequest request) {
        for(Map.Entry entry : params.entrySet()){
            if(((String)entry.getValue()).length() > 500){
                return new ResponseModel(-1,"只能输入255个字符");
            }else {
                configDao.update((String)entry.getKey(),(String)entry.getValue());
                request.getServletContext().setAttribute(((String)entry.getKey()).toUpperCase(),entry.getValue());
            }
        }
        return new ResponseModel(0,"操作成功");
    }
}
