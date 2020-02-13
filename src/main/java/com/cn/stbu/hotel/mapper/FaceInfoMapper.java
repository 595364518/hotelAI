package com.cn.stbu.hotel.mapper;

import com.cn.stbu.hotel.domain.FaceInfo;

import java.util.List;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 02:53 2020/2/12
 */
public interface FaceInfoMapper {

    List<FaceInfo> getFaceInfoList();

    int addFaceInfo(FaceInfo faceInfo);

    int delFaceInfoByFaceInfoId(String faceInfoId);

    FaceInfo getFaceInfoByFaceInfoId(String faceInfoId);

    int updateFaceInfo(FaceInfo faceInfo);
}
