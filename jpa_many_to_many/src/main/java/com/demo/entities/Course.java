package com.demo.entities;

import java.time.LocalDate;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="course_table")
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cid;
	private  String cname;
	private LocalDate startDate;
	
	@JoinTable(name="student_course_table",joinColumns=@JoinColumn(name="cid_fk"), inverseJoinColumns=@JoinColumn(name="sid_fk"))
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Student> students=new ArrayList<>();

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Course() {}

	public Course(String cname, LocalDate startDate) {
		this.cname = cname;
		this.startDate = startDate;
	}
	
}
