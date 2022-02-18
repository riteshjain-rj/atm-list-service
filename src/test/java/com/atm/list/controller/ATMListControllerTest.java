package com.atm.list.controller;

import com.atm.list.service.ATMListService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class ATMListControllerTest {

    @InjectMocks
    ATMListController atmListController;

    @Mock
    ATMListService atmListService;

    MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(atmListController).build();
    }

    @Test
    public void whenGetATMList_thenSuccessful() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/atms")
                .header("identification", "30847300")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status()
                .is2xxSuccessful());

    }

}
