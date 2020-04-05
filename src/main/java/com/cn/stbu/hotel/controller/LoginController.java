package com.cn.stbu.hotel.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 * Datetime:    2020/4/4 0004   12:23
 * Author:  IDEA
 */
@Controller
@RequestMapping("/text")
public class LoginController {
    @PostMapping("/login")
    public String login(String name, String password, Model model){
        Subject subject = SecurityUtils.getSubject();
        //封装数据
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        //登录
        try{
            subject.login(token);
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
    @GetMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
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

    @GetMapping("/user/up")
    @ResponseBody
    public String dddd(){
        Subject subject = SecurityUtils.getSubject();

        return "这是最低权限";
    }
}
