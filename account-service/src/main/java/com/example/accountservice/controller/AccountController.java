package com.example.accountservice.controller;

import com.example.accountservice.dto.AccountDto;
import com.example.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    @Value("${slow:0}")
    private Integer slowDown;

    private final AccountService accountService;

    @SneakyThrows
    @GetMapping("/account")
    public AccountDto getAccountForOrganization(@RequestParam String organizationId) {
        Thread.sleep(slowDown);
        return accountService.getAccountByOrganization(organizationId);
    }
}
