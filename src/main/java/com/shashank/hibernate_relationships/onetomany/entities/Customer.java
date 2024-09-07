package com.shashank.hibernate_relationships.onetomany.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<PhoneNumber> phoneNumbers;

    public void addPhoneNumber(PhoneNumber phoneNumber) {
        if(phoneNumbers == null) {
            phoneNumbers = new HashSet<>();
        }
        phoneNumber.setCustomer(this); // Ensure customer is set for every PhoneNumber
        phoneNumbers.add(phoneNumber);
    }


}
