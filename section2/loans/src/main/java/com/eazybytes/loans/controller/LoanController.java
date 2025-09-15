package com.eazybytes.loans.controller;

import com.eazybytes.loans.constant.LoanConstants;
import com.eazybytes.loans.dto.LoanDTO;
import com.eazybytes.loans.dto.ResponseDTO;
import com.eazybytes.loans.service.ILoanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class LoanController {

    private ILoanService iLoanService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createLoan(@RequestParam String mobileNumber) {
        iLoanService.createLoan(mobileNumber);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDTO(LoanConstants.STATUS_201, LoanConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<LoanDTO> fetchLoan(@RequestParam String mobileNumber) {
        LoanDTO loanDTO = iLoanService.getLoan(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(loanDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateLoan(@RequestBody LoanDTO loanDTO) {
        boolean isUpdated = iLoanService.updateLoan(loanDTO);
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDTO(LoanConstants.STATUS_200, LoanConstants.MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDTO(LoanConstants.STATUS_417,
                            LoanConstants.MESSAGE_417_UPDATE));
        }
    }
}
