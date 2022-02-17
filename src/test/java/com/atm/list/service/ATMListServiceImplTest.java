package com.atm.list.service;

import com.atm.list.model.ATMListResponse;
import com.atm.list.model.DownStreamAPIResponse;
import com.atm.list.repository.ATMListRepo;
import com.atm.list.service.Impl.ATMListServiceImpl;
import com.atm.list.util.TestUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class ATMListServiceImplTest {

    private static final String MOCK_RESPONSE = "json/response.json";

    @InjectMocks
    ATMListServiceImpl atmListService;

    @Mock
    ATMListRepo atmListRepo;

    @Autowired
    ResourceLoader resourceLoader;

    @Before
    public void setup() throws Exception{
        Mockito.when((atmListRepo.getATMList(Mockito.any())))
                .thenReturn(new ResponseEntity<DownStreamAPIResponse>(TestUtils.getObjectFromJson(MOCK_RESPONSE, DownStreamAPIResponse.class, resourceLoader), HttpStatus.OK));
    }

    @Test
    public void givenATMListRepository_thenOK() throws IOException {
        DownStreamAPIResponse response = TestUtils.getObjectFromJson(MOCK_RESPONSE, DownStreamAPIResponse.class, resourceLoader);
        Assert.assertEquals(response.getData(), atmListService.getATMList(30847300L));
    }

}
