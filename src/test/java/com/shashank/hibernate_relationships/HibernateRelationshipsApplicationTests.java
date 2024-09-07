package com.shashank.hibernate_relationships;

import com.shashank.hibernate_relationships.onetomany.entities.Customer;
import com.shashank.hibernate_relationships.onetomany.entities.PhoneNumber;

import com.shashank.hibernate_relationships.onetomany.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

@SpringBootTest
class HibernateRelationshipsApplicationTests {

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setName("Shashank");
		HashSet<PhoneNumber> phoneNumbers = new HashSet<>();

		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.setNumber("1234567890");
		phoneNumber.setType("cell");
		phoneNumbers.add(phoneNumber);

		PhoneNumber phoneNumber2 = new PhoneNumber();
		phoneNumber2.setNumber("0987654321");
		phoneNumber2.setType("home");
		phoneNumbers.add(phoneNumber2);

		customer.setPhoneNumbers(phoneNumbers);

		customerRepository.save(customer);

	}

}
