package com.laze.delivery.domain.user.service;

import com.laze.delivery.common.error.ErrorCode;
import com.laze.delivery.common.exception.ApiException;
import com.laze.delivery.db.user.UserEntity;
import com.laze.delivery.db.user.UserRepository;
import com.laze.delivery.db.user.enums.UserStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * User Domain 로직을 처리하는 서비스
 */
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserEntity register(UserEntity userEntity) {
        return Optional.ofNullable(userEntity)
                .map(it -> {
                    userEntity.setStatus(UserStatus.REGISTERED);
                    userEntity.setRegisteredAt(LocalDateTime.now());
                    return userRepository.save(userEntity);
                })
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT, "User Entity Null"));
    }
}
