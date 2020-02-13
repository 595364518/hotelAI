package com.cn.stbu.hotel.domain;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 01:31 2020/2/12
 */
public class Amount {
    private int amountId;
    private int userId;
    private double balance;
    private double oweMoney;

    public Amount(int userId, double balance, double oweMoney) {
        this.userId = userId;
        this.balance = balance;
        this.oweMoney = oweMoney;
    }

    public int getAmountId() {
        return amountId;
    }

    public void setAmountId(int amountId) {
        this.amountId = amountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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
