package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.entities.Product;
import com.demo.entities.Review;
import com.demo.repo.ProductRepo;
import com.demo.repo.ReviewRepo;

@SpringBootApplication
public class JpaOneToManyApplication implements CommandLineRunner {
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private ReviewRepo reviewRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaOneToManyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Review product1 =new Review("mobile");
		Review product2 =new Review("laptop");
		Review product3 =new Review("PC");
		
		Product cust1=new Product("customer1",958461111,product1);
		Product cust2=new Product("customer2",785614719,product1);
		
		Product cust3=new Product("customer3",626584484,product2);
		
		Product cust4=new Product("customer4",665874484,product3);
		
		product1.getCustomers().add(cust1);
		product1.getCustomers().add(cust2);
		
		product2.getCustomers().add(cust3);
		
		product3.getCustomers().add(cust4);
		
		reviewRepo.save(product1);
		reviewRepo.save(product2);
		reviewRepo.save(product3);
		
		productRepo.save(cust1);
		productRepo.save(cust2);
		productRepo.save(cust3);
		productRepo.save(cust4);
		
		
	}

}
