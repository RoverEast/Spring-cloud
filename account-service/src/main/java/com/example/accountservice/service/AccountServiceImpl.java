package com.example.accountservice.service;

import com.example.accountservice.dto.AccountDto;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final Map<String, String> cache = new HashMap<>();

    @Override
    public AccountDto getAccountByOrganization(String organizationId) {

        var accountNumber = Optional.ofNullable(cache.get(organizationId))
                .orElseGet(() -> {
                    var newAccountNumber = UUID.randomUUID().toString();
                    cache.put(organizationId, newAccountNumber);
                    return newAccountNumber;
                });

        return AccountDto.builder()
                .accountNumber(accountNumber)
                .currency("USD")
                .isActive(true)
                .build();

    }
}
