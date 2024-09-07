package com.shashank.hibernate_relationships;

import com.shashank.hibernate_relationships.manytomany.entities.Programmer;
import com.shashank.hibernate_relationships.manytomany.entities.Project;
import com.shashank.hibernate_relationships.manytomany.repository.ProgrammerRepository;
import com.shashank.hibernate_relationships.onetomany.entities.Customer;
import com.shashank.hibernate_relationships.onetomany.entities.PhoneNumber;

import com.shashank.hibernate_relationships.onetomany.repository.CustomerRepository;
import com.shashank.hibernate_relationships.onetoone.entities.License;
import com.shashank.hibernate_relationships.onetoone.entities.Person;
import com.shashank.hibernate_relationships.onetoone.repositories.LicenseRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class HibernateRelationshipsApplicationTests {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProgrammerRepository programmerRepository;
	@Autowired
	private LicenseRepository licenseRepository;

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

	@Test
	void testManyToManyCreateProgrammer() {
		Programmer programmer = new Programmer();
		programmer.setName("Shashank");

		Project project = new Project();
		project.setName("Hibernate Project");

		Project project2 = new Project();
		project2.setName("Spring Project");

		Set<Project> projects = new HashSet<>();
		projects.add(project);
		projects.add(project2);

		programmer.setProjects(projects);
		programmerRepository.save(programmer);
		//programmerRepository.save(programmer2);
	}

	@Test
	void testManyToManyFindProgrammer() {
		Programmer programmer = programmerRepository.findById(1).get();
		System.out.println(programmer.getName());
		Set<Project> projects = programmer.getProjects();
		for (Project project : projects) {
			System.out.println(project.getName());
		}
	}

	@Test
	void testOneToOneCreateLicense() {
		License license = new License();
		license.setType("CAR");
		license.setValidFrom(new Date());
		license.setValidTo(new Date());

		Person person = new Person();
		person.setFirstName("Shashank");
		person.setLastName("Singh");
		person.setAge(25);
		license.setPerson(person);
		licenseRepository.save(license);
	}
}
