package com.atm.list.service.Impl;

import com.atm.list.model.ATMListResponse;
import com.atm.list.repository.ATMListRepo;
import com.atm.list.service.ATMListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Slf4j
@Service("atmListService")
public class ATMListServiceImpl implements ATMListService {

    @Autowired
    ATMListRepo atmListRepo;

    public Function<Long, HttpHeaders> toHttpHeaders = id -> {
        HttpHeaders headers = new HttpHeaders();
        headers.set("identification", Long.toString(id));
        headers.set("Content-Type", "application/json");
        return headers;
    };

    @Override
    public List<ATMListResponse> getATMList(long id) {
        log.info("Service: Fetching ATMs with id {}", id);
        return atmListRepo.getATMList(toHttpHeaders.apply(id)).getBody().data;
    }

}
