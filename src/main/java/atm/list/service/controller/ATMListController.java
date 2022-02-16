package atm.list.service.controller;

import atm.list.service.model.ATMListResponse;
import atm.list.service.service.ATMListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ATMListController {


    @Autowired
    @Qualifier("atmListService")
    ATMListService atmListService;

    @GetMapping("/atms")
    public List<ATMListResponse> getATMList(@RequestHeader(name = "identification") long identification) {
        return atmListService.getATMList(identification);
    }
}