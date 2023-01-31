package com.epam.organization.client;

import com.epam.organization.dto.AccountDto;

public interface AccountClient {

    AccountDto getAccountByOrganizationId(String organizationId);

}
