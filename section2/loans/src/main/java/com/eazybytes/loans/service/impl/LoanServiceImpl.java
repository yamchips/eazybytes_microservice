package com.eazybytes.loans.service.impl;

import com.eazybytes.loans.constant.LoanConstants;
import com.eazybytes.loans.dto.LoanDTO;
import com.eazybytes.loans.entity.Loan;
import com.eazybytes.loans.exception.LoanAlreadyExistsException;
import com.eazybytes.loans.exception.ResourceNotFoundException;
import com.eazybytes.loans.mapper.LoanMapper;
import com.eazybytes.loans.repository.LoanRepository;
import com.eazybytes.loans.service.ILoanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements ILoanService {

    private LoanRepository loanRepository;

    /**
     * This method creates a new loan given a mobile number
     *
     * @param mobileNumber contains mobile number
     */
    @Override
    public void createLoan(String mobileNumber) {
        Optional<Loan> optLoan = loanRepository.findByMobileNumber(mobileNumber);
        if (optLoan.isPresent()) {
            throw new LoanAlreadyExistsException(
                    "Loan already registered with given mobile number " + mobileNumber);
        }
        loanRepository.save(createNewLoan(mobileNumber));
    }

    /**
     * @param mobileNumber contains mobile number
     * @return Loan DTO
     */
    @Override
    public LoanDTO getLoan(String mobileNumber) {
        Loan loan = loanRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber));
        return LoanMapper.mapToLoanDTO(loan, new LoanDTO());
    }

    /**
     * @param loanDTO contains updated information
     * @return whether the update is successful
     */
    @Override
    public boolean updateLoan(LoanDTO loanDTO) {
        String mobileNumber = loanDTO.getMobileNumber();
        Loan loan = loanRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber));
        LoanMapper.mapToLoan(loanDTO, loan);
        loanRepository.save(loan);
        return true;
    }

    private Loan createNewLoan(String mobileNumber) {
        Loan newLoan = new Loan();
        long randomLoanNumber = 100_000_000_000L + new Random().nextInt(900_000_000);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setTotalLoan(LoanConstants.NEW_LOAN_LIMIT);
        newLoan.setLoanType(LoanConstants.HOME_LOAN);
        newLoan.setMobileNumber(mobileNumber);
        newLoan.setOutstandingAmount(LoanConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setCreatedAt(LocalDateTime.now());
        newLoan.setCreatedBy("defaultUser");
        return newLoan;
    }
}
