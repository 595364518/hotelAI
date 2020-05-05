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
    private String userId;
    private int status;
    private Timestamp ciTime;
    private Timestamp coTime;
    private String roomOrderId;

    public String getCIId() {
        return CIId;
    }

    public void setCIId(String CIId) {
        this.CIId = CIId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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

    public String getRoomOrderId() {
        return roomOrderId;
    }

    public void setRoomOrderId(String roomOrderId) {
        this.roomOrderId = roomOrderId;
    }

    @Override
    public String toString() {
        return "CheckinRecord{" +
                "CIId='" + CIId + '\'' +
                ", userId='" + userId + '\'' +
                ", status=" + status +
                ", ciTime=" + ciTime +
                ", coTime=" + coTime +
                ", roomOrderId='" + roomOrderId + '\'' +
                '}';
    }

    public CheckinRecord() {
    }

    public CheckinRecord(String CIId, String userId, int status, Timestamp ciTime, Timestamp coTime, String roomOrderId) {
        this.CIId = CIId;
        this.userId = userId;
        this.status = status;
        this.ciTime = ciTime;
        this.coTime = coTime;
        this.roomOrderId = roomOrderId;
    }
}
