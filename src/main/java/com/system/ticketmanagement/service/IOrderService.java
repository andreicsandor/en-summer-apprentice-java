package com.system.ticketmanagement.service;

import com.system.ticketmanagement.dto.OrderDTO;

import java.util.List;

public interface IOrderService {
    List<OrderDTO> findOrdersByCustomer();
}
