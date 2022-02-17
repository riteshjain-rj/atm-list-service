package com.atm.list.repository;

import com.atm.list.model.DownStreamAPIResponse;
import com.atm.list.repository.Impl.ATMListRepoImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ATMListRepoImplTest {

    @InjectMocks
    ATMListRepoImpl atmListRepo;

    @Mock
    RestTemplate restTemplate;

    private String apiScheme;
    private String apiHost;
    private String apiPath;

    @Before
    public void setup()  {
        apiScheme = "https";
        apiHost = "api.datamuse.com";
        apiPath = "/words";
        ReflectionTestUtils.setField(atmListRepo, "apiScheme", apiScheme);
        ReflectionTestUtils.setField(atmListRepo, "apiHost", apiHost);
        ReflectionTestUtils.setField(atmListRepo, "apiPath", apiPath);
    }

    @Test
    public void getATMListTest() throws Exception {

        UriComponentsBuilder builder = UriComponentsBuilder.newInstance()
                .scheme(apiScheme)
                .host(apiHost)
                .path(apiPath).encode();

        HttpHeaders headers = new HttpHeaders();
        headers.set("identification", "30847300");

        BDDMockito.given(restTemplate.exchange(builder.build().toUri(),
                HttpMethod.GET, new HttpEntity<Object>(headers), DownStreamAPIResponse.class))
                .willReturn(new ResponseEntity<>(HttpStatus.OK));

        ResponseEntity<DownStreamAPIResponse> entity = atmListRepo.getATMList(headers);
        Assert.assertEquals(new ResponseEntity<DownStreamAPIResponse>(HttpStatus.OK), entity);
    }
}
