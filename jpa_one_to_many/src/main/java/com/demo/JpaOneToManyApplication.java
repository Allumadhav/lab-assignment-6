package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.entities.Customer;
import com.demo.entities.Product;
import com.demo.repo.CustomerRepo;
import com.demo.repo.ProductRepo;

@SpringBootApplication
public class JpaOneToManyApplication implements CommandLineRunner {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaOneToManyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Product product1 =new Product("mobile");
		Product product2 =new Product("laptop");
		Product product3 =new Product("PC");
		
		Customer cust1=new Customer("customer1",958461111,product1);
		Customer cust2=new Customer("customer2",785614719,product1);
		
		Customer cust3=new Customer("customer3",626584484,product2);
		
		Customer cust4=new Customer("customer4",665874484,product3);
		
		product1.getCustomers().add(cust1);
		product1.getCustomers().add(cust2);
		
		product2.getCustomers().add(cust3);
		
		product3.getCustomers().add(cust4);
		
		productRepo.save(product1);
		productRepo.save(product2);
		productRepo.save(product3);
		
		customerRepo.save(cust1);
		customerRepo.save(cust2);
		customerRepo.save(cust3);
		customerRepo.save(cust4);
		
		
	}

}
