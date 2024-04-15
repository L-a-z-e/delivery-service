package com.laze.delivery.common.exception;

import com.laze.delivery.common.error.ErrorCodeInterface;

public interface ApiExceptionInterface {

    ErrorCodeInterface getErrorCodeInterface();
    String getErrorDescription();

}
