package com.cn.stbu.hotel.service;

import com.cn.stbu.hotel.domain.RolePermission;

import java.util.List;

/**
 * Description:
 * Datetime:    2020/4/4 0004   12:12
 * Author:  IDEA
 */
public interface RolePermissionService {
    //通过角色ID查询权限
    List<RolePermission> getRolePermissionListByRid(int roleId);

    //通过表单id获取
    RolePermission getRolePermissionByLid(int id);
    //增加角色权限
    int addRolePermission(RolePermission rolePermission);
    //通过表单id删除
    int delRolePermissionById(int id);
    //修改角色权限
    int updateRolePermission(RolePermission rolePermission);
}
