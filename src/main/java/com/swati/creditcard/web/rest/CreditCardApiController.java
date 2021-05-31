package com.swati.creditcard.web.rest;

import com.swati.creditcard.model.CreditCardBean;
import com.swati.creditcard.service.CreditCardService;
import com.swati.creditcard.utils.CustomError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/creditcards")
public class CreditCardApiController implements CreditCardApi {

    @Autowired
    private final CreditCardService creditCardService;

    public CreditCardApiController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @Override
    public ResponseEntity<Collection<CreditCardBean>> findAll() {
        final List<CreditCardBean> all = creditCardService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CreditCardBean> save(@Valid @RequestBody CreditCardBean creditCardBean) {

        if (creditCardBean.getRemainingCredit() == null)
            creditCardBean.setRemainingCredit(0.0);
        CreditCardBean creditCard;
        creditCard = creditCardService.create(creditCardBean);
        return new ResponseEntity<>(creditCard, HttpStatus.CREATED);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<CustomError> handleAll(Exception ex, WebRequest request) {
        return new ResponseEntity(new CustomError(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
