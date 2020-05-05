package com.cn.stbu.hotel.service.impl;

import com.cn.stbu.hotel.domain.CheckinRecord;
import com.cn.stbu.hotel.mapper.CheckinRecordMapper;
import com.cn.stbu.hotel.service.CheckinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckinServiceImpl implements CheckinService {

    @Autowired
    private CheckinRecordMapper checkinRecordMapper;

    @Override
    public List<CheckinRecord> getCheckinRecords() {
        return checkinRecordMapper.getCheckinRecords();
    }

    @Override
    public CheckinRecord getCheckinRecordByCIId(String CIId) {
        return checkinRecordMapper.getCheckinRecordByCIId(CIId);
    }

    @Override
    public int addCheckinRecord(CheckinRecord checkinRecord) {
        return checkinRecordMapper.addCheckinRecord(checkinRecord);
    }

    @Override
    public int delCheckinRecordByCIId(String CIId) {
        return checkinRecordMapper.delCheckinRecordByCIId(CIId);
    }

    @Override
    public int updateCheckinRecord(CheckinRecord checkinRecord) {
        return checkinRecordMapper.updateCheckinRecord(checkinRecord);
    }
}
