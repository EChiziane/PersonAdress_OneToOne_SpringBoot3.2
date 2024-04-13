package com.api.personadress_onetoone_springboot3.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB-PERSON")
public class PersonModel implements Serializable {
    private static final long serialVersionUID = 1L; // Serial version UID

    @Id // Marks the field as the primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // Generates automatically the value for the field
    private UUID id; // Field for storing the identifier

    @Column(nullable = false)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressModel address;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }
}
