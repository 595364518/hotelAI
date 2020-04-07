package com.cn.stbu.hotel.service;

import com.cn.stbu.hotel.domain.UserRole;

import java.util.List;

/**
 * Description:
 * Datetime:    2020/4/4 0004   12:04
 * Author:  IDEA
 */

public interface UserRoleService {
    //通过用户id获取用户角色
    List<UserRole> getUserRoleByUserId(String userId);
    //通过表单id获取
    UserRole getUserRoleById(String id);
    //增加用户角色
    int addUserRole(UserRole userRole);
    //通过表单id删除用户角色
    int delUserRoleById(String id);
    //修改用户角色
    int updateUserRole(UserRole userRole);
}
