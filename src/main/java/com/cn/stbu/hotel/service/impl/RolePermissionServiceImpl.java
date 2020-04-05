package com.cn.stbu.hotel.service.impl;

import com.cn.stbu.hotel.domain.RolePermission;
import com.cn.stbu.hotel.mapper.RolePermissionMapper;
import com.cn.stbu.hotel.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * Datetime:    2020/4/4 0004   12:13
 * Author:  IDEA
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    RolePermissionMapper rolePermissionMapper = null;
    @Override
    public List<RolePermission> getRolePermissionListByRid(int roleId) {
        return rolePermissionMapper.getRolePermissionListByRid(roleId);
    }

    @Override
    public RolePermission getRolePermissionByLid(int id) {
        return rolePermissionMapper.getRolePermissionByLid(id);
    }

    @Override
    public int addRolePermission(RolePermission rolePermission) {
        return rolePermissionMapper.addRolePermission(rolePermission);
    }

    @Override
    public int delRolePermissionById(int id) {
        return rolePermissionMapper.delRolePermissionById(id);
    }

    @Override
    public int updateRolePermission(RolePermission rolePermission) {
        return rolePermissionMapper.updateRolePermission(rolePermission);
    }
}
