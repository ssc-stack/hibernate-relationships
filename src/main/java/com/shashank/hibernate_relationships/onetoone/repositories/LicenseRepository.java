package com.shashank.hibernate_relationships.onetoone.repositories;

import com.shashank.hibernate_relationships.onetoone.entities.License;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenseRepository extends JpaRepository<License, Integer> {
}
