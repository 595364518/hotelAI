package com.cn.stbu.hotel.controller;

import com.arcsoft.face.*;
import com.cn.stbu.hotel.Utils.face.MyFaceEngine;
import com.cn.stbu.hotel.Utils.listen.FrResultListener;
import com.cn.stbu.hotel.Utils.thread.FrThead;
import com.cn.stbu.hotel.domain.MyFaceInfo;
import com.cn.stbu.hotel.domain.ResultJson;
import com.cn.stbu.hotel.domain.User;
import com.cn.stbu.hotel.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.List;

/**
 * Description: 使用 MyFaceEngine 工具类 + 线程优化
 * Datetime:    2020/3/13 0013   22:33
 * Author:  IDEA
 */
@Controller
//@Scope(value = "session")   //session内 启用单个Bean
@RequestMapping("/my")
public class MyCapController {
    private Hashtable<Integer, MyFaceInfo> faceInfoSet;      //<faceId,myFaceInfo>     线程安全
    private Queue<MyFaceInfo> face_q;     //FR 线程队列    ：识别人脸队列
    private MyFaceEngine myFaceEngine;  //FX主引擎
    private List<FaceInfo> faceInfoList;    //在画面上识别到的人脸集合
    private FrThead[] FrArrays ;    //线程数组
//    private List<DetectResult> detectResults;   //结果数据

    @Autowired
    UserMapper userMapper;

    Logger logger = LoggerFactory.getLogger(getClass());
    //创建cotroller的时候就 初始化一个FX引擎  等待任务
    public MyCapController(){
        //功能配置
        FunctionConfiguration functionConfiguration = new FunctionConfiguration();
        functionConfiguration.setSupportAge(true);
        functionConfiguration.setSupportFace3dAngle(true);
        functionConfiguration.setSupportFaceDetect(true);
        functionConfiguration.setSupportFaceRecognition(true);
        functionConfiguration.setSupportGender(true);
        functionConfiguration.setSupportLiveness(true);
        functionConfiguration.setSupportIRLiveness(true);

        myFaceEngine = new MyFaceEngine();
        try {
            myFaceEngine.engine_init(functionConfiguration);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("控制层： 开启主引擎失败。");
        }
        logger.info("控制层： 开启主引擎成功。");

        faceInfoSet = new Hashtable<Integer,MyFaceInfo>();
        logger.info("创建人脸集合。。。");

        face_q = new LinkedList<MyFaceInfo>();
        logger.info("创建识别人脸队列。。。");

        //创建FR的线程池

        try {
            //注册监听器
            FrResultListener listener = event -> {
                FrThead rs = event.getResource();
                User t_user= rs.getUser();
                float similarity = rs.getSimilarity();
                if(t_user != null && similarity >=0){
                    int f_id = rs.getFaceInfo().getFaceId();
                    if(faceInfoSet.containsKey(f_id)) {  //识别完成之后，判断人脸还在不在画面中
                        MyFaceInfo myFace = faceInfoSet.get(f_id);
                        System.out.println("人脸：" + f_id + "  :  相似度:" + similarity);

//                        synchronized ("a") {        //必须在加入对象之后才执行，否则等待
//                            for (DetectResult result : detectResults) { //查找face
//                                // ist中的人脸，填入数据
//                                if (result.getFaceId() == f_id) {
//                                    result.setScores(similarity);
//                                    result.setUser(t_user);
//                                    break;
//                                }
//
//                            }
//                        }
                        myFace.setStatus(true);  //标记已经完成
                        myFace.setScores(similarity);
                        myFace.setUser(t_user);
                    }
                }
            };
            //创建5个FR线程，并且激活
            Object object= new Object();
            FrArrays = new FrThead[5];
            for(int i=0;i<5;i++){
                FrArrays[i] = new FrThead(face_q, "Fr-thread-"+(i+1), object, faceInfoSet);
                FrArrays[i].registryListener(listener);
                FrArrays[i].start();    //开启线程
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @GetMapping("/test")
    public String Test(){
        return "capture";
    }
    /**
     * @Reture 人脸识别结果
     */
    @PostMapping("/detect")
    @ResponseBody
    public ResultJson<Hashtable<Integer,MyFaceInfo>> detectPeople(HttpServletRequest req){
        synchronized ("a") {
            System.out.println("---------------请求分界线");
//            detectResults = new ArrayList<DetectResult>();
            String imgStr = req.getParameter("imageData");//获取imageData       类型：data:image/png;base64
            BufferedImage image = null;
            image = base64ToImage(imgStr);     //转化
//        List<User> userList = userMapper.findAll(); //获取数据库的内容

            if (image == null) return new ResultJson<Hashtable<Integer,MyFaceInfo>>(100, "图像解码失败", null);
            myFaceEngine.geneImageInfoByImage(image);//生成图像信息
            faceInfoList = myFaceEngine.getFaceInfo();   //识别

            if (faceInfoList == null) {
                return new ResultJson<Hashtable<Integer,MyFaceInfo>>(100, "未找到人脸", null);
            }
            //删除集合已经失效
            for (Integer id : faceInfoSet.keySet()) {
                boolean flag = false;
                for (FaceInfo f : faceInfoList) {
                    if (f.getFaceId() == id) flag = true;
                }
                if (flag == false) {
                    faceInfoSet.remove(id); //清理失效人脸
                    continue;
                }
            }


            List<LivenessInfo> liveness = null;    //获取活体列表
            Iterator<LivenessInfo> iterator = null;

            try {
                liveness = myFaceEngine.getLiveness(faceInfoList);
                iterator = liveness.iterator();
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("帧： 活体检测失败");
            }
            System.out.println("检测到人脸：" + faceInfoList.size() + ",活体对象个数:" + liveness.size() +
                    "，当前人脸集合：" + faceInfoSet.size() + "执行人脸任务队列个数:" + face_q.size());

            //入集合并填充结果实例
            for (FaceInfo f : faceInfoList) {
                int live = -1;   //默认活体 ： 未知
                if (iterator.hasNext()) {
                    live = iterator.next().getLiveness();
                    System.out.println("活体值：" + live);
                }

                System.out.println("f:live" + live);

                //判断该人脸是否已经进入画面
                MyFaceInfo face = faceInfoSet.get(f.getFaceId());
                if (face == null) {     //没有，   表示第一次识别到   入集合  //填充结果
                    MyFaceInfo face1 = new MyFaceInfo(f, myFaceEngine.getImageInfo(), live, false);
                    face1.setRect(f.getRect());
                    faceInfoSet.put(face1.getFaceId(), face1);
                }else{
                    MyFaceInfo rs=faceInfoSet.get(f.getFaceId());
                    rs.setRect(f.getRect());        //填充位置
                }
            }
        }

        //扫描faceInfoSet  入FR识别队列 (通过 活体检测 且 未完成识别入队列)
        for (Integer faceId :faceInfoSet.keySet()) {
            MyFaceInfo e = faceInfoSet.get(faceId);
            System.out.println("liveness:"+e.getLiveness()+",status:"+e.isStatus());
            System.out.println(e.toString());
            if(e.isStatus()==false){
                System.out.println("有一个任务入队列-------------------------------------------------------------------");
                synchronized ("") {
                    face_q.offer(e);    //人脸入队列
                }
            }
        }
        return new ResultJson<Hashtable<Integer,MyFaceInfo>>(200,"成功",faceInfoSet);
    }


    /**
     * 得到BufferedImage 对象
     * @Param Base64String
     * @Return  BufferedImage
     * */
    private BufferedImage base64ToImage(String base64){
        BufferedImage bufferedImage = null;
        //得到一个字符流
        InputStream inputStream = baseToInputStream(base64);
        try {
            bufferedImage = ImageIO.read(inputStream);  //ImageIO 图像流生成工具
        } catch (IOException e) {
            logger.info("获取缓存图片失败");
            e.printStackTrace();
        }
        return bufferedImage;
    }

    /**
     * 将base64字符串 解码为 字符流
     * */
    private InputStream baseToInputStream(String base64Str) {
        //base64 解码器
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] bytes = new byte[0];
        try {
            bytes = decoder.decodeBuffer(base64Str);
        } catch (IOException e) {
            logger.info("写入字符流输入流错误！");
            e.printStackTrace();
        }

        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        return in;
    }

    /*
     * 测试文件上传功能
     * */
    @RequestMapping(value = "/testFile", method = RequestMethod.POST)
    @ResponseBody
    public void multiImport(@RequestParam("head") MultipartFile headFile,@RequestParam("face") MultipartFile faceFile, Model model){
        getImgFile(headFile,model,"头像");
        getImgFile(faceFile,model,"人脸");
    }

    public void getImgFile(MultipartFile file,Model model,String str){
        String filename = file.getOriginalFilename();
        System.out.println("头像文件: "+filename);
        String[] split = filename.split("\\.");
        String format = split[split.length-1].toLowerCase();      //获取格式
        try{
            if("png".equals(format) || "jpg".equals(format)
                    || "jpeg".equals(format) || "bmp".equals(format)) {
                InputStream in = file.getInputStream();
                File f = new File("C:\\" + filename);
                f.createNewFile();
                BufferedImage image = ImageIO.read(in);
                ImageIO.write(image, format, f);
                return ;
            }else {
                model.addAttribute("msg",str+"文件格式错误");
                return;
            }
        }catch(IOException e){
            e.getStackTrace();
            model.addAttribute("msg",str+"发生文件异常");
            return ;
        }
    }
}
