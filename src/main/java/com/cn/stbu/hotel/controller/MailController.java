package com.cn.stbu.hotel.controller;

import com.cn.stbu.hotel.Utils.email.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description:
 * Datetime:    2020/4/7 0007   17:10
 * Author:  IDEA
 */
@Controller
@RequestMapping("text/")
public class MailController {

    @Autowired
    JavaMailSender javaMailSender = null;
    /**
     * 发送邮件
     * */
    @GetMapping("/mail")
    public void sendMail(String eamil){
        MailUtil mailUtil = new MailUtil();
//        mailUtil.sendEmail(javaMailSender,);
    }


}
