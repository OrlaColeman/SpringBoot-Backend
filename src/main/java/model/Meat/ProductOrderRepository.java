package com.project.rest.webservice.Project.model.Meat;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "productOrder", path = "productOrder")
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long>{

	List<ProductOrder> findByOrderId(Long OrderId);
}
