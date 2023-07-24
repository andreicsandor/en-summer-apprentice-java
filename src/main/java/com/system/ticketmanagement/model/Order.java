package com.system.ticketmanagement.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @JoinColumn(name = "customer_id", nullable = false)
    @ManyToOne
    private Customer customer;

    @JoinColumn(name = "ticket_category_id", nullable = false)
    @ManyToOne
    private TicketCategory category;

    @Column(name = "ordered_at", nullable = false)
    private Date orderedAt;

    @Column(name = "number_of_tickets", nullable = false)
    private Integer numberOfTickets;

    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

    public Order() {
    }

    public Order(Customer customer, TicketCategory category, Date orderedAt, Integer numberOfTickets, BigDecimal totalPrice) {
        this.customer = customer;
        this.category = category;
        this.orderedAt = orderedAt;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public TicketCategory getTicketCategory() {
        return category;
    }

    public void setTicketCategory(TicketCategory category) {
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

    @Override
    public String toString() {
        return getId() + ", " + getCustomer() + ", " + getTicketCategory() + ", " + getNumberOfTickets() + ", " + getOrderedAt() + ", " + getTotalPrice();
    }
}
