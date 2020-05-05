package com.cn.stbu.hotel.service.impl;

import com.cn.stbu.hotel.domain.Records;
import com.cn.stbu.hotel.mapper.RecordsMapper;
import com.cn.stbu.hotel.service.RecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordsServiceImpl implements RecordsService {

    @Autowired
    private RecordsMapper recordsMapper;

    @Override
    public void addRecords(Records records) {
        recordsMapper.addRecords(records);
    }

    @Override
    public List<Records> findRecordsAll(String user_id) {
        return recordsMapper.findRecordsAll(user_id);
    }
}
