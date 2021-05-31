package com.swati.creditcard.repository;

import com.swati.creditcard.dto.CreditCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCardEntity, Long> {

}
