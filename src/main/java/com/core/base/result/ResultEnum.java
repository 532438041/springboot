package com.core.base.result;

/**
 * @author smallTao.liu
 * @version V1.0
 * @description
 * @date 2018/6/19 16:51
 */
public enum ResultEnum {

    CONTINUE(100, "Continue"),
    SWITCHING_PROTOCOLS(101, "Switching Protocols"),
    PROCESSING(102, "Processing"),
    CHECKPOINT(103, "Checkpoint"),

    OK(200, "成功"),
    CREATED(201, "已创建"),
    ACCEPTED(202, "已接受"),
    NON_AUTHORITATIVE_INFORMATION(203, "非授权信息"),
    NO_CONTENT(204, "无内容"),
    RESET_CONTENT(205, "重置内容"),
    PARTIAL_CONTENT(206, "部分内容"),

    MULTIPLE_CHOICES(300, "多种选择"),
    MOVED_PERMANENTLY(301, "永久移动"),
    FOUND(302, "临时移动"),
    /**
     * @deprecated
     */
    @Deprecated
    MOVED_TEMPORARILY(302, "临时移动"),
    SEE_OTHER(303, "查看其他位置"),
    NOT_MODIFIED(304, "未修改"),
    /**
     * @deprecated
     */
    @Deprecated
    USE_PROXY(305, "使用代理"),
    TEMPORARY_REDIRECT(307, "临时重定向"),

    BAD_REQUEST(400, "错误请求"),
    UNAUTHORIZED(401, "未授权"),
    PAYMENT_REQUIRED(402, "Payment Required"),
    FORBIDDEN(403, "禁止"),
    NOT_FOUND(404, "未找到"),
    METHOD_NOT_ALLOWED(405, "方法禁用"),
    NOT_ACCEPTABLE(406, "不接受"),
    PROXY_AUTHENTICATION_REQUIRED(407, "需要代理授权"),
    REQUEST_TIMEOUT(408, "请求超时"),
    CONFLICT(409, "冲突"),
    GONE(410, "已删除"),
    LENGTH_REQUIRED(411, "需要有效长度"),
    PRECONDITION_FAILED(412, "未满足前提条件"),
    PAYLOAD_TOO_LARGE(413, "请求实体过大"),
    /**
     * @deprecated
     */
    @Deprecated
    REQUEST_ENTITY_TOO_LARGE(413, "请求实体过大"),
    URI_TOO_LONG(414, "请求的 URI 过长"),
    /**
     * @deprecated
     */
    @Deprecated
    REQUEST_URI_TOO_LONG(414, "Request-URI Too Long"),
    UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
    REQUESTED_RANGE_NOT_SATISFIABLE(416, "Requested range not satisfiable"),
    EXPECTATION_FAILED(417, "Expectation Failed"),
    I_AM_A_TEAPOT(418, "I'm a teapot"),
    /**
     * @deprecated
     */
    @Deprecated
    INSUFFICIENT_SPACE_ON_RESOURCE(419, "Insufficient Space On Resource"),
    /**
     * @deprecated
     */
    @Deprecated
    METHOD_FAILURE(420, "Method Failure"),
    /**
     * @deprecated
     */
    @Deprecated
    DESTINATION_LOCKED(421, "Destination Locked"),
    UNPROCESSABLE_ENTITY(422, "Unprocessable Entity"),
    LOCKED(423, "Locked"),
    FAILED_DEPENDENCY(424, "Failed Dependency"),
    UPGRADE_REQUIRED(426, "Upgrade Required"),
    PRECONDITION_REQUIRED(428, "Precondition Required"),
    TOO_MANY_REQUESTS(429, "Too Many Requests"),
    REQUEST_HEADER_FIELDS_TOO_LARGE(431, "Request Header Fields Too Large"),
    UNAVAILABLE_FOR_LEGAL_REASONS(451, "Unavailable For Legal Reasons"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    NOT_IMPLEMENTED(501, "尚未实施"),
    BAD_GATEWAY(502, "错误网关"),
    SERVICE_UNAVAILABLE(503, "服务不可用"),
    GATEWAY_TIMEOUT(504, "网关超时"),
    HTTP_VERSION_NOT_SUPPORTED(505, "HTTP 版本不受支持"),
    VARIANT_ALSO_NEGOTIATES(506, "Variant Also Negotiates"),
    INSUFFICIENT_STORAGE(507, "Insufficient Storage"),
    LOOP_DETECTED(508, "Loop Detected"),
    BANDWIDTH_LIMIT_EXCEEDED(509, "Bandwidth Limit Exceeded"),
    NOT_EXTENDED(510, "Not Extended"),
    NETWORK_AUTHENTICATION_REQUIRED(511, "Network Authentication Required");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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

    public static String getMsg(Integer code) {
        for (ResultEnum resultEnum : ResultEnum.values()) {
            if (resultEnum.getCode().equals(code)) {
                return resultEnum.getMsg();
            }
        }
        return null;
    }

    public static Integer getCode(String msg) {
        for (ResultEnum resultEnum : ResultEnum.values()) {
            if (resultEnum.getMsg().equals(msg)) {
                return resultEnum.getCode();
            }
        }
        return null;
    }
}
