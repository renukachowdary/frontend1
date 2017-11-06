package com.spring.test;

import static org.junit.Assert.assertEquals;


import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.dao.PaymentDAO;
import com.spring.model.Payment;

@Ignore
public class PaymentTest {
	
	@Autowired
	private static Payment payment;
	
	@Autowired
	private static PaymentDAO paymentDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize(){
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.spring.*");
		context.refresh();
		
		paymentDAO = (PaymentDAO) context.getBean("paymentDAO");
		
		payment = (Payment) context.getBean("payment");
		
	
	}
	
	@Test
	public void createAddressTest(){
		
		payment.setPaymentMethod("netbanking");
		payment.setUserId(4);
		payment.setTotalAmount(700);
		boolean response = paymentDAO.savePaymentInfo(payment);
		assertEquals("PaymentTest",true,response);
	}

}