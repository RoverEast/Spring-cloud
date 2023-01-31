package com.epam.organization.dto;

import java.util.List;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class OrganizationDto {

    private String id;
    private String country;
    private List<AccountDto> accounts;

}
