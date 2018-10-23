package com.core.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author smallTao.liu
 * @version V1.0
 * @description 实体公共部分
 * @date 2018/7/9 9:27
 */
public class BaseEntity implements Serializable {

    private String status;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
