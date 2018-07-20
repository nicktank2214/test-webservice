package com.nicktank.microservice.repository;





import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.nicktank.microservice.domain.Package;





/**
 * Package Repository Interface
 */
//@RepositoryRestResource(collectionResourceRel = "package", path = "package")
@RepositoryRestResource(exported = false)
public interface PackageRepository 
extends PagingAndSortingRepository<Package,Integer> {
//extends CrudRepository<Package, Integer> {
	
	
	//standard find by id
	//<GET>http://localhost:8080/packages/{id}
		
	
	//standard find ALL
	//<GET>http://localhost:8080/packages
	


	
	//OVERRIDE THE STANDARD CRUD METHODS FOR DELETE ALL SO THAT THE API CANNOT ACCESS THESE ENDPOINTS------------->
	@Override
	@RestResource(exported=false) 
	void deleteAll();

	@Override
	@RestResource(exported=false) 
	void deleteAll(Iterable<? extends Package> arg0);

	@Override
	@RestResource(exported=false) 
	void deleteById(Integer arg0);
	//OVERRIDE THE STANDARD CRUD METHODS FOR SAVE/DELETE SO THAT THE API CANNOT ACCESS THESE ENDPOINTS-------------<

	
}
