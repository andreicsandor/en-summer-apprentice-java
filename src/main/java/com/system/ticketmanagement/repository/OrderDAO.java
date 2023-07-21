package com.system.ticketmanagement.repository;

import com.system.ticketmanagement.model.Customer;
import com.system.ticketmanagement.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDAO extends CrudRepository<Order, Long> {
    List<Order> searchByCustomer(Customer customer);
}
