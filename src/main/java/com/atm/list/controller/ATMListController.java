package com.atm.list.controller;

import com.atm.list.model.ATMListResponse;
import com.atm.list.service.ATMListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api")
@Tag(name = "ATMListController", description = "the ATM List API will return the list of ATM's")
public class ATMListController {

    @Autowired
    @Qualifier("atmListService")
    ATMListService atmListService;

    @Operation(summary = "Get ATM list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the ATM list",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ATMListResponse.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid  identification id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "ATM list not found",
                    content = @Content) })
    @GetMapping("/atms")
    public ResponseEntity<List<ATMListResponse>> getATMList(
            @Parameter(description = "identification id for of ATM list to be searched")
            @RequestHeader(name = "identification") long identification) {
        log.info("Controller: Fetching ATM list with id {}", identification);
        List<ATMListResponse> list = atmListService.getATMList(identification);
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}