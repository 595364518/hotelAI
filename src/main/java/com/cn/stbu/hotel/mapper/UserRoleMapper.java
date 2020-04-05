package com.cn.stbu.hotel.mapper;


import com.cn.stbu.hotel.domain.UserRole;

import java.util.List;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 02:54 2020/2/12
 */
public interface UserRoleMapper {

    //通过用户id获取用户角色
    List<UserRole> getUserRoleByUserId(int userId);
    //通过表单id获取
    UserRole getUserRoleById(int id);
    //增加用户角色
    int addUserRole(UserRole userRole);
    //通过表单id删除用户角色
    int delUserRoleById(int id);
    //修改用户角色
    int updateUserRole(UserRole userRole);
}
