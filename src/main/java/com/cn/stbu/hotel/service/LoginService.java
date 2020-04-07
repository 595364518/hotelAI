package com.cn.stbu.hotel.service;

import com.cn.stbu.hotel.domain.FaceInfo;
import com.cn.stbu.hotel.domain.User;
import com.cn.stbu.hotel.domain.UserRole;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description:
 * Datetime:    2020/4/7 0007   9:19
 * Author:  IDEA
 */
public interface LoginService {
    int register(FaceInfo faceInfo,User user, UserRole userRole);
}
