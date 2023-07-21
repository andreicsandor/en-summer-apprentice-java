package com.system.ticketmanagement.controller;

import com.system.ticketmanagement.dto.OrderDTO;
import com.system.ticketmanagement.service.IOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class OrderController {
    private IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public List<OrderDTO> getOrders() {
        List<OrderDTO> orders = orderService.findOrdersByCustomer();

        if (orders.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No orders found");
        }

        return orders;
    }
}
