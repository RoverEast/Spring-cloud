package com.epam.organization.service;

import com.epam.organization.client.feign.AccountClientFeign;
import com.epam.organization.dto.AccountDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {


    private final AccountClientFeign accountClient;

    @Override
//    @CircuitBreaker(name = "accountService", fallbackMethod = "accountFallback")
    public AccountDto getAccountForOrganization(String organizationId) {
        return accountClient.getAccountByOrganizationId(organizationId);
    }

    public AccountDto accountFallback(String organizationId, Throwable t){
        log.warn("Fallback triggered due to {}", t.getMessage());
        return AccountDto.builder()
                .accountNumber("0000000-00000-0000")
                .currency("USD")
                .isActive(true)
                .build();
    }

}
