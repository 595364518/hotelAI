package com.cn.stbu.hotel.service;

import com.cn.stbu.hotel.domain.FaceInfo;

import java.util.List;

/**
 * Description:
 * Datetime:    2020/4/6 0006   17:13
 * Author:  IDEA
 */
public interface FaceInfoService {
    List<FaceInfo> getFaceInfoList();

    int addFaceInfo(FaceInfo faceInfo);

    int delFaceInfoByFaceInfoId(String faceInfoId);

    FaceInfo getFaceInfoByFaceInfoId(String faceInfoId);

    int updateFaceInfo(FaceInfo faceInfo);
}
