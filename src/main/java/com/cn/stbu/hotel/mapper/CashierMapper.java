package com.cn.stbu.hotel.mapper;

import com.cn.stbu.hotel.domain.Cashier;

import java.util.List;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 02:52 2020/2/12
 */
public interface CashierMapper {

    List<Cashier> getCashierList();

    Cashier getCashierByCashierId(int cashierId);

    int addCashier(Cashier cashier);

    int delCashierByCashierId(int cashierId);

    int updateCashier(Cashier cashier);
}
