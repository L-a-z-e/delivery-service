package com.laze.delivery.common.api;

import com.laze.delivery.common.error.ErrorCodeInterface;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Api<T> {

    private Result result;

    @Valid
    private T body;

    public static <T> Api<T> OK(T data){
        var api = new Api<T>();
        api.result = Result.OK();
        api.body = data;
        return api;
    }
    public static Api<Object> Error(Result result){
        var api = new Api<Object>();
        api.result = result;
        return api;
    }
    public static Api<Object> Error(ErrorCodeInterface errorCodeInterface){
        var api = new Api<Object>();
        api.result = Result.ERROR(errorCodeInterface);
        return api;
    }
    public static Api<Object> Error(ErrorCodeInterface errorCodeInterface, Throwable throwable){
        var api = new Api<Object>();
        api.result = Result.ERROR(errorCodeInterface, throwable);
        return api;
    }
    public static Api<Object> Error(ErrorCodeInterface errorCodeInterface, String description){
        var api = new Api<Object>();
        api.result = Result.ERROR(errorCodeInterface, description);
        return api;
    }
}
