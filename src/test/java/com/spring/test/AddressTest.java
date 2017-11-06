package com.spring.test;

import static org.junit.Assert.*;
import java.sql.Timestamp;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import com.spring.dao.AddressDAO;
import com.spring.model.Address;

@Ignore
public class AddressTest {
	
	@Autowired
	private static Address address;
	
	@Autowired
	private static AddressDAO addressDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize(){
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.spring.*");
		context.refresh();
		
		addressDAO = (AddressDAO) context.getBean("addressDAO");
		
		address = (Address) context.getBean("address");
		
	
	}
	
	@Test
	public void createAddressTest(){
		
		address.setName("Rupa");
		address.setAddress1("road no 2");
		address.setAddress2("Kukatpally");
		address.setCity("Hyderabad");
		address.setState("Telangana");
		address.setPincode("500072");
		address.setEmail("rupamudra@gmail.com");
		address.setPhone("2645332678");
		address.setPersonId(65);
		address.setAddressType("HOME");
		address.setCreatedBy("TEST");
		address.setCreatedTimestamp(new Timestamp(System.currentTimeMillis()));
		
		boolean response = addressDAO.saveOrUpdate(address);
		assertEquals("CreateAddressTest",true,response);
	}
}