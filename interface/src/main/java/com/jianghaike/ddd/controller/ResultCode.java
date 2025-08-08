package com.jianghaike.ddd.controller;

/**
 * @author jianghaike
 */
public enum ResultCode {
    /* 成功状态码 */
    SUCCESS(0, "成功"),
    /* 参数错误：1001—1999 */
    PARAM_IS_INVALID(1001, "参数无效"),
    PARAM_IS_BLANK(1002, "参数为空"),
    PARAM_NOT_COMPLETE(1003, "参数缺失");

    private final Integer code;

    private final String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
