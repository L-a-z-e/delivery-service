package com.laze.delivery.domain.user.business;

import com.laze.delivery.common.annotation.Business;
import com.laze.delivery.common.error.ErrorCode;
import com.laze.delivery.common.exception.ApiException;
import com.laze.delivery.domain.user.controller.model.UserRegisterRequest;
import com.laze.delivery.domain.user.controller.model.UserResponse;
import com.laze.delivery.domain.user.converter.UserConverter;
import com.laze.delivery.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
@Business
public class UserBusiness {

    private final UserService userService;
    private final UserConverter userConverter;

    /**
     *  사용자에 대한 가입처리 로직
     *  1. request -> entity
     *  2. entity -> save
     *  3. save Entity -> response
     *  4. response return
     */
    public UserResponse register(UserRegisterRequest request) {
        var entity = userConverter.toEntity(request);
        var newEntity = userService.register(entity);
        var response = userConverter.toResponse(newEntity);

        return response;

//        return Optional.ofNullable(request)
//                .map(userConverter::toEntity)
//                .map(userService::register)
//                .map(userConverter::toResponse)
//                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT, "request null"));
    }
}
