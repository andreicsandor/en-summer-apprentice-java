package com.system.ticketmanagement.controller;

import com.system.ticketmanagement.dto.NewOrderDTO;
import com.system.ticketmanagement.dto.OrderDTO;
import com.system.ticketmanagement.service.IOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No orders found");
        }

        return orders;
    }

    @PostMapping("/create-order")
    public ResponseEntity<?> createOrder(@RequestBody NewOrderDTO newOrderDTO) {
        // Convert DTO to Exhibit entity and call the service layer
        OrderDTO orderDTO = orderService.createOrder(newOrderDTO);

        // Return appropriate ResponseEntity based on success
        if (orderDTO != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(orderDTO);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Failed to create order.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
