package com.cn.stbu.hotel.controller;

import ch.qos.logback.core.util.FileUtil;
import com.cn.stbu.hotel.Utils.PublicUtils;
import com.cn.stbu.hotel.domain.Result;
import com.cn.stbu.hotel.domain.User;
import com.cn.stbu.hotel.domain.UserRole;
import com.cn.stbu.hotel.service.UserRoleService;
import com.cn.stbu.hotel.service.UserService;
import com.cn.stbu.hotel.shiro.ShiroKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Description:
 * Datetime:    2020/4/5 0005   11:42
 * Author:  IDEA
 */
@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping("/select")
    @ResponseBody
    public Result seletcUser(@RequestBody String username){
        Result result = new Result();
        if (StringUtils.isEmpty(username)){
            result.setCode("103");
            return result;
        }
        User userByUsername = userService.getUserByUsername(username);
        if (userByUsername == null){
            result.setCode("104");
            return result;
        }
        result.setCode("105");
        result.setData(userByUsername);
        return result;
    }

    @RequestMapping("/selectall")
    @ResponseBody
    public Result seletcUserAll(){
        Result result = new Result();
        List<User> userList = userService.getUserList();
        result.setCode("105");
        result.setData(userList);
        return result;
    }

    @RequestMapping("/del")
    @ResponseBody
    public Result del(@RequestBody String username){
        Result result = new Result();
        if (StringUtils.isEmpty(username)){
            result.setCode("103");
            return result;
        }
        User userByUsername = userService.getUserByUsername(username);
        if (userByUsername == null){
            result.setCode("104");
            return result;
        }
        String userId = userByUsername.getUserId();
        List<UserRole> userRoleByUserId = userRoleService.getUserRoleByUserId(userId);
        for(UserRole userRole : userRoleByUserId){
            userRoleService.delUserRoleById(userRole.getId());
        }
        userService.delUserByUid(userId);
        result.setCode("106");
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody User user){
        Result result = new Result();
        if (StringUtils.isEmpty(user.getUserId())){
            result.setCode("700");
            return result;
        }
        User userByUid = userService.getUserByUid(user.getUserId());
        if (userByUid == null){
            result.setCode("104");
            return result;
        }

        System.out.println(userByUid);

        user.setUsername(userByUid.getUsername());
        user.setIDCard(userByUid.getIDCard());
        user.setRealName(userByUid.getRealName());
        user.setSalt(userByUid.getSalt());
        user.setPassword(userByUid.getPassword());
        user.setAccountId(userByUid.getAccountId());
        user.setHeadImg(userByUid.getHeadImg());
        user.setFaceInfoId(userByUid.getFaceInfoId());
        user.setGender(userByUid.getGender());
        user.setBirthData(userByUid.getBirthData());
        user.setAge(userByUid.getAge());

        userService.updateUser(user);
        result.setCode("107");
        return result;
    }

    @RequestMapping("/updatepwd")
    @ResponseBody
    public Result updatePwd(@RequestBody String pwd){
        Result result = new Result();
        User user = new User();
        user.setPassword(pwd);

        User user1 = ShiroKit.getUser();
        if (user1 == null){
            result.setCode("-1001");
            return result;
        }

        user.setUserId(user1.getUserId());
        if (StringUtils.isEmpty(user.getUserId())){
            result.setCode("700");
            return result;
        }
        User userByUid = userService.getUserByUid(user.getUserId());
        if (userByUid == null){
            result.setCode("104");
            return result;
        }
        Random random = new Random();
        String salt = ShiroKit.getRandomSalt(random.nextInt()%4 + 6);   //盐的长度为 6~10
        String pwdMD5 = ShiroKit.md5(user.getPassword(),salt);     //加密完成的密码
        user.setSalt(salt);
        user.setPassword(pwdMD5);
        userService.updatePwd(user);
        result.setCode("107");
        return result;
    }

    @RequestMapping("/updatehead")
    @ResponseBody
    public Result updateHead(MultipartFile file){
        Result result = new Result();
        User user = ShiroKit.getUser();
        if (user == null){
            result.setCode("-1001");
            return result;
        }
        if (file.isEmpty()){
            result.setCode("1001");
            return result;
        }

        String filename = file.getOriginalFilename();
        String upFileName = filename.substring(0, filename.lastIndexOf("."));
        System.out.println(upFileName);
        String suffixName = filename.substring(filename.lastIndexOf(".") + 1);
        System.out.println(suffixName);

        List<String> filType= Arrays.asList("gif","bmp","jpg","png","jpeg","webp");
        if (!filType.contains(suffixName)){
            result.setCode("1002");
            return result;
        }

        if (file.getSize() > 20*1024*1024){
            result.setCode("1003");
            return result;
        }

        String fileName = "head_img" + UUID.randomUUID().toString();
        String filePathName = PublicUtils.getHeadImgPath() + fileName + "." + suffixName;

        File dest = new File(filePathName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
        } catch (IOException e){
            result.setCode("1004");
            return result;
        }

        user.setHeadImg(filePathName);
        userService.updateHead(user);
        result.setCode("1014");
        return result;
    }

}
