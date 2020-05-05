package com.cn.stbu.hotel.mapper;

import com.cn.stbu.hotel.domain.Records;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecordsMapper {

    void addRecords(Records records);
    List<Records> findRecordsAll(String user_id);

}
