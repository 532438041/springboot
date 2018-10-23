package com.core.entity;

import javax.persistence.*;

/**
 * @author smallTao.liu
 * @version V1.0
 * @description 权限
 * @date 2018/7/9 9:42
 */
@Entity
public class Permission extends BaseEntity {

    @Id
    private String uid;
    //名称
    private String displayName;
    //资源类型，[menu|button]
    private String resourceType;
    //资源路径.
    private String url;
    //权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
    private String permission;
    //父编号
    private String pUid;
    //父编号列表
    private String pUids;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getpUid() {
        return pUid;
    }

    public void setpUid(String pUid) {
        this.pUid = pUid;
    }

    public String getpUids() {
        return pUids;
    }

    public void setpUids(String pUids) {
        this.pUids = pUids;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "displayName='" + displayName + '\'' +
                ", resourceType='" + resourceType + '\'' +
                ", url='" + url + '\'' +
                ", permission='" + permission + '\'' +
                ", pUid='" + pUid + '\'' +
                ", pUids='" + pUids + '\'' +
                '}';
    }
}
