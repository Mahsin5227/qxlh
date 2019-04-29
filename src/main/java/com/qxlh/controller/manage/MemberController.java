package com.qxlh.controller.manage;


import com.qxlh.controller.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by cubc-luntan 2016/11/22.
 */
@Controller("manageMemberController")
@RequestMapping("/")

public class MemberController extends BaseController {
    private static final String MANAGE_FTL_PATH = "/manage/member/";

}
