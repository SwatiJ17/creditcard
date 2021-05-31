package com.swati.creditcard.validator;


import com.swati.creditcard.model.CreditCardBean;
import com.swati.creditcard.utils.LUHNAlgo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsValidCreditCardValidator implements ConstraintValidator<IsValidCreditCard, CreditCardBean> {

    @Override
    public void initialize(IsValidCreditCard constraintAnnotation) {
    }

    @Override
    public boolean isValid(CreditCardBean value, ConstraintValidatorContext context) {
        if (value == null) return true;

        if (value.getCreditCardNumber() == null || value.getCreditCardNumber().isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Credit card number is required")
                    .addPropertyNode("creditCardNumber").addConstraintViolation();
            return false;
        }

        if (!LUHNAlgo.isValidCreditCardNumber(value.getCreditCardNumber())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Credit card number is not valid")
                    .addPropertyNode("creditCardNumber").addConstraintViolation();
            return false;
        }

        return true;
    }
}
