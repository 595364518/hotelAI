package com.cn.stbu.hotel.mapper;

import com.cn.stbu.hotel.domain.CheckinRecord;

import java.util.List;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 02:53 2020/2/12
 */
public interface CheckinRecordMapper {

    List<CheckinRecord> getCheckinRecords();

    CheckinRecord getCheckinRecordByCIId(String CIId);

    int addCheckinRecord(CheckinRecord checkinRecord);

    int delCheckinRecordByCIId(String CIId);

    int updateCheckinRecord(CheckinRecord checkinRecord);

}
