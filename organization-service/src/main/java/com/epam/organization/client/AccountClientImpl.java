package com.epam.organization.client;

import com.epam.organization.dto.AccountDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class AccountClientImpl implements AccountClient {

    public static final String GET_ACCOUNT_BY_ORGANIZATION_ID = "/account";

    @Value("${account-service}")
    public String accountServiceURL;

    @Override
    public AccountDto getAccountByOrganizationId(String organizationId) {
        var httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        var httpEntity = new HttpEntity(httpHeaders);

        var url = UriComponentsBuilder.fromHttpUrl(
                        accountServiceURL + GET_ACCOUNT_BY_ORGANIZATION_ID)
                .queryParam("organizationId", organizationId)
                .build()
                .toUriString();

        return new RestTemplate().exchange(
                url,
                HttpMethod.GET,
                httpEntity,
                AccountDto.class
        ).getBody();

    }
}
