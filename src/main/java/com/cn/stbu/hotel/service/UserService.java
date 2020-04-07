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

    User getUserByUid(String userId);

    User getUserByFid(String faceInfoId);

    int addUser(User user);

    int delUserByUid(String userId);

    int updateUser(User user);
}
