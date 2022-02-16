package atm.list.service.service.Impl;

import atm.list.service.model.ATMListResponse;
import atm.list.service.repository.ATMListRepo;
import atm.list.service.service.ATMListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("atmListService")
public class ATMListServiceImpl implements ATMListService {

    @Autowired
    ATMListRepo atmListRepo;

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        return headers;
    }

    @Override
    public List<ATMListResponse> getATMList(long id) {
        return atmListRepo.getATMList(getHeaders()).getBody().data;
    }
}
