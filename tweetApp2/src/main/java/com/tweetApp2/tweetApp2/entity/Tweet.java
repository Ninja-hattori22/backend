package com.tweetApp2.tweetApp2.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tweet {
	@Id
	private long id;
	private String name;
	private String comment;
	public Tweet(long id, String name, String comment) {
		super();
		this.id = id;
		this.name = name;
		this.comment = comment;
	}
	public Tweet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "Tweet [id=" + id + ", name=" + name + ", comment=" + comment + "]";
	}
	
}
