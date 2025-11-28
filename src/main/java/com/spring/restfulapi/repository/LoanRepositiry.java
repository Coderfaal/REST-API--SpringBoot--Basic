package com.spring.restfulapi.repository;

import com.spring.restfulapi.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepositiry extends JpaRepository<Loan,Long> {

}