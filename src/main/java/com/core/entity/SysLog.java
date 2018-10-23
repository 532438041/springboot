package com.core.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author smallTao.liu
 * @version V1.0
 * @description 系统日志 由aop存入
 * @date 2018/7/9 9:27
 */
@Entity
public class SysLog extends BaseEntity {

    @Id
    private String uid;

    private String details;

    private String method;

    private String logType;

    private String reqIp;

    private String exCode;

    private String exMsg;

    private String exDetail;

    private String params;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getReqIp() {
        return reqIp;
    }

    public void setReqIp(String reqIp) {
        this.reqIp = reqIp;
    }

    public String getExCode() {
        return exCode;
    }

    public void setExCode(String exCode) {
        this.exCode = exCode;
    }

    public String getExMsg() {
        return exMsg;
    }

    public void setExMsg(String exMsg) {
        this.exMsg = exMsg;
    }

    public String getExDetail() {
        return exDetail;
    }

    public void setExDetail(String exDetail) {
        this.exDetail = exDetail;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

}
