package com.epam.organization.controller;

import com.epam.organization.dto.OrganizationDto;
import com.epam.organization.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @GetMapping("/organization/{organizationId}")
    public OrganizationDto getOrganization(@PathVariable String organizationId) {
        return organizationService.getOrganizationById(organizationId);
    }
}
