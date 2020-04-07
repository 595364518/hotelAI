package com.cn.stbu.hotel.service.impl;

import com.cn.stbu.hotel.domain.FaceInfo;
import com.cn.stbu.hotel.mapper.FaceInfoMapper;
import com.cn.stbu.hotel.service.FaceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * Datetime:    2020/4/6 0006   17:14
 * Author:  IDEA
 */
@Service
public class FaceInfoServiceImpl implements FaceInfoService {
    @Autowired
    FaceInfoMapper faceInfoMapper = null;
    @Override
    public List<FaceInfo> getFaceInfoList() {
        return faceInfoMapper.getFaceInfoList();
    }

    @Override
    public int addFaceInfo(FaceInfo faceInfo) {
        return faceInfoMapper.addFaceInfo(faceInfo);
    }

    @Override
    public int delFaceInfoByFaceInfoId(String faceInfoId) {
        return faceInfoMapper.delFaceInfoByFaceInfoId(faceInfoId);
    }

    @Override
    public FaceInfo getFaceInfoByFaceInfoId(String faceInfoId) {
        return faceInfoMapper.getFaceInfoByFaceInfoId(faceInfoId);
    }

    @Override
    public int updateFaceInfo(FaceInfo faceInfo) {
        return faceInfoMapper.updateFaceInfo(faceInfo);
    }
}
