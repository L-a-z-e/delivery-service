package com.laze.delivery.common.api;

import com.laze.delivery.common.error.ErrorCode;
import com.laze.delivery.common.error.ErrorCodeInterface;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result {

    private Integer resultCode;
    private String resultMessage;
    private String resultDescription;

    public static Result OK(){
        return Result.builder()
                .resultCode(ErrorCode.OK.getErrorCode())
                .resultMessage(ErrorCode.OK.getDescription())
                .resultDescription("성공")
                .build();
    }

    public static Result ERROR(ErrorCodeInterface errorCodeInterface){
        return Result.builder()
                .resultCode(errorCodeInterface.getErrorCode())
                .resultMessage(errorCodeInterface.getDescription())
                .resultDescription("에러 발생")
                .build();
    }
    public static Result ERROR(ErrorCodeInterface errorCodeInterface, Throwable throwable){
        return Result.builder()
                .resultCode(errorCodeInterface.getErrorCode())
                .resultMessage(errorCodeInterface.getDescription())
                .resultDescription(throwable.getLocalizedMessage())
                .build();
    }

    public static Result ERROR(ErrorCodeInterface errorCodeInterface, String description){
        return Result.builder()
                .resultCode(errorCodeInterface.getErrorCode())
                .resultMessage(errorCodeInterface.getDescription())
                .resultDescription(description)
                .build();
    }
}
