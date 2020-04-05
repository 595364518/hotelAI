package com.cn.stbu.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 * Datetime:    2020/4/5 0005   11:42
 * Author:  IDEA
 */
@Controller
@RequestMapping("/text/user")
public class UserController {

    @GetMapping("/select")
    @ResponseBody
    String seletcUser(){
        return "用户查询";
    }

    @GetMapping("/del")
    @ResponseBody
    String del(){
        return "用户删除";
    }

    @GetMapping("/update")
    @ResponseBody
    String update(){
        return "用户修改";
    }
}
