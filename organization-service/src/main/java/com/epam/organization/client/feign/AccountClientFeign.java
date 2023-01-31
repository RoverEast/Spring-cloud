package com.epam.organization.client.feign;

import com.epam.organization.dto.AccountDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient("account-service")
public interface AccountClientFeign {

    @GetMapping("/account")
    AccountDto getAccountByOrganizationId(@RequestParam String organizationId);
}
