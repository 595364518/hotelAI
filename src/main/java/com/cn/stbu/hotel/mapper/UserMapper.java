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

    User getUserByUid(int id);

    int addUser(User user);

    int delUserByUid(int id);

    int updateUser(User user);
}
