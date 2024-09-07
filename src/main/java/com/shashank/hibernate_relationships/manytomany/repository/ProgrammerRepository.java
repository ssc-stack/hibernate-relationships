package com.shashank.hibernate_relationships.manytomany.repository;

import com.shashank.hibernate_relationships.manytomany.entities.Programmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammerRepository extends JpaRepository<Programmer, Integer> {
}
