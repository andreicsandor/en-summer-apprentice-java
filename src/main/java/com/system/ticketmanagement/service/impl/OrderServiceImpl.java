package com.system.ticketmanagement.service.impl;

import com.system.ticketmanagement.dto.NewOrderDTO;
import com.system.ticketmanagement.dto.OrderDTO;
import com.system.ticketmanagement.mapper.OrderMapper;
import com.system.ticketmanagement.model.Customer;
import com.system.ticketmanagement.model.Order;
import com.system.ticketmanagement.model.TicketCategory;
import com.system.ticketmanagement.repository.OrderDAO;
import com.system.ticketmanagement.service.CustomerService;
import com.system.ticketmanagement.service.OrderService;
import com.system.ticketmanagement.service.TicketCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private TicketCategoryService ticketCategoryService;
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public OrderDTO createOrder(NewOrderDTO newOrderDTO) {
        Customer customer = customerService.findCustomerById(1L);

        TicketCategory ticketCategory = ticketCategoryService.findTicketCategoryById(newOrderDTO.getTicketCategoryId());
        Integer numberOfTickets = newOrderDTO.getNumberOfTickets();

        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        Date date = new Date(timestamp.getTime());

        BigDecimal price = ticketCategoryService.findTicketCategoryById(newOrderDTO.getTicketCategoryId()).getPrice();
        BigDecimal totalPrice = price.multiply(BigDecimal.valueOf(numberOfTickets));

        Order order = new Order();
        order.setCustomer(customer);
        order.setTicketCategory(ticketCategory);
        order.setOrderedAt(date);
        order.setNumberOfTickets(numberOfTickets);
        order.setTotalPrice(totalPrice);

        order = orderDAO.save(order);

        if(order == null) {
            return null;
        }

        OrderDTO orderDTO = orderMapper.convertDTO(order);
        return orderDTO;
    }

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
