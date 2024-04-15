package com.laze.delivery.exceptionhandler;

import com.laze.delivery.common.api.Api;
import com.laze.delivery.common.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@Order(value = Integer.MIN_VALUE) // 최우선 처리
public class ApiExceptionHandler {

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<Api<Object>> apiException(ApiException apiException){
        log.error("",apiException);

        var errorCode = apiException.getErrorCodeInterface();

        return ResponseEntity.status(errorCode.getHttpStatusCode())
                .body(Api.Error(errorCode, apiException.getErrorDescription()));
    }
}
