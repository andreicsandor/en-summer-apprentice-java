package com.system.ticketmanagement.dto;

import java.math.BigDecimal;

public class TicketCategoryDTO {
    private String description;
    private BigDecimal price;

    public TicketCategoryDTO() {
    }

    public TicketCategoryDTO(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
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
}
