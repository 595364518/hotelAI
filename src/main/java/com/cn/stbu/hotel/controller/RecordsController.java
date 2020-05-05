package com.cn.stbu.hotel.controller;

import com.cn.stbu.hotel.domain.Account;
import com.cn.stbu.hotel.domain.Records;
import com.cn.stbu.hotel.domain.Result;
import com.cn.stbu.hotel.service.AccountService;
import com.cn.stbu.hotel.service.RecordsService;
import com.cn.stbu.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api")
public class RecordsController {

    @Autowired
    private RecordsService recordsService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    @RequestMapping("/findrecordsall")
    @ResponseBody
    public Result findrecordsall(@RequestBody String user_id){
        Result result = new Result();
        if (StringUtils.isEmpty(user_id)){
            result.setCode("700");
            return result;
        }
        List<Records> recordsAll = recordsService.findRecordsAll(user_id);
        System.out.println(recordsAll);
        result.setCode("701");
        result.setData(recordsAll);
        return result;
    }

    @RequestMapping("/addrecords")
    @ResponseBody
    public Result addrecords(@RequestBody Records records){
        Result result = new Result();
        if (StringUtils.isEmpty(records.getUser_id())){
            result.setCode("700");
            return result;
        }
        if (userService.getUserByUid(records.getUser_id()) == null){
            result.setCode("703");
            return result;
        }
        if (records.getRecords_budget() == null){
            result.setCode("704");
            return result;
        }
        Date date = new Date();
        records.setRecords_date(date);
        Double money;
        Account account = accountService.findAccountByUserId(records.getUser_id());
        if (account == null){
            result.setCode("800");
            return result;
        }
        System.out.println(account);
        if (records.getRecords_budget()){
            //收入
            //System.out.println(account.getBalance() + " | " + records.getRecords_money());
            money = account.getBalance() + records.getRecords_money();
            account.setBalance(money);
            accountService.updateAccount(account);
        } else {
            money = account.getBalance() - records.getRecords_money();
            account.setBalance(money);
            accountService.updateAccount(account);
        }
        records.setRecords_id(UUID.randomUUID().toString());
        records.setRecords_balance(money);
        recordsService.addRecords(records);
        result.setCode("702");
        result.setData(records);
        return result;
    }
}
