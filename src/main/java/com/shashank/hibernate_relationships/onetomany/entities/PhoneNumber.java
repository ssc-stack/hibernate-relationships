package com.shashank.hibernate_relationships.onetomany.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Data
@Entity
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String number;
    private String type;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
