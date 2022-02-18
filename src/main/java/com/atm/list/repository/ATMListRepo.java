package com.atm.list.repository;

import com.atm.list.model.DownStreamAPIResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

public interface ATMListRepo {
    ResponseEntity<DownStreamAPIResponse> getATMList(HttpHeaders headers);
}
