package com.example.demo.entities;

// default package
// Generated Nov 23, 2017 7:42:03 PM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Business generated by hbm2java
 */
@Entity
@Table(name = "business", catalog = "businessin")
// to dynamic insert and update
@DynamicInsert
@DynamicUpdate
public class Business  {

	private Integer id;
	private String name;
	@Column(name = "password")
	private String password;
	private String logo;
	private String contact;
	@Column(name = "email", unique = true)
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

	public Business(String name, String password, String logo, String contact, String email, String address,
			String city, String state, String country, Integer postalCode, String url, String description, String notes,
			String paymentMethods, Integer active) {
		super();
		this.name = name;
		this.password = password;
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

	}

	public Business(Integer id, String name, String password, String logo, String contact, String email, String address,
			String city, String state, String country, Integer postalCode, String url, String description, String notes,
			String paymentMethods, Integer active, Set<Admin> admins, Set<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "business")
	@JsonManagedReference

	public Set<Admin> getAdmins() {
		return this.admins;
	}

	public void setAdmins(Set<Admin> admins) {
		this.admins = admins;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "business")
	@JsonManagedReference

	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
