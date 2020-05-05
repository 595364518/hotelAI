package com.cn.stbu.hotel.domain;


import java.util.Date;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 02:02 2020/2/12
 */
public class User {
    private String userId;  //用户ID
    private String accountId;   //账户id
    private String username;    //用户名
    private String password;    //密码
    private String salt;    //盐
    private String realName;    //真实姓名
    private int    gender;  //性别
    private String headImg; //头像
    private int age;        //年龄
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;  //格式： yyyy-MM-dd
    private String faceInfoId;  //人脸特征值
    private String IDCard;      //身份证号
    private String phone;       //电话
    private String email;       //邮箱
    private String address;     //地址
    private String signature;   //签名

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", realName='" + realName + '\'' +
                ", gender=" + gender +
                ", headImg='" + headImg + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", faceInfoId='" + faceInfoId + '\'' +
                ", IDCard='" + IDCard + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }

    public User(){}

    public User(String userId, String username, String password, String salt, String realName, int gender, String headImg,
                int age, Date birthDate, String faceInfoId, String IDCard, String phone, String email, String address, String signature) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.realName = realName;
        this.gender = gender;
        this.headImg = headImg;
        this.age = age;
        this.birthDate = birthDate;
        this.faceInfoId = faceInfoId;
        this.IDCard = IDCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.signature = signature;
    }
    public void setUser(String userId, String username, String password, String salt, String realName, int gender, String headImg,
                int age, Date birthDate, String faceInfoId, String IDCard, String phone, String email, String address, String signature) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.realName = realName;
        this.gender = gender;
        this.headImg = headImg;
        this.age = age;
        this.birthDate = birthDate;
        this.faceInfoId = faceInfoId;
        this.IDCard = IDCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.signature = signature;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthData() {
        return birthDate;
    }

    public void setBirthData(Date birthDate) {
        this.birthDate = birthDate;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
