//package com.example.demo.entities;
//
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//import java.util.Date;
//
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
//import org.springframework.data.annotation.Id;
//
//@Document
//@JsonIgnoreProperties(value= {"User.lastActive"})
//public class Comment {
//	@Id
//	String Id;
//	String comment;
//	int user_id;
//	User user;
//	int post_id;
//	@Temporal(TemporalType.DATE)
//	Date posted_in=new Date();
//
//
//
//	public User getUsers() {
//		return user;
//	}
//	public void setUsers(User users) {
//		this.user = users;
//	}
//	public String getId() {
//		return Id;
//	}
//	public void setId(String id) {
//		Id = id;
//	}
//	public String getComment() {
//		return comment;
//	}
//	public void setComment(String comment) {
//		this.comment = comment;
//	}
//	public int getUser_id() {
//		return user_id;
//	}
//	public void setUser_id(int user_id) {
//		this.user_id = user_id;
//	}
//	public int getPost_id() {
//		return post_id;
//	}
//	public void setPost_id(int post_id) {
//		this.post_id = post_id;
//	}
//	public Date getPosted_in() {
//		return posted_in;
//	}
//	public void setPosted_in(Date posted_in) {
//		this.posted_in = new Date();
//	}
//
//
//
//}
