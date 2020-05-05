package com.cn.stbu.hotel.controller;

import com.cn.stbu.hotel.domain.Account;
import com.cn.stbu.hotel.domain.Result;
import com.cn.stbu.hotel.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findaccount")
    @ResponseBody
    public Result findaccount(@RequestBody String user_id){
        Result result = new Result();
        if (StringUtils.isEmpty(user_id)){
            result.setCode("700");
            return result;
        }
        Account account = accountService.findAccountByUserId(user_id);
        if (account == null){
            result.setCode("800");
            return result;
        }
        result.setCode("801");
        result.setData(account);
        return result;
    }

}
