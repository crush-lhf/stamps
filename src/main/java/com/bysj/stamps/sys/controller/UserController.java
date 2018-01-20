package com.bysj.stamps.sys.controller;

import com.bysj.stamps.common.ReturnInfoHelper;
import com.bysj.stamps.sys.model.User;
import com.bysj.stamps.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lihf
 * @version 1.0
 * @address 邮政
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/queryUser.do")
    @ResponseBody
    public ReturnInfoHelper queryUser() {
        ReturnInfoHelper returnInfoHelper = new ReturnInfoHelper();
        try {
            List<User> users = this.userService.queryUser();
            returnInfoHelper.setData(users);
        } catch (Exception e) {
            returnInfoHelper.setData(e);
            e.printStackTrace();
        }
        return returnInfoHelper;
    }

}
