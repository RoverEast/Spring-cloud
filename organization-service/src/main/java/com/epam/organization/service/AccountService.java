package com.epam.organization.service;


import com.epam.organization.dto.AccountDto;

public interface AccountService {

    public AccountDto getAccountForOrganization(String organizationId);
}
