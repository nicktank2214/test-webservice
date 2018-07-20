package com.nicktank.microservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nicktank.microservice.domain.PackageProduct;
import com.nicktank.microservice.domain.Product;
import com.nicktank.microservice.repository.PackageRepository;
import com.nicktank.microservice.repository.ProductRepository;
import com.nicktank.microservice.service.PackageService;
import com.nicktank.microservice.service.ProductService;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;



@SpringBootApplication
public class MicroserviceApplication implements CommandLineRunner {

	@Autowired
	PackageService packageService;

    @Autowired
    PackageRepository packageRepository;
    
	@Autowired
	ProductService productService;
	
    @Autowired
    ProductRepository productRepository;
    

	public static void main(String[] args) {		
		SpringApplication.run(MicroserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		
/*		//TEST CREATE PRODUCTS-------------------------------------------------------------------------------------->
        // save a couple of categories
		//Product(String id, String name, BigDecimal usdprice)
        Product productA = new Product("XXXYYYZZZ", "Test Product A", new BigDecimal(99889.00));
        productRepository.save(productA);
        
        
        
        //WORKS FOR UPDATE
        com.nicktank.microservice.domain.Package packageA = 
        		new com.nicktank.microservice.domain.Package(2, "Package A", "Package A", new BigDecimal(99999.00));        
       packageRepository.save(packageA); 

       //WORKS FOR CREATE (no ID specified)
       com.nicktank.microservice.domain.Package packageB = 
       		new com.nicktank.microservice.domain.Package(4,"Package B", "Package B", new BigDecimal(7777.00));        
       Optional<Product> product= productRepository.findById("7dgX6XzU3Wds");
       //Product(String id, String name, BigDecimal usdprice)
       Set ppBs = new HashSet<PackageProduct>(){{  
           add( new PackageProduct( packageB.getId(), product ));
           add( new PackageProduct( packageB.getId(), new Product("XXX","XXX",new BigDecimal(88.99)) ));
       }};
       packageB.setPackageProducts(ppBs);
       packageRepository.save(packageB); 
      
        */
        
		
		
		

		//TESTING PACKAGE SERVICES WORK----------------------------------------------------------------------------->	
		Iterable<com.nicktank.microservice.domain.Package> packages = packageService.findAllPackages();

		packages.forEach(_package -> {
			System.out.println("package - "
					+_package.getClass()+" toString: "+_package.toString()
					+" size: "+_package.getPackageProducts().size()
					+":\n"
					);
			_package.getPackageProducts().forEach(System.out::println);
			System.out.println();
		});
		//TESTING PACKAGE SERVICES WORK----------------------------------------------------------------------------->

		
		//TESTING PRODUCT SERVICES WORK----------------------------------------------------------------------------->	
		Iterable<com.nicktank.microservice.domain.Product> products = productService.findAllProducts();

		products.forEach(_product -> {
			System.out.println("product - "
			+_product.toString()
					+":\n"
					);
			System.out.println();
		});
		//TESTING PRODUCT SERVICES WORK----------------------------------------------------------------------------->
		
		

		LocalTime currentTime = new LocalTime();
		LocalDate currentDate = new LocalDate();			
		System.out.println("MicroserviceApplication - current local time is: " + currentDate+"T"+currentTime);


	}

}