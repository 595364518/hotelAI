package com.cn.stbu.hotel;

import com.arcsoft.face.FaceFeature;
import com.arcsoft.face.FaceInfo;
import com.arcsoft.face.FunctionConfiguration;
import com.cn.stbu.hotel.Utils.email.MailUtil;
import com.cn.stbu.hotel.Utils.face.MyFaceEngine;
import com.cn.stbu.hotel.domain.RolePermission;
import com.cn.stbu.hotel.domain.User;
import com.cn.stbu.hotel.domain.UserRole;
import com.cn.stbu.hotel.service.RolePermissionService;
import com.cn.stbu.hotel.service.UserRoleService;
import com.cn.stbu.hotel.service.UserService;
import com.cn.stbu.hotel.shiro.ShiroKit;
import org.apache.logging.log4j.message.SimpleMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.swing.*;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelApplicationTests {

    @Autowired
    UserService userService = null;
    @Autowired
    UserRoleService userRoleService = null;
    @Autowired
    RolePermissionService rolePermissionService = null ;
    @Autowired
    JavaMailSenderImpl javaMailSender = null;

    @Test
    public void contextLoads() {
        List<User> userList = userService.getUserList();
        System.out.println(userList.get(0).toString());
    }
    @Test
    public void testUser(){
        User user = userService.getUserByUsername("hxd");
        System.out.println(user.toString());
    }
    @Test
    public void Role(){

        List<UserRole> list = userRoleService.getUserRoleByUserId("USER0001");
        for (UserRole ur : list) {
            System.out.println(ur.toString());
        }
    }

    @Test
    public void permission(){

        List<RolePermission> list = rolePermissionService.getRolePermissionListByRid(3);
        for (RolePermission rp : list) {
            System.out.println(rp.toString());
        }
    }
    @Test
    public void md5(){
        String pwd = "123";
        String salt = UUID.randomUUID().toString();
        String dbPwd = ShiroKit.md5(pwd, salt);
        System.out.println("salt: "+salt+", dbPwd:  "+dbPwd);
    }
    @Test
    public void engineTest() throws Exception {
        MyFaceEngine engine = new MyFaceEngine();
        FunctionConfiguration functionConfiguration = new FunctionConfiguration();
        functionConfiguration.setSupportLiveness(true);
        functionConfiguration.setSupportFaceDetect(true);
        functionConfiguration.setSupportFaceRecognition(true);
        engine.engine_init(functionConfiguration);
        engine.setImageMode();
        engine.geneImageInfoByImage(new ImageIcon("F:\\AI酒店\\SDK的test图片\\系统人脸图片\\何旭东老家.jpg").getImage());
        List<FaceInfo> faceInfo = engine.getFaceInfo();
        FaceFeature faceFeature = engine.detectFace(faceInfo.get(0));
//        Thread.sleep(5);

        System.out.println(MyFaceEngine.featureToDBstr(faceFeature));


    }
    @Test
    public void SimpleMail() throws MessagingException {
//        MailUtil mailUtil = new MailUtil();
//        String code = ShiroKit.getRandomSalt(6);
//        mailUtil.sendEmail(javaMailSender,"767134464.qq.com","2274915534@qq.com","465","何旭东");
        //封装简单邮件内容
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("放假通知");
        message.setText("放假7天");
        message.setFrom("767134464.qq.com");
        message.setTo("2274915534@qq.com");
        javaMailSender.send(message);
    }
    @Test
    public void MineMail() throws MessagingException {
        MailUtil mailUtil = new MailUtil();
        String code = ShiroKit.getRandomSalt(6);
        mailUtil.sendEmail(javaMailSender,"767134464.qq.com","595364518@qq.com","465","何旭东");
    }


}
