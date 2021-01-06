package com.demo.entities;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product_table")
public class Review {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pid;
	
	private String pname;
	
	@OneToMany(mappedBy="review",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Product> products=new ArrayList<>();

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public List<Product> getCustomers() {
		return products;
	}

	public void setCustomers(List<Product> products) {
		this.products = products;
	}

	public Review() {}

	public Review(String pname) {
		this.pname = pname;
	}



}
