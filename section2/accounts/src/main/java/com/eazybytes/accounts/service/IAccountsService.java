package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDTO;

public interface IAccountsService {
    /**
     * This method will create a new account for the given customer
     * @param customerDTO contains the customer information
     */
    void createAccount(CustomerDTO customerDTO);

    /**
     * This method will fetch account details for the given mobile number
     * @param mobileNumber input mobile number
     * @return Accounts details based on a given mobile number
     */
    CustomerDTO fetchAccount(String mobileNumber);

    /**
     * This method will update account details except for account number
     * @param customerDTO input customerDTO object
     * @return boolean indicating whether the update is successful or not
     */
    boolean updateAccount(CustomerDTO customerDTO);

    /**
     * This method will delete both account and customer given the mobile number
     * @param mobileNumber input mobile number
     * @return boolean indicating whether the deletion is successful or not
     */
    boolean deleteAccount(String mobileNumber);
}
