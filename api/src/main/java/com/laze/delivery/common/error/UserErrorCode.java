package com.laze.delivery.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum UserErrorCode implements ErrorCodeInterface{

    USER_NOT_FOUND(400, 1404, "사용자를 찾을 수 없음"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), 400, "잘못된 요청"),
    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), 500, "서버 에러"),
    NULL_POINT(HttpStatus.INTERNAL_SERVER_ERROR.value(), 512, "Null point")

    ;
    private final Integer httpStatusCode;
    private final Integer errorCode;
    private final String description;
}
