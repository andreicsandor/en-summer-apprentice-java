package com.system.ticketmanagement.service.impl;

import com.system.ticketmanagement.model.Customer;
import com.system.ticketmanagement.repository.CustomerDAO;
import com.system.ticketmanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public Customer findCustomerById(Long customerId) {
        Optional<Customer> customer = customerDAO.searchById(customerId);

        if (customer.isPresent()) {
            return customer.get();
        }

        return null;
    }
}
