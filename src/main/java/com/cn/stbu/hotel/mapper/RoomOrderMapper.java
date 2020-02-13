package com.cn.stbu.hotel.mapper;

import com.cn.stbu.hotel.domain.RoomOrder;

import java.util.List;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 02:54 2020/2/12
 */
public interface RoomOrderMapper {

    List<RoomOrder> getRoomOrderList(RoomOrder roomOrder);

    int addRoomOrder(RoomOrder roomOrder);

    int delRoomOrderByROid(String roomOrderId);

    RoomOrder getRoomOrderByROid(String roomOrderId);

    int updateRoomOrder(RoomOrder roomOrder);


}
