package com.example.dealerservice.model;

import jakarta.persistence.*;

/**
 * Represents a dealer for automotive parts.
 */
@Entity
@Table(name = "dealers")
public class Dealer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String city;

    private String address;

    private String contact;

    public Dealer() {}

    public Dealer(String name, String city, String address, String contact) {
        this.name = name;
        this.city = city;
        this.address = address;
        this.contact = contact;
    }

    // Getters and setters...

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
}