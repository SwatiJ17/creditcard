package com.swati.creditcard.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {IsValidCreditCardValidator.class})
public @interface IsValidCreditCard {
    String message() default "Credit card is incorrect";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
