package com.cn.stbu.hotel.domain;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 02:02 2020/2/12
 */
public class User {
    private int userId;
    private String username;
    private String password;
    private String realName;
    private int age;
    private int limitId;
    private String faceInfoId;
    private String IDCard;
    private String phone;
    private String address;

    public User(String username, String password, String realName, int age, int limitId, String faceInfoId, String IDCard, String phone, String address) {
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.age = age;
        this.limitId = limitId;
        this.faceInfoId = faceInfoId;
        this.IDCard = IDCard;
        this.phone = phone;
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLimitId() {
        return limitId;
    }

    public void setLimitId(int limitId) {
        this.limitId = limitId;
    }

    public String getFaceInfoId() {
        return faceInfoId;
    }

    public void setFaceInfoId(String faceInfoId) {
        this.faceInfoId = faceInfoId;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
