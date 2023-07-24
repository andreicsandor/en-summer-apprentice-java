package com.system.ticketmanagement.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="TicketCategory")
public class TicketCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_category_id")
    private Long id;

    @JoinColumn(name = "event_id", nullable = false)
    @ManyToOne
    private Event event;

    @Column(name = "ticket_category_description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    public TicketCategory() {
    }

    public TicketCategory(Event event, String description, BigDecimal price) {
        this.event = event;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getId() + ", " + getEvent() + ", " + getDescription() + ", " + getPrice();
    }
}
