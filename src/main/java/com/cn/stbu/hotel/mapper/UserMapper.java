package com.cn.stbu.hotel.mapper;

import com.cn.stbu.hotel.domain.User;

import java.util.List;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 02:32 2020/2/12
 */
public interface UserMapper {

    User getUserByUsername(String username);

    List<User> getUserList();

    User getUserByUid(String userId);

    User getUserByFid(String faceInfoId);

    int addUser(User user);

    int delUserByUid(String userId);

    int updateUser(User user);
}
