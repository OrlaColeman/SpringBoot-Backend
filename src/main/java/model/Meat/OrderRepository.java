package com.project.rest.webservice.Project.model.Meat;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.project.rest.webservice.Project.model.User;

@RepositoryRestResource(collectionResourceRel = "order", path = "order")
public interface OrderRepository extends JpaRepository<Order, Long>{

	//Optional<Order> findByUserID(Long userID);
	List<Order> findByUserID(Long userID);
}
