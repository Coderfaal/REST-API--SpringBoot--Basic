package com.spring.restfulapi.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class loanDTO {


        @NotNull(message = "borrowerName should not be null")
        @NotBlank(message = "borrowerName should not be blank")
         String borrowerName;
         String dateBorrowed;
         @Min(value = 5, message = "Value cannot be less than 1")
         @Max(value=100000,message = "Value cannont be more than 100000")
          double amount;
 @Min(value = 1,message = "Value is gould not be less 1 year")
        @Max(value=20, message = "Value should not be more than 20 years")
    int tenure;
    int balanceEMI;
    boolean loanStatus;


    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public boolean isLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(boolean loanStatus) {
        this.loanStatus = loanStatus;
    }

    public String getDateBorrowed() {
        return dateBorrowed;
    }

    public void setDateBorrowed(String dateBorrowed) {
        this.dateBorrowed = dateBorrowed;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }



    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    public int getBalanceEMI() {
        return balanceEMI;
    }

    public void setBalanceEMI(int balanceEMI) {
        this.balanceEMI = balanceEMI;
    }
}

