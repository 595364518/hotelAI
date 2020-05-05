package com.cn.stbu.hotel.service.impl;

import com.cn.stbu.hotel.domain.RoomOrder;
import com.cn.stbu.hotel.mapper.RoomOrderMapper;
import com.cn.stbu.hotel.service.RoomOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomOrderServiceImpl implements RoomOrderService {

    @Autowired
    private RoomOrderMapper roomOrderMapper;

    @Override
    public List<RoomOrder> getRoomOrderList(RoomOrder roomOrder) {
        return roomOrderMapper.getRoomOrderList(roomOrder);
    }

    @Override
    public int addRoomOrder(RoomOrder roomOrder) {
        return roomOrderMapper.addRoomOrder(roomOrder);
    }

    @Override
    public int delRoomOrderByROid(String roomOrderId) {
        return roomOrderMapper.delRoomOrderByROid(roomOrderId);
    }

    @Override
    public RoomOrder getRoomOrderByROid(String roomOrderId) {
        return roomOrderMapper.getRoomOrderByROid(roomOrderId);
    }

    @Override
    public int updateRoomOrder(RoomOrder roomOrder) {
        return roomOrderMapper.updateRoomOrder(roomOrder);
    }

    @Override
    public List<RoomOrder> findAll() {
        return roomOrderMapper.findAll();
    }
}
