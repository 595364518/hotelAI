package com.cn.stbu.hotel.shiro;

import com.cn.stbu.hotel.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;

import java.util.Random;

/**
 * shiro工具类
 */
public class ShiroKit {

    private static final String NAMES_DELIMETER = ",";

    public static final int SALT_LENTH = 5;
    /**
     * 加盐参数
     */
    public final static String hashAlgorithmName = "MD5";

    /**
     * 循环次数
     */
    public final static int hashIterations = 1024;

    /**
     * shiro密码加密工具类
     *
     * @param credentials 密码
     * @param saltSource  密码盐
     * @return
     */
    public static String md5(String credentials, String saltSource) {
        ByteSource salt = new Md5Hash(saltSource);
        return new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations).toString();
    }

    /**
     * 获取随机盐值
     * @param length
     * @return String
     */
    public static String getRandomSalt(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<length;i++){
            int index = random.nextInt()%62;
            if(index<0)index*=-1;
            sb.append(str.charAt(index));
        }
        return sb.toString();
    }


    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }
    public static User getUser() {
        return (User)SecurityUtils.getSubject().getPrincipal();
    }

}
