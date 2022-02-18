package com.atm.list.repository.Impl;

import com.atm.list.model.DownStreamAPIResponse;
import com.atm.list.repository.ATMListRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Repository("atmListRepo")
public class ATMListRepoImpl implements ATMListRepo {

    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;

    @Value("${api.scheme}")
    private String apiScheme;

    @Value("${api.host}")
    private String apiHost;

    @Value("${api.path}")
    private String apiPath;

    @Override
    public ResponseEntity<DownStreamAPIResponse> getATMList(HttpHeaders headers) {
        log.info("Repository: Fetching ATMs downStream API trigger");
        UriComponentsBuilder builder = UriComponentsBuilder.newInstance()
        .scheme(apiScheme)
        .host(apiHost)
        .path(apiPath);

        return restTemplate.exchange(builder.build().toUri(),
                HttpMethod.GET, new HttpEntity<Object>(headers), DownStreamAPIResponse.class);
    }
}

