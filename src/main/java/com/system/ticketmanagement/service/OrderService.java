package com.system.ticketmanagement.service;

import com.system.ticketmanagement.dto.NewOrderDTO;
import com.system.ticketmanagement.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO createOrder(NewOrderDTO NewOrderDTO);
    List<OrderDTO> findOrdersByCustomer();
}
