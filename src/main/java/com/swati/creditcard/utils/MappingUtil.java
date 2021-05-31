package com.swati.creditcard.utils;

import com.swati.creditcard.dto.CreditCardEntity;
import com.swati.creditcard.model.CreditCardBean;

public class MappingUtil {

    public static CreditCardBean toBean(CreditCardEntity creditCardEntity) {

        return new CreditCardBean(
                creditCardEntity.getNumber(),
                creditCardEntity.getName(),
                creditCardEntity.getCreditLimit(),
                creditCardEntity.getRemainingCredit());
    }

    public static CreditCardEntity toEntityBean(CreditCardBean creditCardValueBean) {
        final CreditCardEntity creditCardEntity = new CreditCardEntity();
        creditCardEntity.setNumber(creditCardValueBean.getCreditCardNumber());
        creditCardEntity.setName(creditCardValueBean.getName());
        creditCardEntity.setCreditLimit(creditCardValueBean.getCreditLimit());
        creditCardEntity.setRemainingCredit(creditCardValueBean.getRemainingCredit());
        return creditCardEntity;
    }
}
