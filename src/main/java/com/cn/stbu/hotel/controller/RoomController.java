package com.cn.stbu.hotel.controller;

import com.cn.stbu.hotel.domain.Result;
import com.cn.stbu.hotel.domain.RoomOrder;
import com.cn.stbu.hotel.service.RoomOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api")
public class RoomController {

    @Autowired
    private RoomOrderService roomOrderService;

    @RequestMapping("/addroom")
    @ResponseBody
    public Result addRoom(@RequestBody RoomOrder roomOrder){
        Result result = new Result();
        if (StringUtils.isEmpty(roomOrder.getRoomOrderId())){
            result.setCode("1100");
            return result;
        }
        if (roomOrder.getSale() <= 0){
            result.setCode("1101");
            return result;
        }
        roomOrderService.addRoomOrder(roomOrder);
        result.setCode("1102");
        return result;
    }

    @RequestMapping("/updateroom")
    @ResponseBody
    public Result updateRoom(@RequestBody RoomOrder roomOrder){
        Result result = new Result();
        if (StringUtils.isEmpty(roomOrder.getRoomOrderId())){
            result.setCode("1100");
            return result;
        }
        RoomOrder roomOrderByROid = roomOrderService.getRoomOrderByROid(roomOrder.getRoomOrderId());
        if (roomOrderByROid == null){
            result.setCode("1104");
            return result;
        }
        if (!StringUtils.isEmpty(roomOrderByROid.getUserId())){
            result.setCode("1107");
            return result;
        }
        if (roomOrder.getSale() <= 0){
            result.setCode("1101");
            return result;
        }
        roomOrder.setUserId(null);
        roomOrder.setStartTime(null);
        roomOrder.setEndTime(null);
        roomOrderService.updateRoomOrder(roomOrder);
        result.setCode("1105");
        return result;
    }

    @RequestMapping("/delroom")
    @ResponseBody
    public Result delRoom(@RequestBody String roomOrderId) {
        Result result = new Result();
        if (StringUtils.isEmpty(roomOrderId)){
            result.setCode("1100");
            return result;
        }
        RoomOrder roomOrderByROid = roomOrderService.getRoomOrderByROid(roomOrderId);
        if (roomOrderByROid == null){
            result.setCode("1104");
            return result;
        }
        roomOrderService.delRoomOrderByROid(roomOrderId);
        result.setCode("1106");
        return result;
    }

    @RequestMapping("/findroom")
    @ResponseBody
    public Result findRoom(){
        Result result = new Result();
        List<RoomOrder> all = roomOrderService.findAll();
        result.setCode("1103");
        result.setData(all);
        return result;
    }


}
