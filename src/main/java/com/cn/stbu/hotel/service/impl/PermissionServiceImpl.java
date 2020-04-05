package com.cn.stbu.hotel.service.impl;

import com.cn.stbu.hotel.domain.Permission;
import com.cn.stbu.hotel.mapper.PermissionMapper;
import com.cn.stbu.hotel.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * Datetime:    2020/4/4 0004   13:07
 * Author:  IDEA
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionMapper permissionMapper = null;
    @Override
    public List<Permission> findAll() {
        return permissionMapper.findAll();
    }
}
