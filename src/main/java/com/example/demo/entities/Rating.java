//package com.example.demo.entities;
//
//
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import java.util.Date;
//
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
//import org.springframework.data.annotation.Id;
//
//@Document
//public class Rating {
//
//	@Id
//	private String id;
//	@Temporal(TemporalType.DATE)
//	private Date date ;
//	private int user_id ;
//	private int rate;
//	private int product_id  ;
//	private int business_id;
//
//	public Rating(Date date, int user_id, int rate, int product_id, int business_id) {
//		super();
//		this.date = date;
//		this.user_id = user_id;
//		this.rate = rate;
//		this.product_id = product_id;
//		this.business_id = business_id;
//	}
//
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	public Date getDate() {
//		return date;
//	}
//
//	public void setDate(Date date) {
//		this.date = date;
//	}
//
//	public int getUser_id() {
//		return user_id;
//	}
//
//	public void setUser_id(int user_id) {
//		this.user_id = user_id;
//	}
//
//	public int getRate() {
//		return rate;
//	}
//
//	public void setRate(int rate) {
//		this.rate = rate;
//	}
//
//	public int getProduct_id() {
//		return product_id;
//	}
//
//	public void setProduct_id(int product_id) {
//		this.product_id = product_id;
//	}
//
//	public int getBusiness_id() {
//		return business_id;
//	}
//
//	public void setBusiness_id(int business_id) {
//		this.business_id = business_id;
//	}
//
//
//
//
//
//
//}
