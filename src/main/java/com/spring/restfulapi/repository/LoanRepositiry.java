package com.spring.restfulapi.repository;

import com.spring.restfulapi.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoanRepositiry extends JpaRepository<Loan,Long> {

    List<Loan> findByBorrowerNameLike(String patternString);

    List<Loan> findByBorrowerNameOrderByBorrowerName(String name);
    List<Loan> findByLoanStatus(boolean loanStatus);
    List<Loan> findByTenureLessThan(Long loanId);
    List<Loan> findByTenureBetween(int tenure1, int tenure2 );
    List<Loan> findByDateBorrowedBefore(String dateBorrowed);
    List<Loan> findByBalanceEMIGreaterThanEqual(int balanceEMI);




    @Query("Select l.borrowerName from Loan l where l.loanId= :id")
    String findByBorrowerNameById(@Param("id") Long id);

    @Query("Select l.borrowerName, l.balanceEMI from Loan l where l.loanId = :id")
    String findBorrowerNameAndBalanceEMIById(@Param("id") Long id);
    @Query(
            value = "SELECT * FROM Loan l where l.tenure = :tenure AND l.BalanceEMI = :balEMI",
            nativeQuery=true
    )
    public Optional<Loan> findByTenureAndBalanceEMI(@Param("tenure") int tenure,
                                                    @Param("balEMI") int balEMI);


}