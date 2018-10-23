package com.core.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author smallTao.liu
 * @version V1.0
 * @description 角色
 * @date 2018/7/9 9:27
 */
@Entity
public class Role extends BaseEntity {

    @Id
    private String uid;

    private String displayName;

    private String remark;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Role{" +
                "displayName='" + displayName + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}