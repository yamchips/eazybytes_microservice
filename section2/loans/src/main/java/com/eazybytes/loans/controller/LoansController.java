package com.eazybytes.loans.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {
    @GetMapping("/")
    public String getAllLoans() {
        return "Hello, all loans";
    }
}
