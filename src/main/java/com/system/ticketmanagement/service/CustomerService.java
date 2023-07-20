package com.system.ticketmanagement.service;

import com.system.ticketmanagement.model.Customer;
import com.system.ticketmanagement.repository.ICustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerDAO customerDAO;

    @Override
    public Customer findCustomerById(Long customerId) {
        Optional<Customer> customer = customerDAO.searchById(customerId);

        if (customer.isPresent()) {
            return customer.get();
        }

        return null;
    }
}
