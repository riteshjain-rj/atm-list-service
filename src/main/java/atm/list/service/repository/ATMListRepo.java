package atm.list.service.repository;

import atm.list.service.model.DownStreamAPIResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

public interface ATMListRepo {
    ResponseEntity<DownStreamAPIResponse> getATMList(HttpHeaders headers);
}
