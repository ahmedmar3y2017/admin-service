package com.example.demo.entities;

// default package
// Generated Nov 23, 2017 7:42:03 PM by Hibernate Tools 5.2.3.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

/**
 * Admin generated by hbm2java
 */
@Entity
@Table(name = "admin", catalog = "businessin")
// to dynamic insert and update
@DynamicInsert
@DynamicUpdate

public class Admin implements java.io.Serializable {

	private Integer id;
	private Business business;
	private String adminLevel;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Integer active;
	private Integer phone;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String country;
	private Integer postalCode;
	private Date lastActive;
	private Date registerDate;

	public Admin() {
	}

	public Admin(Integer id, Business business, String adminLevel, String firstName, String lastName, String email,
			String password, Integer active, Integer phone, String address1, String address2, String city, String state,
			String country, Integer postalCode, Date lastActive, Date registerDate) {
		super();
		this.id = id;
		this.business = business;
		this.adminLevel = adminLevel;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.active = active;
		this.phone = phone;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.lastActive = lastActive;
		this.registerDate = registerDate;
	}

	public Admin(Business business, String adminLevel, String firstName, String lastName, String email, String password,
			Integer active, Integer phone, String address1, String address2, String city, String state, String country,
			Integer postalCode, Date lastActive, Date registerDate) {
		super();
		this.business = business;
		this.adminLevel = adminLevel;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.active = active;
		this.phone = phone;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.lastActive = lastActive;
		this.registerDate = registerDate;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "businessid", nullable = false)
	public Business getBusiness() {
		return this.business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	@Column(name = "adminLevel")
	public String getAdminLevel() {
		return this.adminLevel;
	}

	public void setAdminLevel(String adminLevel) {
		this.adminLevel = adminLevel;
	}

	@Column(name = "firstName")
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastName")
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "email", unique = true, nullable = false)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "active", length = 1)
	public Integer getActive() {
		return this.active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	@Column(name = "phone", unique = true)
	public Integer getPhone() {
		return this.phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	@Column(name = "address1")
	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name = "address2")
	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "lastActive", length = 0)
	public Date getLastActive() {
		return this.lastActive;
	}

	public void setLastActive(Date lastActive) {
		this.lastActive = lastActive;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "registerDate", length = 0)
	public Date getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

}
