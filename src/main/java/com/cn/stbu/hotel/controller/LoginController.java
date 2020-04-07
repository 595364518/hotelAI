package com.cn.stbu.hotel.controller;

import com.arcsoft.face.FaceFeature;
import com.arcsoft.face.FaceInfo;
import com.arcsoft.face.FunctionConfiguration;
import com.arcsoft.face.LivenessInfo;
import com.cn.stbu.hotel.Utils.face.MyFaceEngine;
import com.cn.stbu.hotel.domain.ResultJson;
import com.cn.stbu.hotel.domain.User;
import com.cn.stbu.hotel.domain.UserRole;
import com.cn.stbu.hotel.service.FaceInfoService;
import com.cn.stbu.hotel.service.LoginService;
import com.cn.stbu.hotel.service.UserRoleService;
import com.cn.stbu.hotel.service.UserService;
import com.cn.stbu.hotel.shiro.ShiroKit;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Description:
 * Datetime:    2020/4/4 0004   12:23
 * Author:  IDEA
 */
@Controller
@RequestMapping("/text")
public class LoginController {
    @Autowired
    UserService userService = null;
    @Autowired
    FaceInfoService faceInfoService = null;
    @Autowired
    UserRoleService userRoleService = null;
    @Autowired
    LoginService loginService = null;

    private String headImgPath = "C:\\ai\\head\\";        //服务器默认存放头像图片的路径
    private String faceImgPath = "C:\\ai\\face\\";        //服务器默认存放人脸图片的路径

    @PostMapping("/login")
    public String login(String name, String password, Model model){
        Subject subject = SecurityUtils.getSubject();
        //封装数据
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        //登录
        try{
            subject.login(token);
//            List<String> roles = (List<String>) subject.getSession().getAttribute("rs");
//            for (String r:roles){
//                System.out.println("拥有角色："+r);
//            }
            return "redirect:/";    //登录成功
        }catch (UnknownAccountException e){
            //用户不存在
            model.addAttribute("msg","不存在该用户");
            return "login";
        }catch (
            IncorrectCredentialsException e){
            e.printStackTrace();
            //登录失败： 密码错误
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }
    @PostMapping("/register")
    public String register(@RequestParam("files") MultipartFile [] files,User user, String checkCode, Model model){
        System.out.println("注册来了");
        String code = "1234";
        if(checkCode!="" && checkCode!= null && code.equals(checkCode)){    //验证码不为空 且 正确
            User u = userService.getUserByUsername(user.getUsername());
            if(u == null){      //用户名可用
                String pwd = user.getPassword();
                if(pwd !="" && pwd!= null){ //密码不为空
                    BufferedImage face_img = null;  //人脸
                    BufferedImage head_img = null;  //头像
                    String type_face ="";       //face格式
                    String type_head ="";       //head格式
                    MyFaceEngine engine = null ;
                    String faceStr = "" ; //人脸特征字符串
                    //检查 文件大小


                    //检查 头像图片格式 并且执行读取流
                    try {
                        type_head = getImgFormat(files[0].getOriginalFilename());
                        head_img = ImageIO.read(files[0].getInputStream());
                    } catch (IOException e) {
                        e.getStackTrace();
                        System.out.println("读取头像图片IO异常");
                        model.addAttribute("result",new ResultJson<>(405,"读取头像图像IO异常",""));
                        return "registError";
                    }catch (ArrayIndexOutOfBoundsException e) {
                        e.printStackTrace();
                        System.out.println("图像上传失败");
                        model.addAttribute("result",new ResultJson<>(405,"图像上传失败",""));
                        return "registError";
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("头像图片格式错误");
                        model.addAttribute("result",new ResultJson<>(405,"头像格式错误，请重新选择",""));
                        return "registError";
                    }
                    //检查 人脸图片格式 并且执行读取流

                    try {
                        type_face = getImgFormat(files[1].getOriginalFilename());
                        face_img = ImageIO.read(files[1].getInputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("读取人脸图片IO异常");
                        model.addAttribute("result",new ResultJson<>(405,"读取人脸图像IO异常",""));
                        return "registError";
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("人脸图片格式错误");
                        model.addAttribute("result",new ResultJson<>(405,"人脸格式错误，请重新选择",""));
                        return "registError";
                    }

                    //检查 人脸特征值 并且处理
                    try{
                        //人脸引擎准备
                        engine = new MyFaceEngine();
                        engine.setImageMode();  //设置Image模式
                        FunctionConfiguration functionConfiguration = new FunctionConfiguration();
                        functionConfiguration.setSupportFaceDetect(true);
                        functionConfiguration.setSupportLiveness(true);
                        functionConfiguration.setSupportFaceRecognition(true);
                        engine.engine_init(functionConfiguration);

                        //处理图像信息实例
                        engine.geneImageInfoByImage(face_img);
                        //获取人脸集合
                        List<FaceInfo> faceInfo = engine.getFaceInfo();
                        if(faceInfo.size() == 1){
                            //获取活体检测集合
                            List<LivenessInfo> liveness = engine.getLiveness(faceInfo);
                            //获取人脸特征值
                            if(liveness.get(0).getLiveness()== 1 ){
                                FaceFeature faceFeature = engine.detectFace(faceInfo.get(0));
                                engine.exitEngine();
                                //转成人脸数据字符串
                                faceStr = MyFaceEngine.featureToDBstr(faceFeature);
                            }else {
                                System.out.println("图像无效，请选择活体有效人脸图片");
                                model.addAttribute("result",new ResultJson<>(611,"图像无效，请选择活体有效人脸图片",""));
                                return "registError";
                            }
                        }else {
                            System.out.println("图像无效，要求选择有效单人图像");
                            model.addAttribute("result",new ResultJson<>(611,"图像无效，要求选择有效单人人脸图像",""));
                            return "registError";
                        }
                    }catch (IOException e){
                        e.getStackTrace();
                        System.out.println("读取人脸图像异常");
                        model.addAttribute("result",new ResultJson<>(405,"读取人脸图像异常",""));
                        return "registError";
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("引擎激活或者初始化异常，可能发生识别异常");
                        model.addAttribute("result",new ResultJson<>(406,"引擎激活或者初始化异常，可能发生识别异常",""));
                        return "registError";
                    }

                    Random random = new Random();
                    String faceInfoId = "FACE_"+ ShiroKit.getRandomSalt(10);   //随机人脸ID

                    //用户信息记录
                    String faceImgName = "face_img"+UUID.randomUUID().toString();
                    String headImgName = "head_img"+UUID.randomUUID().toString();
                    String userId = "USER"+ShiroKit.getRandomSalt(10);   //获取随机ID
                    String salt = ShiroKit.getRandomSalt(random.nextInt()%4 + 6);   //盐的长度为 6~10
                    String pwdMD5 = ShiroKit.md5(pwd,salt);     //加密完成的密码
                    user.setUserId(userId);
                    user.setSalt(salt);
                    user.setPassword(pwdMD5);
                    user.setHeadImg(headImgPath + headImgName +"."+type_head);
                    user.setFaceInfoId(faceInfoId);

                    //人脸特征记录
                    com.cn.stbu.hotel.domain.FaceInfo faceInfo = new com.cn.stbu.hotel.domain.FaceInfo(faceInfoId,faceImgName +"."+ type_face,faceImgPath,faceStr);
                    //权限记录
                    UserRole userRole = new UserRole(ShiroKit.getRandomSalt(9), 3, userId);


                    //写入图片资源
                    //写入face
                    try{
                        ImageIO.write(face_img,type_face,new File(faceImgPath + faceImgName +"."+ type_face));
                    }catch (Exception e){
                        e.printStackTrace();
                        System.out.println("人脸图片存储失败");
                        model.addAttribute("result",new ResultJson<>(406,"人脸图片存储失败",""));
                        return "registError";
                    }

                    //写入head
                    try{
                        ImageIO.write(head_img,type_head,new File(headImgPath + headImgName +"."+type_head));
                    }catch (Exception e){
                        e.printStackTrace();
                        System.out.println("头像图片存储失败");
                        model.addAttribute("result",new ResultJson<>(406,"头像图片存储失败",""));
                        new File(headImgPath + headImgName +"."+type_head).delete();//删除人脸图片
                        return "registError";
                    }

                    //最后注册DB
                    int registCode = loginService.register(faceInfo, user, userRole);   //给一个普通用户的权限    ：user
                    if(registCode == -1){
                        model.addAttribute("result",new ResultJson(508,"人脸注册数据库失败",""));
                        return "registError";
                    }
                    if(registCode == -2){
                        model.addAttribute("result",new ResultJson(508,"用户注册数据库失败",""));
                        return "registError";
                    }
                    if(registCode == -3){
                        model.addAttribute("result",new ResultJson(508,"权限注册数据库失败",""));
                        return "registError";
                    }
//成功注册，并且结束、、、、、、、、、、、、、、、、、
                    return "registSuccess";
                }else {
                    model.addAttribute("result",new ResultJson(402,"密码为空",user)); //密码为空
                    return "registError";
                }
            }else {
                model.addAttribute(new ResultJson(402,"用户名已存在",user)); //用户名已被使用
                return "registError";
            }
        }else {
            model.addAttribute(new ResultJson(402,"验证码错误",user));   //验证码错误
            return  "registError";
        }
    }

    private String getImgFormat(String filename) throws Exception {
        String[] split = filename.split("\\.");
        String format = split[split.length-1].toLowerCase();      //获取格式
        if(!"png".equals(format) && !"jpg".equals(format)
                && !"jpeg".equals(format) && !"bmp".equals(format)) {
            throw new Exception("格式错误");
        }
        return format;
    }
    /**
     * 登出
     * */
    @GetMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }

    @GetMapping("/toRegister")
    public String toRegister(){
        return "register";
    }
    /*
    * 转到 login页面
    * */
    @GetMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    /*
    * 转到 unAuth
    * */
    @GetMapping("/unAuth")
    public String toUnAuth(){
        return "unAuth";
    }

    /*
    * 检测人脸图片是否有效
    * */
    @PostMapping("/text/face")
    @ResponseBody
    public ResultJson<String > detectFaceImgValid(String faceImgStr){
            return null;
    }

    /*
     * 转到 registerError页面
     * */
//    @PostMapping("/text/registError")
//    public String registerError(){
//        return "registError";
//    }
}
