package com.cn.stbu.hotel.Utils.face;

import com.arcsoft.face.*;
import com.arcsoft.face.enums.DetectMode;
import com.arcsoft.face.enums.DetectOrient;
import com.arcsoft.face.enums.ErrorInfo;
import com.arcsoft.face.enums.ImageFormat;
import com.arcsoft.face.toolkit.ImageFactory;
import com.arcsoft.face.toolkit.ImageInfo;
import sun.awt.image.ToolkitImage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: MyFaceEngine
 * Datetime:    2020/3/13 0013   10:28
 * Author:  HXD
 */
public class MyFaceEngine {

    private String appId = "9o7vKafPa8hyX3TNHSWQ9DeBgR9v5PpJ3JVdzGmzcgg2";
    private String sdkKey = "E7qRfekG7xyqXQzcmscm2K5mkkjzSMV1v8bMZWYUq9e7";
    private String libPath = "D:\\Arcsoft_ArcFace_SDK\\libs\\WIN64";

    private FaceEngine faceEngine = null;    //引擎核心
    private ImageInfo imageInfo = null;     //人脸图像对象
    private DetectMode detectMode = DetectMode.ASF_DETECT_MODE_VIDEO; //算法模式  默认：video模式

    public void setVideoMode() {
        this.detectMode = DetectMode.ASF_DETECT_MODE_VIDEO;
    }
    public void setImageMode() {
        this.detectMode = DetectMode.ASF_DETECT_MODE_IMAGE;
    }

    public static final float MIN_SIMLI =  0.75f;      //最低相似度阀值

    public ImageInfo getImageInfo() {
        return imageInfo;
    }

    public void setImageInfo(ImageInfo imageInfo) {
        this.imageInfo = imageInfo;
    }

    public MyFaceEngine(){
        faceEngine = new FaceEngine(libPath);
    }

    /**
     * 初始化引擎  :激活  +  配置  + 功能
     * */
    public void engine_init(FunctionConfiguration functionConfiguration) throws Exception {
        //激活引擎
        int activeCode = faceEngine.activeOnline(appId, sdkKey);
        if (activeCode != ErrorInfo.MOK.getValue() && activeCode != ErrorInfo.MERR_ASF_ALREADY_ACTIVATED.getValue()) {
            throw new Exception("引擎激活失败");
        }

        //引擎配置  根据需要修改
        EngineConfiguration engineConfiguration = new EngineConfiguration();
        engineConfiguration.setDetectMode(detectMode);
        engineConfiguration.setDetectFaceOrientPriority(DetectOrient.ASF_OP_0_ONLY);

        //功能配置
        engineConfiguration.setFunctionConfiguration(functionConfiguration);
        //初始化引擎
        int initCode = faceEngine.init(engineConfiguration);
        if (initCode != ErrorInfo.MOK.getValue()) {
            throw new Exception("初始化引擎失败");
        }
    }

    /**
     * 生成图像信息实例
     * */
    public void geneImageInfoByImage(Image img){
        if(img instanceof ToolkitImage) img=((ToolkitImage)img).getBufferedImage();
        imageInfo = ImageFactory.bufferedImage2ImageInfo((BufferedImage) img);
    }


    /**
     * 返回人脸信息集合
     * */
    public  List<FaceInfo> getFaceInfo(){
        List<FaceInfo> faceInfoList = new ArrayList<FaceInfo>();
        int detectCode = faceEngine.detectFaces(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList);
        if(faceInfoList.isEmpty()) return null;
        else return faceInfoList;
    }

    /**
     * 获取人脸特征值
     * */
    public  FaceFeature detectFace(FaceInfo faceInfo){
        //特征提取
        FaceFeature faceFeature = new FaceFeature();
        int extractCode = faceEngine.extractFaceFeature(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfo, faceFeature);
        return  faceFeature;
    }
    /**
     * 将两张人脸特征值进行比对 ，返回一个相似度
     * */
    public float compareFace(FaceFeature targetFeature,FaceFeature sourceFeature){
        FaceSimilar faceSimilar = new FaceSimilar();
        int processCode = faceEngine.compareFaceFeature(targetFeature,sourceFeature,faceSimilar);
        return faceSimilar.getScore();
    }

    /**
     * 活体检测 ，返回识别到的活体数目,错误返回    -1
     * */
    public List<LivenessInfo> getLiveness(List<FaceInfo> faceInfoList) throws Exception {
        //活体检测

        FunctionConfiguration configuration = new FunctionConfiguration();
        configuration.setSupportLiveness(true);

        int processCode = faceEngine.process(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList, configuration);


        List<LivenessInfo> livenessInfoList = new ArrayList<LivenessInfo>();
        int livenessCode = faceEngine.getLiveness(livenessInfoList);
        if(livenessInfoList.isEmpty()) {
            throw new Exception("活体：检测失败");
        }
        return livenessInfoList;
    }

    /**
     * 关闭引擎
     * */
    public  void exitEngine(){
//        //获取激活文件信息
//        ActiveFileInfo activeFileInfo = new ActiveFileInfo();
//        int activeFileCode = faceEngine.getActiveFileInfo(activeFileInfo);
        //引擎卸载
        int unInitCode = faceEngine.unInit();
    }


    /**
     * 通过面部特征字符串特征
     * @Param  数据库存放的特征字符串
     * @Return  FaceFeature
     * */
    public static FaceFeature handleDBStr(String dataStr){
        FaceFeature faceFeature = new FaceFeature();
        //处理字符串信息
        String[] array = dataStr.split("\\.");
        byte [] data = new byte[1032];
        System.out.println(array.length);
        for(int i=0;i<1032;i++){
            data[i] = Byte.parseByte(array[i]) ;
        }
        faceFeature.setFeatureData(data);

        //返回面部特征
        return faceFeature;
    }


    /**
     * 获取人脸二进制数据 ,以字符串转存
     * @Param FaceFeature ，人脸特征对象
     * @Return String ,特征字符串
     * */
    public static String featureToDBstr(FaceFeature feature){
        String dbStr = "";
        byte[] faceData = feature.getFeatureData();
        for(byte a : faceData){
            dbStr = dbStr + a + ".";
        }
        return dbStr;
    }

}
