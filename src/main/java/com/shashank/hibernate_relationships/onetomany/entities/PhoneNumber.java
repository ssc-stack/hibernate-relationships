package com.shashank.hibernate_relationships.onetomany.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "phone_number")
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
