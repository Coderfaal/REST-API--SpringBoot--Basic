package com.spring.restfulapi.controller;

import com.spring.restfulapi.entity.Loan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.List;


@RestController
@RequestMapping("/client/loan/api/v1.0")
public class LoanController {


    @Autowired
    RestTemplate template;

    @PostMapping(value = "/create" ,consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)

   public Loan loanApplication(@RequestBody Loan l){
//   */ this is a basic level */
      // return service.addLone(l);
        return null;
   }



    /// //http://localhost:45587/loan/api/v1.0/fetch/1

    @GetMapping("/fetch/{lId}")
    public ResponseEntity<Loan> getLoan(@PathVariable Long lId) {

       String url="http://localhost:9999/loan/api/v1.0/fetch/1";
         Loan loan= template.getForObject(url,Loan.class);

      return ResponseEntity.ok(loan);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Loan>> getLoans() {

        ResponseEntity<List<Loan>> responseEntity=
                template.exchange("http://localhost:9999/loan/api/v1.0/all", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Loan>>() {});
        List<Loan> lol =responseEntity.getBody();
       return ResponseEntity.ok(lol);
    }

//for updating completely
    @PutMapping("/modify")
    public Loan doUpdate(@RequestBody Loan l){
        return null;
    }

    @PutMapping("/modify2")
    public Loan doUpdate2(@RequestBody Loan l){
        return null;
    }

    @DeleteMapping("/remove/{lId}")
    public ResponseEntity<Void> delete(@PathVariable Loan lId){


        return null;
    }


}
