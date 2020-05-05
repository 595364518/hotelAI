package com.cn.stbu.hotel.service;

import com.cn.stbu.hotel.domain.Account;

import java.util.List;

public interface AccountService {

    List<Account> getAccountList();

    Account findAccountByUserId(String user_id);

    int addAccount(Account account);

    int updateAccount(Account account);

    int delAccountByAccountId(String accountId);

    Account getAccountByAccountId(String accountId);

}
