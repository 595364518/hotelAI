package com.cn.stbu.hotel.service.impl;

import com.cn.stbu.hotel.domain.UserRole;
import com.cn.stbu.hotel.mapper.UserRoleMapper;
import com.cn.stbu.hotel.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * Datetime:    2020/4/4 0004   12:05
 * Author:  IDEA
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleMapper userRoleMapper = null;
    @Override
    public List<UserRole> getUserRoleByUserId(int userId) {
        return userRoleMapper.getUserRoleByUserId(userId);
    }

    @Override
    public UserRole getUserRoleById(int id) {
        return userRoleMapper.getUserRoleById(id);
    }

    @Override
    public int addUserRole(UserRole userRole) {
        return userRoleMapper.addUserRole(userRole);
    }

    @Override
    public int delUserRoleById(int id) {
        return userRoleMapper.delUserRoleById(id);
    }

    @Override
    public int updateUserRole(UserRole userRole) {
        return userRoleMapper.updateUserRole(userRole);
    }
}
