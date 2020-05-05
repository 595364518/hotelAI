package com.cn.stbu.hotel.mapper;

import com.cn.stbu.hotel.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 02:32 2020/2/12
 */
@Mapper
public interface UserMapper {

    void updatePwd(User user);

    void updateHead(User user);

    void updateAcc(User user);

    User getUserByUsername(String username);

    List<User> getUserList();

    User getUserByUid(String userId);

    User getUserByFid(String faceInfoId);

    int addUser(User user);

    int delUserByUid(String userId);

    int updateUser(User user);
}
