package com.cn.stbu.hotel.mapper;

import com.cn.stbu.hotel.domain.Amount;

import java.util.List;

/**
 * @Author: yaya
 * @Description:      账户操作
 * @Date: Create in 下午 02:52 2020/2/12
 */
public interface AmountMapper {

   List<Amount> getAmountList();

   int addAmount(Amount amount);

   int updateAmount(Amount amount);

   int delAmountByAmountId(int amountId);

   Amount getAmountByAmountId(int amountId);

}
