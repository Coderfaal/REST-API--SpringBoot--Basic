package com.spring.restfulapi.service;

import com.spring.restfulapi.dto.loanDTO;
import com.spring.restfulapi.entity.Loan;
import com.spring.restfulapi.repository.LoanRepositiry;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    LoanRepositiry repositiry;


    public Loan addLone(@Valid loanDTO loanDto) {
        Loan lEntity= new Loan();

        lEntity.setDateBorrowed(loanDto.getDateBorrowed());
        lEntity.setBorrowerName(loanDto.getBorrowerName());

        lEntity.setTenure(loanDto.getTenure());
        lEntity.setAmount(loanDto.getAmount());

        lEntity.setLoanStatus(loanDto.isLoanStatus());
        lEntity.setBalanceEMI(loanDto.getBalanceEMI());

        return repositiry.save(lEntity);
    }


    public Loan getLoan(Long loanId) {
        Optional<Loan> OptionalLoan = repositiry.findById(loanId);

        return OptionalLoan.get();
    }

    public List<Loan> getLoans() {
        return repositiry.findAll();
    }

//    public Loan update(@Valid loanDTO l) {
//        return repositiry.save(l);
//    }

//    public Loan update2(@Valid loanDTO l) {
//        //here temp is coming from daatabase and l is coming from postman
//        Optional<Loan> optional = repositiry.findById(l.getLoanId());
//        Loan temp = optional.get();
//        if (l.getBorrowerName() != null)
//            temp.setBorrowerName(l.getBorrowerName());
//
//        if (l.getDateBorrowed() != null)
//            temp.setDateBorrowed(l.getDateBorrowed());
//
//        // if (((Integer)(l.getTenure())) != null)
//        if (temp.getTenure() != l.getTenure())
//            temp.setTenure(l.getTenure());
//
//        if (temp.getAmount() < l.getAmount())
//            temp.setAmount(l.getAmount());
//
//        return repositiry.save(temp);
//    }



    public void remove(Long lId){
        Optional<Loan> loan = repositiry.findById(lId);

        if (loan.isPresent()){
            repositiry.delete(loan.get());}
        else {
            throw new IllegalArgumentException(lId+ "not found !");
        }


    }
}

