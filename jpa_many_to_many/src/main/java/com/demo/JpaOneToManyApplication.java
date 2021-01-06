package com.demo;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.entities.Course;
import com.demo.entities.Student;
import com.demo.repo.CourseRepo;
import com.demo.repo.StudentRepo;

@SpringBootApplication
public class JpaOneToManyApplication implements CommandLineRunner {
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private CourseRepo courseRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaOneToManyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Student s1=new Student("student1",958461111);
		Student s2=new Student("student2",785614719);
		
		Student s3=new Student("student3",626584484);
		
		Student s4=new Student("student4",665874484);
		
		Course course1= new Course("java",LocalDate.of(2015, Month.AUGUST, 15));
		Course course2= new Course("python",LocalDate.of(2019, Month.NOVEMBER, 26));
		Course course3= new Course("Angular",LocalDate.of(2020, Month.OCTOBER, 11));
		
		course1.getStudents().add(s1);
		course1.getStudents().add(s2);
		
		course2.getStudents().add(s3);
		
		course3.getStudents().add(s4);
		
		s1.getCourses().add(course1);
		s2.getCourses().add(course1);
		s3.getCourses().add(course2);
		s4.getCourses().add(course3);
		
		courseRepo.save(course1);
		courseRepo.save(course2);
		courseRepo.save(course3);
		
		studentRepo.save(s1);
		studentRepo.save(s2);
		studentRepo.save(s3);
		studentRepo.save(s4);
		
		
	}

}
