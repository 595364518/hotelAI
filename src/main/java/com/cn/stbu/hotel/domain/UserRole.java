package com.cn.stbu.hotel.domain;

/**
 * Description: 用户角色
 * Datetime:    2020/4/3 0003   23:47
 * Author:  IDEA
 */
public class UserRole{
    private String id; //表单id
    private int roleId;    //角色id
    private String  userId;   //用户id
    private String name;    //角色名称
    private Boolean available;  //可用状态
    private String description; //描述

    public UserRole(String id, int roleId, String userId, String name, Boolean available, String description) {
        this.id = id;
        this.roleId = roleId;
        this.userId = userId;
        this.name = name;
        this.available = available;
        this.description = description;
    }

    public UserRole(String id, int roleId, String userId) {
        this.id = id;
        this.roleId = roleId;
        this.userId = userId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int role_id) {
        this.roleId = role_id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", available=" + available +
                ", description='" + description + '\'' +
                '}';
    }
}
