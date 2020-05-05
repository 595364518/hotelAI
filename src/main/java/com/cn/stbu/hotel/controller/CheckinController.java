package com.cn.stbu.hotel.controller;

import com.cn.stbu.hotel.domain.CheckinRecord;
import com.cn.stbu.hotel.domain.Result;
import com.cn.stbu.hotel.domain.RoomOrder;
import com.cn.stbu.hotel.service.CheckinService;
import com.cn.stbu.hotel.service.RoomOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api")
public class CheckinController {

    @Autowired
    private CheckinService checkinService;

    @Autowired
    private RoomOrderService roomOrderService;

    @RequestMapping("/findcheckin")
    @ResponseBody
    public Result findCheckin(){
        Result result = new Result();
        List<CheckinRecord> checkinRecords = checkinService.getCheckinRecords();
        result.setCode("901");
        result.setData(checkinRecords);
        return result;
    }

    @RequestMapping("/findcheckinone")
    @ResponseBody
    public Result findCheckinOne(@RequestBody String CIId){
        Result result = new Result();
        if (StringUtils.isEmpty(CIId)){
            result.setCode("906");
            return result;
        }
        CheckinRecord checkinRecordByCIId = checkinService.getCheckinRecordByCIId(CIId);
        if (checkinRecordByCIId == null){
            result.setCode("902");
            return result;
        }
        result.setCode("901");
        result.setData(checkinRecordByCIId);
        return result;
    }

    @RequestMapping("/addcheckin")
    @ResponseBody
    public Result addCheckin(@RequestBody CheckinRecord checkinRecord){
        Result result = new Result();
        if (StringUtils.isEmpty(checkinRecord.getUserId())){
            result.setCode("904");
            return result;
        }
        if (checkinRecord.getCiTime() == null || checkinRecord.getCoTime() == null){
            result.setCode("903");
            return result;
        }
        String roomId = checkinRecord.getRoomOrderId();
        RoomOrder roomOrderByROid = roomOrderService.getRoomOrderByROid(roomId);
        if (roomOrderByROid == null){
            result.setCode("910");
            return result;
        }
        if (roomOrderByROid.getUserId() != null){
            result.setCode("911");
            return result;
        }

        roomOrderByROid.setUserId(checkinRecord.getUserId());
        roomOrderByROid.setStartTime(checkinRecord.getCiTime());
        roomOrderByROid.setEndTime(checkinRecord.getCoTime());

        roomOrderService.updateRoomOrder(roomOrderByROid);
        checkinRecord.setCIId(UUID.randomUUID().toString());
        checkinRecord.setStatus(1);
        checkinService.addCheckinRecord(checkinRecord);
        result.setCode("905");
        result.setData(checkinRecord);
        return result;
    }

    @RequestMapping("/outcheckin")
    @ResponseBody
    public Result outCheckin(@RequestBody String CIId){
        Result result = new Result();
        if (StringUtils.isEmpty(CIId)){
            result.setCode("906");
            return result;
        }
        CheckinRecord checkinRecordByCIId = checkinService.getCheckinRecordByCIId(CIId);
        if (checkinRecordByCIId == null){
            result.setCode("902");
            return result;
        }
        if (checkinRecordByCIId.getStatus() == 0){
            result.setCode("908");
            return result;
        }

        System.out.println(checkinRecordByCIId);
        String roomId = checkinRecordByCIId.getRoomOrderId();
        RoomOrder roomOrderByROid = roomOrderService.getRoomOrderByROid(roomId);

        if (roomOrderByROid == null){
            result.setCode("910");
            return result;
        }

        roomOrderByROid.setUserId(null);
        roomOrderByROid.setStartTime(null);
        roomOrderByROid.setEndTime(null);

        roomOrderService.updateRoomOrder(roomOrderByROid);
        checkinRecordByCIId.setStatus(0);
        checkinService.updateCheckinRecord(checkinRecordByCIId);
        long time = checkinRecordByCIId.getCoTime().getTime() - checkinRecordByCIId.getCiTime().getTime();
        double h = ((double)time) / (1000*60*60);
        System.out.println(h);
        result.setCode("907");
        result.setData(checkinRecordByCIId);
        return result;
    }

    @RequestMapping("/updatecheckin")
    @ResponseBody
    public Result updateCheckin(@RequestBody CheckinRecord checkinRecord){
        Result result = new Result();
        if (StringUtils.isEmpty(checkinRecord.getCIId())){
            result.setCode("906");
            return result;
        }
        if (checkinRecord.getCiTime() == null || checkinRecord.getCoTime() == null){
            result.setCode("903");
            return result;
        }
        CheckinRecord checkinRecordByCIId = checkinService.getCheckinRecordByCIId(checkinRecord.getCIId());
        if (checkinRecordByCIId == null){
            result.setCode("902");
            return result;
        }
        if (checkinRecordByCIId.getStatus() == 0){
            result.setCode("912");
            return result;
        }

        String roomId = checkinRecordByCIId.getRoomOrderId();
        RoomOrder roomOrderByROid = roomOrderService.getRoomOrderByROid(roomId);

        if (roomOrderByROid == null){
            result.setCode("910");
            return result;
        }

        roomOrderByROid.setStartTime(checkinRecord.getCiTime());
        roomOrderByROid.setEndTime(checkinRecord.getCoTime());

        checkinRecordByCIId.setCiTime(checkinRecord.getCiTime());
        checkinRecordByCIId.setCoTime(checkinRecord.getCoTime());

        roomOrderService.updateRoomOrder(roomOrderByROid);
        checkinService.updateCheckinRecord(checkinRecordByCIId);
        result.setCode("909");
        result.setData(checkinRecordByCIId);
        return result;
    }
}
