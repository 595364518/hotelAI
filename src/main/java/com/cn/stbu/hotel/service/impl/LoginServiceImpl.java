package com.cn.stbu.hotel.service.impl;

import com.cn.stbu.hotel.domain.FaceInfo;
import com.cn.stbu.hotel.domain.User;
import com.cn.stbu.hotel.domain.UserRole;
import com.cn.stbu.hotel.service.FaceInfoService;
import com.cn.stbu.hotel.service.LoginService;
import com.cn.stbu.hotel.service.UserRoleService;
import com.cn.stbu.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description:
 * Datetime:    2020/4/7 0007   9:21
 * Author:  IDEA
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserService userService = null;
    @Autowired
    UserRoleService userRoleService = null;
    @Autowired
    FaceInfoService faceInfoService = null;


    /**
     * 注册
     * */
    @Override
    @Transactional
    public int register(FaceInfo faceInfo,User user, UserRole userRole) {
        if(faceInfoService.addFaceInfo(faceInfo) != 1){
            return -1;
        }
        if(userService.addUser(user) != 1){
            return -2;
        }
        if(userRoleService.addUserRole(userRole) != 1){
            return -3;
        }
        return 1;
    }
}
