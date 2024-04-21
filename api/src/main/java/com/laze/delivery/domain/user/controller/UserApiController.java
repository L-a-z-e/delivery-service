package com.laze.delivery.domain.user.controller;


import com.laze.delivery.domain.user.business.UserBusiness;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserApiController {
    private final UserBusiness userBusiness;
}
