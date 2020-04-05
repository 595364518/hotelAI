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
    private String salt;
    private String realName;
    private int age;
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String  brithData;  //格式： yyyy-MM-dd
    private String faceInfoId;
    private String IDCard;
    private String phone;
    private String address;

    public User(){}

    public User(int userId, String username, String password, String salt, String realName, int age, String brithData, String faceInfoId, String IDCard, String phone, String address) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.realName = realName;
        this.age = age;
        this.brithData = brithData;
        this.faceInfoId = faceInfoId;
        this.IDCard = IDCard;
        this.phone = phone;
        this.address = address;
    }
    public void setUser(int userId, String username, String password, String salt, String realName, int age, String brithData, String faceInfoId, String IDCard, String phone, String address) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.realName = realName;
        this.age = age;
        this.brithData = brithData;
        this.faceInfoId = faceInfoId;
        this.IDCard = IDCard;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", realName='" + realName + '\'' +
                ", age=" + age +
                ", brithData='" + brithData + '\'' +
                ", faceInfoId='" + faceInfoId + '\'' +
                ", IDCard='" + IDCard + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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

    public String getBrithData() {
        return brithData;
    }

    public void setBrithData(String brithData) {
        this.brithData = brithData;
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
