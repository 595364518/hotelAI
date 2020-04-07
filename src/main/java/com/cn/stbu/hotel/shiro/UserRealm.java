package com.cn.stbu.hotel.shiro;

import com.cn.stbu.hotel.domain.RolePermission;
import com.cn.stbu.hotel.domain.User;
import com.cn.stbu.hotel.domain.UserRole;
import com.cn.stbu.hotel.service.RolePermissionService;
import com.cn.stbu.hotel.service.UserRoleService;
import com.cn.stbu.hotel.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import sun.security.provider.MD5;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: shiro的自定义 Realm
 * Datetime:    2020/4/2 0002   21:56
 * Author:  IDEA
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    public UserService userService = null ;
    @Autowired
    public RolePermissionService rolePermissionService = null;
    @Autowired
    public UserRoleService userRoleService = null;
    /*
    * 执行授权逻辑
    * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        //给资源进行授权
        SimpleAuthorizationInfo  authorizationInfo= new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();   //shiro主体
        User user = (User)subject.getPrincipal();   //当前登录用户
        List<UserRole> roles = userRoleService.getUserRoleByUserId(user.getUserId());//获取角色
        System.out.println(roles.size());

        //注入资源授权字符串
        for (UserRole ur:roles) {   //遍历角色
            List<RolePermission> permission = rolePermissionService.getRolePermissionListByRid(ur.getRoleId());
            for (RolePermission rp :permission) { //抓取资源字符串
                authorizationInfo.addStringPermission(rp.getPermission());
                System.out.println("注入权限:"+rp.getPermission());
            }
            authorizationInfo.addRole(ur.getName());
            System.out.println("添加角色："+ur.getName());
        }
        return authorizationInfo;
    }
    /*
    * 执行认证逻辑 login
    * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;  //获取用户信息

        User user = userService.getUserByUsername(token.getUsername());
        if(user== null){ //用户名不存在
            return null;    //shiro底层会抛出 UnKnowAccountException
        }
        //设置本账号的进过加密的密码 密码盐
        Md5Hash salt  = new Md5Hash(user.getSalt());
        return new SimpleAuthenticationInfo(user,user.getPassword(),salt,"");

    }
}
