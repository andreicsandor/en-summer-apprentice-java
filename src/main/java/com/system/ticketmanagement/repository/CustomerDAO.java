package com.system.ticketmanagement.repository;

import com.system.ticketmanagement.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerDAO extends CrudRepository<Customer, Long> {
    Optional<Customer> searchById(Long id);
}
