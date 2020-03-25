package com.cn.stbu.hotel.domain;

import com.arcsoft.face.Rect;

/**
 * Description:
 * Datetime:    2020/3/13 0013   22:57
 * Author:  IDEA
 */
public class DetectResult {
    private int faceId;     //人脸id

    private Rect rect;  //位置

    private int gender; //性别

    private int liveness; //活体属性

    private User user;  //识别到的用户

    private float scores;   //匹配相似度

    public float getScores() {
        return scores;
    }

    public void setScores(float scores) {
        this.scores = scores;
    }

    public int getFaceId() {
        return faceId;
    }

    public void setFaceId(int faceId) {
        this.faceId = faceId;
    }

    public Rect getRect() {
        return rect;
    }

    public void setRect(Rect rect) {
        this.rect = rect;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getLiveness() {
        return liveness;
    }

    public void setLiveness(int liveness) {
        this.liveness = liveness;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "DetectResult{" +
                "faceId=" + faceId +
                ", rect=" + rect +
                ", gender=" + gender +
                ", liveness=" + liveness +
                ", user=" + user +
                '}';
    }
}
