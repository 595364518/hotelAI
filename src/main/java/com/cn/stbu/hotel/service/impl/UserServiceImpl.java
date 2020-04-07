package com.cn.stbu.hotel.service.impl;

import com.cn.stbu.hotel.domain.User;
import com.cn.stbu.hotel.mapper.UserMapper;
import com.cn.stbu.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * Datetime:    2020/4/4 0004   11:56
 * Author:  IDEA
 *
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper =null;
    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public User getUserByUid(String userId) {
        return userMapper.getUserByUid(userId);
    }

    @Override
    public User getUserByFid(String faceInfoId) {
        return userMapper.getUserByFid(faceInfoId);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int delUserByUid(String userId) {
        return userMapper.delUserByUid(userId);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
