package com.core.base.result;

/**
 * @author smallTao.liu
 * @version V1.0
 * @description Rest-API返回Result
 * @date 2018/6/19 16:46
 */
public class Result<T> {

    private Integer code;

    private String msg;

    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result<T> success() {
        this.code = ResultEnum.OK.getCode();
        this.msg = ResultEnum.OK.getMsg();
        return this;
    }

    public Result<T> success(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public Result<T> success(T data) {
        this.code = ResultEnum.OK.getCode();
        this.msg = ResultEnum.OK.getMsg();
        this.data = data;
        return this;
    }

    public Result<T> success(T data, String msg) {
        this.code = ResultEnum.OK.getCode();
        this.data = data;
        this.msg = msg;
        return this;
    }

    public Result<T> failed() {
        this.code = ResultEnum.INTERNAL_SERVER_ERROR.getCode();
        this.msg = ResultEnum.INTERNAL_SERVER_ERROR.getMsg();
        return this;
    }

    public Result<T> failed(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

}
