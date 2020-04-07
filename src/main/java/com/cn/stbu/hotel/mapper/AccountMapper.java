package com.cn.stbu.hotel.mapper;


import com.cn.stbu.hotel.domain.Account;

import java.util.List;

/**
 * @Author: yaya
 * @Description:      账户操作
 * @Date: Create in 下午 02:52 2020/2/12
 */
public interface AccountMapper {

   List<Account> getAccountList();

   int addAccount(Account account);

   int updateAccount(Account account);

   int delAccountByAccountId(String accountId);

   Account getAccountByAccountId(String accountId);

}
