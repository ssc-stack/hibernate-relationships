package com.shashank.hibernate_relationships.onetomany.repository;

import com.shashank.hibernate_relationships.onetomany.entities.Customer;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
