package com.cn.stbu.hotel.service;

import com.cn.stbu.hotel.domain.User;

import java.util.List;

/**
 * Description:
 * Datetime:    2020/4/4 0004   11:55
 * Author:  IDEA
 */
public interface UserService {
    User getUserByUsername(String username);

    List<User> getUserList();

    User getUserByUid(int id);

    int addUser(User user);

    int delUserByUid(int id);

    int updateUser(User user);
}
