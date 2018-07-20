package com.nicktank.microservice.repository;





import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.nicktank.microservice.domain.Product;



/**
 * Product Repository Interface
 */
//@RepositoryRestResource(collectionResourceRel = "product", path = "product")
@RepositoryRestResource(exported = false)
public interface ProductRepository 
extends PagingAndSortingRepository<Product,String> {

	
	
	//standard find by id
	//<GET>http://localhost:8080/products/{id}
		
	
	//standard find ALL
	//<GET>http://localhost:8080/products
	
		
	
	//OVERRIDE THE STANDARD CRUD METHODS FOR DELETE ALL SO THAT THE API CANNOT ACCESS THESE ENDPOINTS------------->
	@Override
	@RestResource(exported=false) 
	void deleteAll();

	@Override
	@RestResource(exported=false) 
	void deleteAll(Iterable<? extends Product> arg0);

	@Override
	@RestResource(exported=false) 
	void deleteById(String arg0);
	//OVERRIDE THE STANDARD CRUD METHODS FOR SAVE/DELETE SO THAT THE API CANNOT ACCESS THESE ENDPOINTS-------------<

	
}
