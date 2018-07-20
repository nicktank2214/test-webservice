package com.nicktank.microservice.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nicktank.microservice.domain.PackageProduct;
import java.util.List;


/**
 * Package Products Repository Interface
 * - NOT ALLOWED TO BE CALLED FROM REST
 * 
 */
//@RepositoryRestResource(collectionResourceRel = "packageproduct", path = "packageproduct")
//set to FALSE so that the Resource is not available for REST commands
@RepositoryRestResource(exported = false)
public interface PackageProductRepository extends CrudRepository<PackageProduct, Integer> {

    List<PackageProduct> findByPackageid(Integer id);

}