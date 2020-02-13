package com.cn.stbu.hotel.domain;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 01:58 2020/2/12
 */
public class Product {
    private int productId;
    private String pName;
    private int classId;
    private double sale;
    private int pSurplus;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    public int getpSurplus() {
        return pSurplus;
    }

    public void setpSurplus(int pSurplus) {
        this.pSurplus = pSurplus;
    }
}
