package com.cn.stbu.hotel;

import com.cn.stbu.hotel.domain.RolePermission;
import com.cn.stbu.hotel.domain.User;
import com.cn.stbu.hotel.domain.UserRole;
import com.cn.stbu.hotel.service.RolePermissionService;
import com.cn.stbu.hotel.service.UserRoleService;
import com.cn.stbu.hotel.service.UserService;
import com.cn.stbu.hotel.shiro.ShiroKit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelApplicationTests {

    @Autowired
    UserService userService = null;
    @Autowired
    UserRoleService userRoleService = null;
    @Autowired
    RolePermissionService rolePermissionService = null ;
    @Test
    public void contextLoads() {
        List<User> userList = userService.getUserList();
        System.out.println(userList.get(0).toString());
    }
    @Test
    public void testUser(){
        User user = userService.getUserByUsername("hxd");
        System.out.println(user.toString());
    }
    @Test
    public void Role(){

        List<UserRole> list = userRoleService.getUserRoleByUserId(2);
        for (UserRole ur : list) {
            System.out.println(ur.toString());
        }
    }

    @Test
    public void permission(){

        List<RolePermission> list = rolePermissionService.getRolePermissionListByRid(3);
        for (RolePermission rp : list) {
            System.out.println(rp.toString());
        }
    }
    @Test
    public void md5(){
        String pwd = "123";
        String salt = UUID.randomUUID().toString();
        String dbPwd = ShiroKit.md5(pwd, salt);
        System.out.println("salt: "+salt+", dbPwd:  "+dbPwd);
    }
}
