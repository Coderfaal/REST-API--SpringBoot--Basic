package com.spring.restfulapi.service;

import com.spring.restfulapi.entity.Loan;
import com.spring.restfulapi.repository.LoanRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    LoanRepositiry repositiry;






    public Loan addLone(Loan loan){
        return repositiry.save(loan);
    }


    public Loan getLoan(Long loanId){
        Optional<Loan> OptionalLoan = repositiry.findById(loanId);

        return OptionalLoan.get();
    }







}
