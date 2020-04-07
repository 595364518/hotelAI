package com.cn.stbu.hotel.Utils.thread;

import com.cn.stbu.hotel.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Datetime:    2020/3/25 0025   21:30
 * Author:  IDEA
 */
public class UserMapperDemo {
    private List<User> list;

    public UserMapperDemo() {
        list = new ArrayList<User>();
//        list.add(new User(2, "user", "aihotel","", "梁海彬",1,"",21, "456465465468","bbbb","", "7545646544","", "中国",""));
//        list.add(new User(1, "admin", "aihotel","", "何旭东", 22, "1997-04-05", "aaaa", "13213213212313", "1101321", "中国"));
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
