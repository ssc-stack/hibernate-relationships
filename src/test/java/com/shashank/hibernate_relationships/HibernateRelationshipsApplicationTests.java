package com.shashank.hibernate_relationships;

import com.shashank.hibernate_relationships.onetomany.entities.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HibernateRelationshipsApplicationTests {

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	void createCustomer() {

	}

}
