package com.qxlh.core.utils;

import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

public class ErrorUtil {

    private static Map<Integer,String> errors = new HashMap<Integer, String>();
    static {
        errors.put(-1000,"系统异常");
        errors.put(-1001,"没有权限");
        errors.put(-1002,"群组不存在");
        errors.put(-1005,"用户不存在");
        errors.put(-1008,"请先登录");
        errors.put(-1009,"新闻公告不存在");
    }

    public static String error(Model model, Integer errorcode, String ftlPath){
        model.addAttribute("msg",errors.get(errorcode));
        return ftlPath;
    }
}
