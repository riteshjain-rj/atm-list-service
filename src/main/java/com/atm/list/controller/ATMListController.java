package com.atm.list.controller;

import com.atm.list.model.ATMListResponse;
import com.atm.list.service.ATMListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class ATMListController {


    @Autowired
    @Qualifier("atmListService")
    ATMListService atmListService;

    @GetMapping("/atms")
    public List<ATMListResponse> getATMList(@RequestHeader(name = "identification") long identification) {
        log.info("Controller: Fetching ATM list with id {}", identification);
        return atmListService.getATMList(identification);
    }
}