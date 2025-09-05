package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDTO;

public interface IAccountsService {
    /**
     * This method will create a new account for the given customer
     * @param customerDTO contains the customer information
     */
    void createAccount(CustomerDTO customerDTO);
}
