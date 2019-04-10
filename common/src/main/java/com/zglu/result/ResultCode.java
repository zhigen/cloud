package com.zglu.result;

public enum ResultCode {

    ERROR(0, "失败"),

    //通用
    DATA_NOT_EXIST(10001, "数据不存在"),

    //用户模块
    USER_TOKEN_ERROR(20001, "令牌认证失败"),
    USER_NOT_EXIST(20002, "用户不存在"),
    USER_LOGIN_ERROR(20003, "用户密码错误"),
    USER_DISABLE(20004, "用户已被禁用"),

    //权限模块
    ROLE_NOT_PERMISSION(30001, "角色无此权限"),

    SUCCESS(1, "成功");

    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}