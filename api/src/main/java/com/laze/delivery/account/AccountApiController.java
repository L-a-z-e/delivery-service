package com.laze.delivery.account;

import com.laze.delivery.account.model.AccountMeResponse;
import com.laze.delivery.db.account.AccountEntity;
import com.laze.delivery.db.account.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    private  final AccountRepository accountRepository;

    @GetMapping("/me")
    public AccountMeResponse me(){

        return AccountMeResponse.builder()
                .name("laze")
                .email("yysi8771@gmail.com")
                .registeredAt(LocalDateTime.now())
                .build();
    }
}
