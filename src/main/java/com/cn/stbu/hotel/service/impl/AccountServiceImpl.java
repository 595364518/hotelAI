package com.cn.stbu.hotel.service.impl;

import com.cn.stbu.hotel.domain.Account;
import com.cn.stbu.hotel.mapper.AccountMapper;
import com.cn.stbu.hotel.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> getAccountList() {
        return accountMapper.getAccountList();
    }

    @Override
    public Account findAccountByUserId(String user_id) {
        return accountMapper.findAccountByUserId(user_id);
    }

    @Override
    public int addAccount(Account account) {
        return accountMapper.addAccount(account);
    }

    @Override
    public int updateAccount(Account account) {
        return accountMapper.updateAccount(account);
    }

    @Override
    public int delAccountByAccountId(String accountId) {
        return accountMapper.delAccountByAccountId(accountId);
    }

    @Override
    public Account getAccountByAccountId(String accountId) {
        return accountMapper.getAccountByAccountId(accountId);
    }
}
