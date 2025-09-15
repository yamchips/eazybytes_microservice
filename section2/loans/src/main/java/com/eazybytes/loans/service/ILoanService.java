package com.eazybytes.loans.service;

import com.eazybytes.loans.dto.LoanDTO;

public interface ILoanService {
    /**
     * This method creates a new loan given a mobile number
     * @param mobileNumber contains mobile number
     */
    void createLoan(String mobileNumber);

    /**
     *
     * @param mobileNumber contains mobile number
     * @return Loan DTO
     */
    LoanDTO getLoan(String mobileNumber);

    /**
     *
     * @param loanDTO contains updated information
     * @return whether the update is successful
     */
    boolean updateLoan(LoanDTO loanDTO);
}
