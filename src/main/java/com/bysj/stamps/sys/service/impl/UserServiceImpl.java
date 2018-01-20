package com.bysj.stamps.sys.service.impl;

import com.bysj.stamps.sys.dao.SysUserDao;
import com.bysj.stamps.sys.model.User;
import com.bysj.stamps.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lihf
 * @version 1.0
 * @address 邮政
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUserDao sysUserDao;
    @Override
    public User queryUser(String username) {
        return this.sysUserDao.queryUser(username);
    }
}
