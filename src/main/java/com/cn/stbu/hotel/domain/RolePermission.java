package com.cn.stbu.hotel.domain;

/**
 * Description: 角色权限
 * Datetime:    2020/4/4 0004   10:09
 * Author:  IDEA
 */
public class RolePermission {
    private int id; //id
    private int roleId; //角色id
    private int permissionId; //权限id
    private Boolean available; //可用状态
    private String name ; //权限名称
    private String permission ;     //权限字符串
    private String resource_type;   // 资源类型
    private String url; //资源定位符

    public RolePermission(int id, int roleId, int permissionId, Boolean available, String name, String permission, String resource_type, String url) {
        this.id = id;
        this.roleId = roleId;
        this.permissionId = permissionId;
        this.available = available;
        this.name = name;
        this.permission = permission;
        this.resource_type = resource_type;
        this.url = url;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", permissionId=" + permissionId +
                ", available=" + available +
                ", name='" + name + '\'' +
                ", permission='" + permission + '\'' +
                ", resource_type='" + resource_type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getResource_type() {
        return resource_type;
    }

    public void setResource_type(String resource_type) {
        this.resource_type = resource_type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
