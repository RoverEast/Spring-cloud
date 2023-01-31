package com.epam.organization.service;

import com.epam.organization.client.AccountClient;
import com.epam.organization.client.AccountClientImpl;
import com.epam.organization.client.feign.AccountClientFeign;
import com.epam.organization.client.loadbalnced.LoadBalancedAccountClientImpl;
import com.epam.organization.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {


        private final AccountClientImpl accountClient;
//        private final LoadBalancedAccountClientImpl accountClient;
//    private final AccountClientFeign accountClient;

    @Override
    public AccountDto getAccountForOrganization(String organizationId) {
        return accountClient.getAccountByOrganizationId(organizationId);
    }

}
