package com.shashank.hibernate_relationships;

import com.shashank.hibernate_relationships.onetomany.entities.Customer;
import com.shashank.hibernate_relationships.onetomany.entities.PhoneNumber;

import com.shashank.hibernate_relationships.onetomany.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class HibernateRelationshipsApplicationTests {

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setName("Shashank");

		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.setNumber("1234567890");
		phoneNumber.setType("cell");

		PhoneNumber phoneNumber2 = new PhoneNumber();
		phoneNumber2.setNumber("0987654321");
		phoneNumber2.setType("home");
		customer.addPhoneNumber(phoneNumber);
		customer.addPhoneNumber(phoneNumber2);
		customerRepository.save(customer);

	}

	@Test
	@Transactional
	void testLoadCustomer() {
		Customer customer = customerRepository.findById(12L).get();
		System.out.println(customer.getName());
		Set<PhoneNumber> phoneNumbers = customer.getPhoneNumbers();
		for(PhoneNumber phoneNumber : phoneNumbers) {
			System.out.println(phoneNumber.getNumber());
		}
	}

}
