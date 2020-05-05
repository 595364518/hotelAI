package com.cn.stbu.hotel.domain;

import java.util.Date;

/**
 * 账单
 */
public class Records {

    private String records_id;
    private String user_id;
    private String records_type;        //消费类型
    private Boolean records_budget;     //收支
    private Double records_money;       //金额
    private Double records_balance;     //余额
    private String records_remarks;     //备注
    private Date records_date;          //时间

    public String getRecords_id() {
        return records_id;
    }

    public void setRecords_id(String records_id) {
        this.records_id = records_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRecords_type() {
        return records_type;
    }

    public void setRecords_type(String records_type) {
        this.records_type = records_type;
    }

    public Boolean getRecords_budget() {
        return records_budget;
    }

    public void setRecords_budget(Boolean records_budget) {
        this.records_budget = records_budget;
    }

    public Double getRecords_money() {
        return records_money;
    }

    public void setRecords_money(Double records_money) {
        this.records_money = records_money;
    }

    public Double getRecords_balance() {
        return records_balance;
    }

    public void setRecords_balance(Double records_balance) {
        this.records_balance = records_balance;
    }

    public String getRecords_remarks() {
        return records_remarks;
    }

    public void setRecords_remarks(String records_remarks) {
        this.records_remarks = records_remarks;
    }

    public Date getRecords_date() {
        return records_date;
    }

    public void setRecords_date(Date records_date) {
        this.records_date = records_date;
    }

    @Override
    public String toString() {
        return "Records{" +
                "records_id='" + records_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", records_type='" + records_type + '\'' +
                ", records_budget=" + records_budget +
                ", records_money=" + records_money +
                ", records_balance=" + records_balance +
                ", records_remarks='" + records_remarks + '\'' +
                ", records_date=" + records_date +
                '}';
    }

    public Records(String records_id, String user_id, String records_type, Boolean records_budget, Double records_money, Double records_balance, String records_remarks, Date records_date) {
        this.records_id = records_id;
        this.user_id = user_id;
        this.records_type = records_type;
        this.records_budget = records_budget;
        this.records_money = records_money;
        this.records_balance = records_balance;
        this.records_remarks = records_remarks;
        this.records_date = records_date;
    }
}
