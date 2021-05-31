package com.swati.creditcard.service;

import com.swati.creditcard.dto.CreditCardEntity;
import com.swati.creditcard.model.CreditCardBean;
import com.swati.creditcard.repository.CreditCardRepository;
import com.swati.creditcard.utils.MappingUtil;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditCardService {

    final CreditCardRepository creditcardRepository;

    public CreditCardService(CreditCardRepository creditcardRepository) {
        this.creditcardRepository = creditcardRepository;
    }

    public List<CreditCardBean> findAll() {
        final Collection<CreditCardEntity> all = creditcardRepository.findAll();
        return all.stream().map(MappingUtil::toBean).collect(Collectors.toList());
    }

    public CreditCardBean create(CreditCardBean creditCardValueBean) {
        return MappingUtil.toBean(creditcardRepository.save(MappingUtil.toEntityBean(creditCardValueBean)));
    }
}
