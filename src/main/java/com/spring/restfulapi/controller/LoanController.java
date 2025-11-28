package com.spring.restfulapi.controller;

import com.spring.restfulapi.entity.Loan;
import com.spring.restfulapi.service.LoanService;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.rmi.MarshalException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("loan/api/v1.0")
public class LoanController {


    @Autowired
    LoanService service;

    @PostMapping(value = "/create" ,consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    //http://localhost:/loan/api/v1.0/create  //JAXB(DOM AND SAX(SIMPLE API FOR XML PROCESSING)) jeraey->Jackson
//     public Loan loanApplication(@RequestBody Loan l){
//   */ this is a basic level */
//        return service.addLone(l);
//    }
    public ResponseEntity<Loan> loanApplication(@RequestBody Loan l){
        //return new ResponseEntity<>(HttpStatus.CREATED);   //request is successully accepted and created-- CREATED is a status message

        Loan newLoan = service.addLone(l);
///<<< using httpsStatus
//
//        return new ResponseEntity<>(newLoan, HttpStatus.OK); ////OK-> 200 success!
        ////>>>>
        HttpHeaders headers = new HttpHeaders();
        headers.add("xx-createdBy","fal");
        headers.add("content-type","application/json");

       // return new ResponseEntity<>(newLoan,headers,HttpStatus.OK);
        return ResponseEntity.ok(newLoan);

    }


    /// //http://localhost:45587/loan/api/v1.0/fetch/1

    @GetMapping("/fetch/{lId}")
    public ResponseEntity<Loan> getLoan(@PathVariable Long lId) {

        //return service.getLoan(lId);
        //return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        //return ResponseEntity.status(400).body(null);

        if(false){
            return  new ResponseEntity<>(service.getLoan(lId),HttpStatus.OK);}
        else {
            throw new IllegalArgumentException("Invalid loan id" + lId);

        }
    }

    @GetMapping("/all")
    public List<Loan> getLoans() {
        return service.getLoans();
    }

//for updating completely
    @PutMapping("/modify")
    public Loan doUpdate(@RequestBody Loan l){
        return service.update(l);
    }

    @PutMapping("/modify2")
    public Loan doUpdate2(@RequestBody Loan l){
        return service.update2(l);
    }

    @DeleteMapping("/remove/{lId}")
    public ResponseEntity<Void> delete(@PathVariable Loan lId){

               service.remove(lId.getLoanId());

        //return new ResponseEntity<>(HttpStatusCode.valueOf(204));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
