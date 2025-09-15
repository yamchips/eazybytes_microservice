package com.eazybytes.loans.mapper;

import com.eazybytes.loans.dto.LoanDTO;
import com.eazybytes.loans.entity.Loan;

public class LoanMapper {
    public static LoanDTO mapToLoanDTO(Loan loan,LoanDTO loanDTO) {
        loanDTO.setLoanNumber(loan.getLoanNumber());
        loanDTO.setLoanType(loan.getLoanType());
        loanDTO.setTotalLoan(loan.getTotalLoan());
        loanDTO.setAmountPaid(loan.getAmountPaid());
        loanDTO.setMobileNumber(loan.getMobileNumber());
        loanDTO.setOutstandingAmount(loan.getOutstandingAmount());
        return loanDTO;
    }

    public static Loan mapToLoan(LoanDTO loanDTO, Loan loan) {
        loan.setAmountPaid(loanDTO.getAmountPaid());
        loan.setLoanNumber(loanDTO.getLoanNumber());
        loan.setLoanType(loanDTO.getLoanType());
        loan.setTotalLoan(loanDTO.getTotalLoan());
        loan.setOutstandingAmount(loanDTO.getOutstandingAmount());
        loan.setMobileNumber(loanDTO.getMobileNumber());
        return loan;
    }
}
