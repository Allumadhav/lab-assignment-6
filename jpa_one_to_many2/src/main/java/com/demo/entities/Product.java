package com.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Cust_table")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cid;
	private  String name;
	private double phoneNumber;
	
	@JoinColumn(name="did_fk")
	@ManyToOne(cascade=CascadeType.ALL)
	private Review review;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(double phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Review getProduct() {
		return review;
	}

	public void setProduct(Review review) {
		this.review = review;
	}

	public Product() {}

	public Product(String name, double phoneNumber, Review review) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.review = review;
	}
	
	
	
}
