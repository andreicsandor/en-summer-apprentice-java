package com.system.ticketmanagement.service;

import com.system.ticketmanagement.model.Customer;

public interface ICustomerService {
    Customer findCustomerById(Long customerId);
}