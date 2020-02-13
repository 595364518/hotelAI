package com.cn.stbu.hotel.mapper;

import com.cn.stbu.hotel.domain.FaceInfo;
import com.cn.stbu.hotel.domain.PayRecord;

import java.util.List;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 02:53 2020/2/12
 */
public interface PayRecordMapper {

    List<PayRecord> getPayRecordList();

    List<PayRecord> getPayRecordListByTime(String startT, String endT);

    int addPayRecord(PayRecord payRecord);

    int delPayRecordByPayRecordId(String payRecordId);

    FaceInfo getPayRecordByPayRecordId(String payRecordId);

    int updatePayRecord(PayRecord payRecord);


}
