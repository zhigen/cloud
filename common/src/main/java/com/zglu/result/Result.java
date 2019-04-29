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
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public boolean ifSuccess(){
        return this.getCode()==1;
    }

    public boolean ifError(){
        return this.getCode()!=1;
    }

    public static Result success() {
        return new Result(ResultCode.SUCCESS);
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = success();
        result.setData(data);
        return result;
    }

    public static Result error() {
        return new Result(ResultCode.ERROR);
    }

    public static Result error(ResultCode resultCode) {
        return new Result(resultCode);
    }
}