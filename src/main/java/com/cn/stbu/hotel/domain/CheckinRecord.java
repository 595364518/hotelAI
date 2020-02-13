package com.cn.stbu.hotel.domain;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 01:51 2020/2/12
 */
public class CheckinRecord {
    private String CIId;
    private int userId;
    private int status;
    private Timestamp ciTime;
    private Timestamp coTime;
    private String cDescribe;

    public CheckinRecord(String CIId, int userId, int status, Timestamp ciTime, Timestamp coTime, String cDescribe) {
        this.CIId = UUID.randomUUID().toString();
        System.out.println("uuid:"+CIId);
        this.userId = userId;
        this.status = status;
        this.ciTime = ciTime;
        this.coTime = coTime;
        this.cDescribe = cDescribe;
    }

    public String getCIId() {
        return CIId;
    }

    public void setCIId(String CIId) {
        this.CIId = CIId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getCiTime() {
        return ciTime;
    }

    public void setCiTime(Timestamp ciTime) {
        this.ciTime = ciTime;
    }

    public Timestamp getCoTime() {
        return coTime;
    }

    public void setCoTime(Timestamp coTime) {
        this.coTime = coTime;
    }

    public String getcDescribe() {
        return cDescribe;
    }

    public void setcDescribe(String cDescribe) {
        this.cDescribe = cDescribe;
    }
}
