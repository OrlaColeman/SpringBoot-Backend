package com.project.rest.webservice.Project.model.Meat;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "product", path = "product")
public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<Product> findByName(String name);
	Optional<Product> findById(Long id);
	List<Product> findByCompanyID(Long companyID);
	
	Optional<Product> findByCost(Long cost);
	
}
