package org.droame.autonomous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.droame.autonomous.model.Customer;


@Repository

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
}