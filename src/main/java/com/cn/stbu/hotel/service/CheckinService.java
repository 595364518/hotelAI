package com.cn.stbu.hotel.service;

import com.cn.stbu.hotel.domain.CheckinRecord;

import java.util.List;

public interface CheckinService {
    List<CheckinRecord> getCheckinRecords();

    CheckinRecord getCheckinRecordByCIId(String CIId);

    int addCheckinRecord(CheckinRecord checkinRecord);

    int delCheckinRecordByCIId(String CIId);

    int updateCheckinRecord(CheckinRecord checkinRecord);
}
