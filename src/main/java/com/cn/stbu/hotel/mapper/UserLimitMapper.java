package com.cn.stbu.hotel.mapper;

import com.cn.stbu.hotel.domain.UserLimit;

import java.util.List;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 02:54 2020/2/12
 */
public interface UserLimitMapper {

    List<UserLimit> getUserLimitList();

    UserLimit getUserLimitByLid(int limitId);

    int addUserLimit(UserLimit userLimit);

    int delUserLimitByLid(int limitId);

    int updateUserLimit(UserLimit userLimit);
}
