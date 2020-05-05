package com.cn.stbu.hotel.service;

import com.cn.stbu.hotel.domain.RoomOrder;

import java.util.List;

public interface RoomOrderService {

    List<RoomOrder> getRoomOrderList(RoomOrder roomOrder);

    int addRoomOrder(RoomOrder roomOrder);

    int delRoomOrderByROid(String roomOrderId);

    RoomOrder getRoomOrderByROid(String roomOrderId);

    int updateRoomOrder(RoomOrder roomOrder);

    List<RoomOrder> findAll();

}
