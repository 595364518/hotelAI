package com.cn.stbu.hotel;

import com.cn.stbu.hotel.domain.User;
import com.cn.stbu.hotel.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelApplicationTests {

    @Autowired
    UserMapper userMapper = null;
    @Test
    public void contextLoads() {
        List<User> userList = userMapper.getUserList();
        System.out.println(userList.get(0).toString());
    }

}
