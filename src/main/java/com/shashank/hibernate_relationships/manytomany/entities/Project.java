package com.shashank.hibernate_relationships.manytomany.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToMany(mappedBy = "projects")
    private Set<Programmer> programmers;
}
