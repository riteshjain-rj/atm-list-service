package atm.list.service.service;

import atm.list.service.model.ATMListResponse;

import java.util.List;

public interface ATMListService {
    List<ATMListResponse> getATMList(long id);
}
