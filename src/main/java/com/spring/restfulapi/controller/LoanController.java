package com.spring.restfulapi.controller;

import com.spring.restfulapi.entity.Loan;
import com.spring.restfulapi.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("loan/api/v1.0")
public class LoanController {


    @Autowired
    LoanService service;

    @PostMapping("/create")    //http://localhost:/loan/api/v1.0/create
     public Loan loanApplication(@RequestBody Loan l){

        return service.addLone(l);
    }


    /// //http://localhost:45587/loan/api/v1.0/fetch/1

    @GetMapping("/fetch/{lId}")
    public Loan getLoan(@PathVariable Long lId) {
        return service.getLoan(lId);
    }



}
