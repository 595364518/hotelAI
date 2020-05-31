package com.cn.stbu.hotel.domain;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class Result {

    private static Map<String,String> map = new HashMap<String, String>();

    static {
        map.put("-1001","未登陆！");

        map.put("100","登陆成功！");
        map.put("101","登陆失败，用户不存在！");
        map.put("102","登陆失败，密码错误！");
        map.put("103","用户名不能为空！");
        map.put("104","不存在该用户！");
        map.put("105","用户查询成功！");
        map.put("106","用户删除成功！");
        map.put("107","用户修改成功！");
        map.put("108","密码修改成功！");

        map.put("300","读取头像图像IO异常");
        map.put("301","图像上传失败");
        map.put("302","头像图片格式错误");
        map.put("303","读取人脸图片IO异常");
        map.put("304","人脸图片格式错误");
        map.put("305","图像无效，请选择活体有效人脸图片");
        map.put("306","图像无效，要求选择有效单人图像");
        map.put("307","读取人脸图像异常");
        map.put("308","引擎激活或者初始化异常，可能发生识别异常");
        map.put("309","人脸图片存储失败");
        map.put("310","头像图片存储失败");
        map.put("311","人脸注册数据库失败");
        map.put("312","用户注册数据库失败");
        map.put("313","权限注册数据库失败");
        map.put("314","注册成功");
        map.put("315","密码为空");
        map.put("316","用户名已存在");
        map.put("316","用户名已存在");
        map.put("317","验证码错误");
        map.put("318","退出登陆成功");
        map.put("319","目录创建失败");

        map.put("600","图像解码失败");
        map.put("601","未找到人脸");
        map.put("602","识别成功");

        map.put("700","用户id不能为空");
        map.put("701","账单查询成功");
        map.put("702","账单添加成功");
        map.put("703","不存在该用户");
        map.put("704","收支情况不能为空");

        map.put("800","该用户无账户");
        map.put("801","账户查询成功");

        map.put("901","入住信息查询成功");
        map.put("902","入住信息为空");
        map.put("903","时间信息为空");
        map.put("904","用户ID为空");
        map.put("905","入住信息创建成功");
        map.put("906","入住信息ID为空");
        map.put("907","退房成功");
        map.put("908","房间已退，无须再退");
        map.put("909","入住信息修改成功");
        map.put("910","不存在该房间");
        map.put("911","该房间以有客人");
        map.put("912","已退房，不可修改");

        map.put("1001", "文件为空，上传失败！");
        map.put("1002", "图片格式错误，只支持：gif,bmp,jpg,png,jpeg,webp格式！");
        map.put("1003", "文件过大，文件必须小于20MB！");
        map.put("1004", "文件保存失败！");
        map.put("1005", "文件上传成功！");
        map.put("1006", "文件名不能为空！");
        map.put("1007", "文件不存在！");
        map.put("1008", "系统找不到指定的路径！");
        map.put("1009", "系统发生ID异常！");
        map.put("1010", "下载成功！");
        map.put("1011", "文件不存在！");
        map.put("1012", "数据库未查询到该文件！");
        map.put("1013", "流关闭失败！");
        map.put("1014", "上传成功！");

        map.put("1100", "房间号不能为空！");
        map.put("1101", "房间价格不合理！");
        map.put("1102", "房间添加成功！");
        map.put("1103", "房间查询成功！");
        map.put("1104", "不存在该房间！");
        map.put("1105", "房间修改成功！");
        map.put("1106", "房间删除成功！");
        map.put("1107", "房间已有人居住，不可修改！！");



    }

    private String code;
    private String message;
    private String type;
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (!StringUtils.isEmpty(map.get(code))){
            this.message = map.get(code);
        }
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
