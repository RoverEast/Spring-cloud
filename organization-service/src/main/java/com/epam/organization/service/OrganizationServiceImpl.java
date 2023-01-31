package com.epam.organization.service;

import com.epam.organization.dto.OrganizationDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final AccountService accountService;

    @Override
    public OrganizationDto getOrganizationById(String organizationId) {
        var account = accountService.getAccountForOrganization(organizationId);

        return OrganizationDto.builder()
                .id(organizationId)
                .country("US")
                .accounts(List.of(account))
                .build();
    }
}
