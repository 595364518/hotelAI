package com.cn.stbu.hotel.domain;

/**
 * Description: 权限
 * Datetime:    2020/4/4 0004   12:58
 * Author:  IDEA
 * `permission_id`, `available`, `name`, `permission`, `resource_type`, `url`
 */
public class Permission {
    private int permissionId ;  //权限id
    private Boolean available;  //可用状态
    private String name;        //权限名称
    private String permission;  //资源符
    private String resourceType;    //资源类型
    private String url;         //资源路径

    public Permission(int permissionId, Boolean available, String name, String permission, String resourceType, String url) {
        this.permissionId = permissionId;
        this.available = available;
        this.name = name;
        this.permission = permission;
        this.resourceType = resourceType;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionId=" + permissionId +
                ", available=" + available +
                ", name='" + name + '\'' +
                ", permission='" + permission + '\'' +
                ", resourceType='" + resourceType + '\'' +
                ", url='" + url + '\'' +
                '}';
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

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
