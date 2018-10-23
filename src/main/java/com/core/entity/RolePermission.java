package com.core.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author smallTao.liu
 * @version V1.0
 * @description 角色关联权限
 * @date 2018/7/9 9:27
 */
@Entity
public class RolePermission extends BaseEntity {

    @Id
    private String uid;

    private String roleUid;

    private String permissionUid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getRoleUid() {
        return roleUid;
    }

    public void setRoleUid(String roleUid) {
        this.roleUid = roleUid;
    }

    public String getPermissionUid() {
        return permissionUid;
    }

    public void setPermissionUid(String permissionUid) {
        this.permissionUid = permissionUid;
    }
}