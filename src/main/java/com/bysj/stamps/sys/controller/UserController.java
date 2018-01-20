package com.bysj.stamps.sys.controller;

import com.bysj.stamps.common.ReturnInfoHelper;
import com.bysj.stamps.sys.model.User;
import com.bysj.stamps.sys.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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
    public ReturnInfoHelper queryUser(String username) {
        ReturnInfoHelper returnInfoHelper = new ReturnInfoHelper();
        try {
            User users = this.userService.queryUser(username);
            returnInfoHelper.setData(users);
        } catch (Exception e) {
            returnInfoHelper.setData(e);
            e.printStackTrace();
        }
        return returnInfoHelper;
    }

    @RequestMapping("/loginUser")
    public String loginUser(String username, String password, HttpSession session) {
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            //完成登录
            subject.login(usernamePasswordToken);
            User user = (User) subject.getPrincipal();
            user.setPassword("********");
            session.setAttribute("user", user);
            return "index";
        } catch (Exception e) {
            //返回登录页面
            return "login";
        }

    }

    @RequestMapping("/login")
    @ResponseBody
    public String hi() {
        return "hi";
    }

}
