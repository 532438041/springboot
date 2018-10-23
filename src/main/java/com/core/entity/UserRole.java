package com.core.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author smallTao.liu
 * @version V1.0
 * @description 用户角色
 * @date 2018/7/9 9:27
 */
@Entity
public class UserRole extends BaseEntity{

    @Id
    private String uid;

    private String userUid;

    private String roleUid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public String getRoleUid() {
        return roleUid;
    }

    public void setRoleUid(String roleUid) {
        this.roleUid = roleUid;
    }
}