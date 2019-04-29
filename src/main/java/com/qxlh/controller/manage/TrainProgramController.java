package com.qxlh.controller.manage;

import com.qxlh.controller.common.BaseController;
import com.qxlh.core.Page;
import com.qxlh.core.ResponseModel;
import com.qxlh.model.News.NewsCate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/manage/trainprogram")
public class TrainProgramController extends BaseController {
    private static final String JSP_PATH="/manage/trainprogram/";

    @RequestMapping("/index")
    public String index(String key,Model model) {

        return JSP_PATH + "index";
    }

    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String add(Model model) {

        return JSP_PATH + "add";
    }



}
