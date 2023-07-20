package com.system.ticketmanagement.mapper;

import com.system.ticketmanagement.dto.OrderDTO;
import com.system.ticketmanagement.model.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {

    public OrderDTO convertDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setCustomerName(order.getCustomer().getName());
        orderDTO.setEventName(order.getTicketCategory().getEvent().getName());
        orderDTO.setCategory(order.getTicketCategory().getDescription());
        orderDTO.setOrderedAt(order.getOrderedAt());
        orderDTO.setNumberOfTickets(order.getNumberOfTickets());
        orderDTO.setTotalPrice(order.getTotalPrice());

        return orderDTO;
    }

    public List<OrderDTO> convertDTOs(List<Order> orders) {
        List<OrderDTO> orderDTOs = new ArrayList<>();

        for (Order order : orders) {
            orderDTOs.add(convertDTO(order));
        }

        return orderDTOs;
    }
}
