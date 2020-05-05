package com.cn.stbu.hotel.service;

import com.cn.stbu.hotel.domain.Records;

import java.util.List;

public interface RecordsService {
    void addRecords(Records records);
    List<Records> findRecordsAll(String user_id);
}
