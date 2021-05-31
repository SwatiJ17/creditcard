package com.swati.creditcard.model;

import com.swati.creditcard.validator.IsValidCreditCard;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@IsValidCreditCard
public class CreditCardBean {

//    Long id;

    @NotNull
    String creditCardNumber;

//    public Long getId() {
//        return id;
//    }

    public CreditCardBean(String creditCardNumber, String name, Double creditLimit, Double remainingCredit) {
//        this.id = id;
        this.creditCardNumber = creditCardNumber;
        this.name = name;
        this.creditLimit = creditLimit;
        this.remainingCredit = remainingCredit;
    }

    public CreditCardBean() {
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Double getRemainingCredit() {
        return remainingCredit;
    }

    public void setRemainingCredit(Double remainingCredit) {
        this.remainingCredit = remainingCredit;
    }

    @NotNull
    String name;

    @NotNull
    Double creditLimit;

    Double remainingCredit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCardBean that = (CreditCardBean) o;
        return creditCardNumber.equals(that.creditCardNumber) &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditCardNumber, name);
    }
}
