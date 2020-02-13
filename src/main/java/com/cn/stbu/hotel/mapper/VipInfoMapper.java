package com.cn.stbu.hotel.mapper;

import com.cn.stbu.hotel.domain.VipInfo;

import java.util.List;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 02:55 2020/2/12
 */
public interface VipInfoMapper {

    List<VipInfo> getVipInfoList(VipInfo vipInfo);

    int addVipInfo(VipInfo vipInfo);

    int delVipInfoByVid(int vipId);

    VipInfo getVipInfoByVid(int vipId);

    int updateVipInfo(VipInfo vipInfo);
}
