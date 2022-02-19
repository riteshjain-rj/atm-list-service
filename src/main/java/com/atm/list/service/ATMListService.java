package com.atm.list.service;


import com.atm.list.model.ATMListResponse;

import java.util.List;

public interface ATMListService {
    List<ATMListResponse> getATMList(long id);
}
