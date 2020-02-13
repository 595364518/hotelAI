package com.cn.stbu.hotel.domain;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 01:54 2020/2/12
 */
public class FaceInfo {
    private String faceInfoId;
    private String imgName;
    private String faceImgPath;
    private String faceFeature;

    public String getFaceInfoId() {
        return faceInfoId;
    }

    public void setFaceInfoId(String faceInfoId) {
        this.faceInfoId = faceInfoId;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getFaceImgPath() {
        return faceImgPath;
    }

    public void setFaceImgPath(String faceImgPath) {
        this.faceImgPath = faceImgPath;
    }

    public String getFaceFeature() {
        return faceFeature;
    }

    public void setFaceFeature(String faceFeature) {
        this.faceFeature = faceFeature;
    }
}
