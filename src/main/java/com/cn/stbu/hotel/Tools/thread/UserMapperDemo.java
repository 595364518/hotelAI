package com.cn.stbu.hotel.Tools.thread;

import com.cn.stbu.hotel.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Datetime:    2020/3/25 0025   21:30
 * Author:  IDEA
 *  * INSERT INTO `hotel_ai`.`users`(`user_id`, `username`, `password`, `real_name`, `age`, `limit_id`, `faceInfo_id`, `IDcard`, `phone`, `address`) VALUES (1, 'admin', 'aihotel', '何旭东', 22, 1, 'aaaa', '13213213212313', '1101321', '中国');
 */
public class UserMapperDemo {
    private List<User> list;

    public UserMapperDemo() {
        list = new ArrayList<User>();
        list.add(new User(1, "admin", "aihotel", "何旭东", 22, 1, "aaaa", "13213213212313", "1101321", "中国"));
    }

    public List<User> getList(){
        return list;
    }

    public User getUserByFaceInfoId(String faceInfo_id){
        for (User u: list) {
            if(u.getFaceInfoId() == faceInfo_id){
                return u;
            }
        }
        return null;
    }
}
