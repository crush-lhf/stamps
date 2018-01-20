package com.bysj.stamps.sys.shirocore;

import com.bysj.stamps.sys.model.Resource;
import com.bysj.stamps.sys.model.Role;
import com.bysj.stamps.sys.model.User;
import com.bysj.stamps.sys.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lihf
 * on 2017.12.19 location 邮政.
 */
@Service("authRealm")
public class MyShiroRealm extends AuthorizingRealm {
   @Autowired
   private UserService shiroService;

    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取session中的用户
        User user=(User) principals.fromRealm(this.getClass().getName()).iterator().next();
        List<String> permissions=new ArrayList<>();
        List<Role> roles = user.getRoles();
        if(roles.size()>0) {
            for(Role role : roles) {
                List<Resource> modules = role.getResources();
                if(modules.size()>0) {
                    for(Resource module : modules) {
                        permissions.add(module.getUrl());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        //将权限放入shiro中.
        info.addStringPermissions(permissions);
        return info;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户输入的token
        UsernamePasswordToken tokens=(UsernamePasswordToken) token;
        String username = tokens.getUsername();
        User user = shiroService.queryUser(username);
        return new SimpleAuthenticationInfo(user, user.getPassword(),AuthorizingRealm.class.getName());
    }
    }

