package com.epam.organization.service;

import com.epam.organization.dto.OrganizationDto;

public interface OrganizationService {

    OrganizationDto getOrganizationById(String organizationId);

}
