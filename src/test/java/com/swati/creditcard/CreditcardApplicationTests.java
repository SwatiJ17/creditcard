package com.swati.creditcard;

import com.swati.creditcard.service.CreditCardService;
import com.swati.creditcard.web.rest.CreditCardApiController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CreditcardApplicationTests {

	@Autowired
	private CreditCardApiController controller;

	@Autowired
	private CreditCardService service;

	@Test
	public void contextLoads() {
		Assert.assertNotNull(controller);
		Assert.assertNotNull(service);
	}
}
