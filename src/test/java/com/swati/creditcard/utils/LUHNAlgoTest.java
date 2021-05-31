package com.swati.creditcard.utils;

import org.junit.Assert;
import org.junit.Test;

public class LUHNAlgoTest {

    @Test
    public void validate_the_credit_card() {

        Assert.assertTrue(LUHNAlgo.isValidCreditCardNumber("12345678903555"));
        Assert.assertTrue(LUHNAlgo.isValidCreditCardNumber("012850003580200"));
        Assert.assertTrue(LUHNAlgo.isValidCreditCardNumber("5419691741345722"));
    }
}
