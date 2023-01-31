package com.example.accountservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDto {

    private String accountNumber;
    private String currency;
    private Boolean isActive;

}
