package com.laze.delivery.common.error;

public interface ErrorCodeInterface {

    Integer getHttpStatusCode();
    Integer getErrorCode();
    String getDescription();
}
