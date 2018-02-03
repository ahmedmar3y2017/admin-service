//package com.example.demo.entities;
//
//import java.util.Date;
//
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//@Document
//public class Chat {
//
//
//
//	@Id
//	private String id;
//	private int from_id;
//	private int to_id;
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date date;
//
//	private String message;
//
//	public Chat(int from_id, int to_id, Date date, String message) {
//		super();
//		this.from_id = from_id;
//		this.to_id = to_id;
//		this.date = date;
//		this.message = message;
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
//	public int getFrom_id() {
//		return from_id;
//	}
//
//	public void setFrom_id(int from_id) {
//		this.from_id = from_id;
//	}
//
//	public int getTo_id() {
//		return to_id;
//	}
//
//	public void setTo_id(int to_id) {
//		this.to_id = to_id;
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
//	public String getMessage() {
//		return message;
//	}
//
//	public void setMessage(String message) {
//		this.message = message;
//	}
//
//
//
//}
