package com.system.ticketmanagement.dto;

public class NewOrderDTO {
    private Long ticketCategoryId;
    private Integer numberOfTickets;

    public NewOrderDTO() {
    }

    public NewOrderDTO(String ticketCategoryId, Integer numberOfTickets) {
        this.ticketCategoryId = Long.parseLong(ticketCategoryId);
        this.numberOfTickets = numberOfTickets;
    }

    public Long getTicketCategoryId() {
        return ticketCategoryId;
    }

    public void setTicketCategoryId(Long ticketCategoryId) {
        this.ticketCategoryId = ticketCategoryId;
    }

    public Integer getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(Integer numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
}
