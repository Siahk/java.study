package com.heng.config;

import com.heng.pojo.User;
import com.heng.service.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

// 自定义的 UserRealm
public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserServiceImpl userService;
    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=>授权 doGetAuthorizationInfo");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // info.addStringPermission("user:add");
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();
//        if (currentUser.getPerms() == null) {
//            return null;
//        }
        info.addStringPermission(currentUser.getPerms());
        return info;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了=>认证 doGetAuthorizationInfo");
        // 用户名，密码（数据库中取）
//        String name = "root";
//        String password = "123456";
        // 连接正式的数据库
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        User user = userService.queryUserByName(usernamePasswordToken.getUsername());
        if (user == null) { // 没有这个人
            return null; //UnknownAccountException
        }

        if (!usernamePasswordToken.getUsername().equals(user.getName())) {
            return null; // 抛出异常， UnknownAccountException
        }
        // 密码认证，Shiro做
        return new SimpleAuthenticationInfo(user,user.getPwd(),"");
    }
}
