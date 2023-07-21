package com.system.ticketmanagement.dto;

public class NewOrderDTO {
    private Long eventId;
    private Long ticketCategoryId;
    private Integer numberOfTickets;

    public NewOrderDTO() {
    }

    public NewOrderDTO(String eventId, String ticketCategoryId, Integer numberOfTickets) {
        this.eventId = Long.parseLong(eventId);
        this.ticketCategoryId = Long.parseLong(ticketCategoryId);
        this.numberOfTickets = numberOfTickets;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
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
