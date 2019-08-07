package com.zglu.result;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Result<T> {

    private Integer code;
    private String message;
    private T data;

    private Result(ResultCode resultCode) {
        code = resultCode.code();
        message = resultCode.message();
    }

    public boolean ifSuccess() {
        return code == 1;
    }

    public boolean ifError() {
        return code != 1;
    }

    public static <T> Result<T> success() {
        return new Result<>(ResultCode.SUCCESS);
    }

    public static <T> Result<T> error() {
        return new Result<>(ResultCode.ERROR);
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = success();
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error(ResultCode resultCode) {
        return new Result<>(resultCode);
    }
}