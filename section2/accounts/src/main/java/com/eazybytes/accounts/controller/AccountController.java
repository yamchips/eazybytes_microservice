package com.eazybytes.accounts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hi World, Tom Riddle!";
    }
}
