package com.cn.stbu.hotel.domain;

import java.sql.Timestamp;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 02:01 2020/2/12
 */
public class RoomOrder {
    private String roomOrderId;
    private String userId;
    private double sale;
    private Timestamp bookTime;
    private Timestamp startTime;
    private Timestamp endTime;

    @Override
    public String toString() {
        return "RoomOrder{" +
                "roomOrderId='" + roomOrderId + '\'' +
                ", userId='" + userId + '\'' +
                ", sale=" + sale +
                ", bookTime=" + bookTime +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    public String getRoomOrderId() {
        return roomOrderId;
    }

    public void setRoomOrderId(String roomOrderId) {
        this.roomOrderId = roomOrderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    public Timestamp getBookTime() {
        return bookTime;
    }

    public void setBookTime(Timestamp bookTime) {
        this.bookTime = bookTime;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }
}
