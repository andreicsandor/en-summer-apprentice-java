package com.system.ticketmanagement.service;

import com.system.ticketmanagement.dto.OrderDTO;
import com.system.ticketmanagement.mapper.OrderMapper;
import com.system.ticketmanagement.model.Customer;
import com.system.ticketmanagement.model.Order;
import com.system.ticketmanagement.repository.IOrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderDAO orderDAO;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<OrderDTO> findOrdersByCustomer() {
        // Hardcode Customer ID
        Long customerId = 1L;
        Customer customer = customerService.findCustomerById(customerId);

        if (customer != null) {
            List<Order> orders = orderDAO.searchByCustomer(customer);
            return orderMapper.convertDTOs(orders);
        }

        return Collections.EMPTY_LIST;
    }
}
