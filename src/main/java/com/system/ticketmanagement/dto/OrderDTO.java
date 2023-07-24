package com.system.ticketmanagement.dto;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDTO {
    private String customerName;
    private String eventName;
    private String category;
    private Date orderedAt;
    private Integer numberOfTickets;
    private BigDecimal totalPrice;

    public OrderDTO() {
    }

    public OrderDTO(String customerName, String eventName, String category, Date orderedAt, Integer numberOfTickets, BigDecimal totalPrice) {
        this.customerName = customerName;
        this.category = category;
        this.orderedAt = orderedAt;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(Date orderedAt) {
        this.orderedAt = orderedAt;
    }

    public Integer getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(Integer numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
