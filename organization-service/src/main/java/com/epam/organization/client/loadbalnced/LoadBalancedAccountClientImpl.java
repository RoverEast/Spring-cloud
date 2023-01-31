package com.epam.organization.client.loadbalnced;

import com.epam.organization.client.AccountClient;
import com.epam.organization.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class LoadBalancedAccountClientImpl implements AccountClient {

    public static final String GET_ACCOUNT_BY_ORGANIZATION_ID = "/account";

    private final RestTemplate loadBalancedRestTemplate;

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

        return loadBalancedRestTemplate.exchange(
                url,
                HttpMethod.GET,
                httpEntity,
                AccountDto.class
        ).getBody();

    }
}
