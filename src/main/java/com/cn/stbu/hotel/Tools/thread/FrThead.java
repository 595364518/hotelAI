package com.cn.stbu.hotel.Tools.thread;

import com.arcsoft.face.FaceFeature;
import com.arcsoft.face.FunctionConfiguration;
import com.cn.stbu.hotel.Tools.face.MyFaceEngine;
import com.cn.stbu.hotel.Tools.listen.Event;
import com.cn.stbu.hotel.Tools.listen.FrResultListener;
import com.cn.stbu.hotel.domain.FaceInfo;
import com.cn.stbu.hotel.domain.MyFaceInfo;
import com.cn.stbu.hotel.domain.User;


import java.util.Hashtable;
import java.util.List;
import java.util.Queue;

/**
 * Description: Fr线程
 * Datetime:    2020/3/19 0019   22:33
 * Author:  IDEA
 */
//@Component
public class FrThead extends Thread{
    private Object lock;

    private Hashtable<Integer, MyFaceInfo> faceInfoSet;    //进入画面的人脸集合

    private Queue<MyFaceInfo> face_q;     //人脸队列

    private MyFaceEngine faceEngine;

    public MyFaceInfo faceInfo = null;

    private FrResultListener listener;

    public User user = null;    //识别到的用户
    public float s = 0;   //相似度

    public User getUser() {
        return user;
    }

    public float getSimilarity() {
        return s;
    }

    public MyFaceInfo getFaceInfo(){ return faceInfo; }

    //映射层不可用，用Demo代替
    FaceInfoMapperDemo faceInfoMapperDemo;      //人脸信息映射demo
    UserMapperDemo userMapperDemo ;             //用户映射demo


    public FrThead(Queue<MyFaceInfo> face_queue, String name, Object lock, Hashtable<Integer, MyFaceInfo> faceInfoSet) throws Exception {
//        userMapperDemo = new UserMapperDemo();
        faceInfoMapperDemo = new FaceInfoMapperDemo();
        userMapperDemo = new UserMapperDemo();
        this.setName(name);
        this.face_q = face_queue;
        this.lock = lock;
        this.faceInfoSet = faceInfoSet;
        this.faceEngine = new MyFaceEngine();
        //功能配置
        FunctionConfiguration functionConfiguration = new FunctionConfiguration();
        functionConfiguration.setSupportFace3dAngle(true);
        functionConfiguration.setSupportFaceDetect(true);
        functionConfiguration.setSupportFaceRecognition(true);
        faceEngine.engine_init(functionConfiguration);
        System.out.println("FR线程："+getName()+"初始化完成");
    }

    @Override
    public void run() {
        while(true){
            faceInfo = null;
            //查询是否有人脸要被识别
//            if(face_q.size() == 0){
//                try {
//                    lock.wait();        // 阻塞
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }else{
//                lock.notifyAll();   //激活等待线程
//            }

            synchronized (""){
                if(face_q.size() > 0) {
                    faceInfo = face_q.poll();
                }
            }
            if(faceInfo != null){
                int faceId = faceInfo.getFaceId();
                //查询id是否还存在
                if(faceInfoSet.containsKey(faceId)){
                    faceEngine.setImageInfo(faceInfo.getImageInfo());
                    FaceFeature faceFeature = faceEngine.detectFace(faceInfo);
//                    userMapper.findAll();
                    user = new User();
                    s = getUserByFeature(faceFeature,user); //匹配用户
                    trigger();  //触发 ，通知结果已生成生成事件
                }
            }

        }
    }

    //通过人脸特征值去匹配数据库用户
    private float getUserByFeature(FaceFeature target,User targetUser){
        List<FaceInfo> face_list = faceInfoMapperDemo.getList();
        float max = -10F;
        FaceInfo info = null;
        for(FaceInfo f : face_list){    //匹配特征
            FaceFeature source = MyFaceEngine.handleDBStr(f.getFaceFeature());
            float similarity = faceEngine.compareFace(target, source);
            if(similarity > max){   //获取最相似的用户
                max = similarity;
                info = f;
            }
        }
        if(max >= 0.4){
            this.s = max;
            User user = userMapperDemo.getUserByFaceInfoId(info.getFaceInfoId());    //匹配用户
            //对象深拷贝
            targetUser.setUser(user.getUserId(),user.getUsername(),user.getPassword(),user.getRealName(),user.getAge(),
                    user.getLimitId(),user.getFaceInfoId(),user.getIDCard(),user.getPhone(),user.getAddress());
            return max;
        }
        return max;
    }

    //监听触发
    public void trigger(){
        listener.doTrigger(new Event(this));
    }

    //注册监听
    public void registryListener(FrResultListener listener){
        this.listener = listener;
    }
}
