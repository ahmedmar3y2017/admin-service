package com.example.demo.entities;

// default package
// Generated Nov 23, 2017 7:42:03 PM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.*;

/**
 * Business generated by hbm2java
 */
@Where(clause = "available =1")
@Entity
@Table(name = "business")
// to dynamic insert and update
@DynamicInsert
@DynamicUpdate
@Proxy(lazy = false)
public class Business {

    private Integer id;
    private String name;

    private String logo;
    private String contact;
    @Column(name = "available", columnDefinition = "boolean default true")
    private boolean available;

    private String email;
    private String address;
    private String city;
    private String state;
    private String country;
    private Integer postalCode;
    private String url;
    private String description;
    private String notes;
    private String paymentMethods;
    private Integer active;

    private Set<Admin> admins = new HashSet<Admin>(0);
    private Set<Product> products = new HashSet<Product>(0);

    public Business() {
    }

    public Business(String name, String logo, String contact, String email, String address,
                    String city, String state, String country, Integer postalCode, String url, String description, String notes,
                    String paymentMethods, Integer active, boolean available) {
        super();
        this.name = name;

        this.logo = logo;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.url = url;
        this.description = description;
        this.notes = notes;
        this.paymentMethods = paymentMethods;
        this.active = active;
        this.available = available;

    }


    public Business(Integer id) {
        this.id = id;
    }

    public Business(Integer id, String name, String logo, String contact, String email, String address,
                    String city, String state, String country, Integer postalCode, String url, String description, String notes,
                    String paymentMethods, Integer active, Set<Admin> admins, Set<Product> products) {
        super();
        this.id = id;
        this.name = name;

        this.logo = logo;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.url = url;
        this.description = description;
        this.notes = notes;
        this.paymentMethods = paymentMethods;
        this.active = active;
        this.admins = admins;
        this.products = products;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }


    @Id
    @GeneratedValue(strategy = IDENTITY)
//     @JsonIgnore
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "logo")
    public String getLogo() {
        return this.logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Column(name = "contact")
    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Column(name = "email", unique = true)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "address")
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "city")
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "state")
    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name = "country")
    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "postalCode")
    public Integer getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    @Column(name = "url")
    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "description")
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "notes")
    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Column(name = "paymentMethods")
    public String getPaymentMethods() {
        return this.paymentMethods;
    }

    public void setPaymentMethods(String paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    @Column(name = "active", length = 1)
    public Integer getActive() {
        return this.active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "business", cascade = CascadeType.ALL)
//	@JsonManagedReference
    @JsonIgnore

    public Set<Admin> getAdmins() {
        return this.admins;
    }

    public void setAdmins(Set<Admin> admins) {
        this.admins = admins;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "business", cascade = CascadeType.ALL)
//	@JsonManagedReference
    @JsonIgnore
    public Set<Product> getProducts() {
        return this.products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

}
