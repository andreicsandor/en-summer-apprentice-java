package com.system.ticketmanagement.service;

import com.system.ticketmanagement.model.Customer;

public interface CustomerService {
    Customer findCustomerById(Long customerId);
}