package com.cn.stbu.hotel.domain;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 01:31 2020/2/12
 */
public class Account {
    private String accountId;
    private String userId;
    private double balance;
    private double oweMoney;

    public Account(String userId, double balance, double oweMoney) {
        this.userId = userId;
        this.balance = balance;
        this.oweMoney = oweMoney;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getOweMoney() {
        return oweMoney;
    }

    public void setOweMoney(double oweMoney) {
        this.oweMoney = oweMoney;
    }
}
