package com.cn.stbu.hotel.domain;


import com.arcsoft.face.toolkit.ImageInfo;
import com.arcsoft.face.FaceInfo;

/**
 * Description:
 * Datetime:    2020/3/13 0013   23:23
 * Author:  IDEA
 */
public class MyFaceInfo extends FaceInfo {

    boolean status;     //是否识别完成

    private int gender; //性别

    private int liveness; //活体属性

    private User user;  //识别到的用户

    private float scores;   //匹配相似度

    private ImageInfo imageInfo;     //人脸图像对象

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public float getScores() {
        return scores;
    }

    public void setScores(float scores) {
        this.scores = scores;
    }


    public ImageInfo getImageInfo() {
        return imageInfo;
    }

    public void setImageInfo(ImageInfo imageInfo) {
        this.imageInfo = imageInfo;
    }

    public MyFaceInfo(FaceInfo faceInfo, ImageInfo imageInfo , int liveness, boolean status) {
        setFaceId(faceInfo.getFaceId());
        setRect(faceInfo.getRect());
        setOrient(faceInfo.getOrient());
        this.liveness = liveness;
        this.status = status;
        this.imageInfo = imageInfo;
    }
    public MyFaceInfo(){}

    public int getLiveness() {
        return liveness;
    }

    public void setLiveness(int liveness) {
        this.liveness = liveness;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MyFaceInfo{"+
                "rect=" + getRect() +
                ",orient=" + getOrient()+
                ",status=" + status +
                ", liveness=" + liveness +
                '}';
    }
}
