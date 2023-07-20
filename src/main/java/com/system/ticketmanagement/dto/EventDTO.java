package com.system.ticketmanagement.dto;

import com.system.ticketmanagement.model.TicketCategory;

import java.util.Date;
import java.util.List;

public class EventDTO {
    private String name;
    private String eventType;
    private String description;
    private String location;
    private String locationType;
    private Date startDate;
    private Date endDate;
    private List<TicketCategoryDTO> ticketCategories;

    public EventDTO() {
    }

    public EventDTO(String name, String eventType, String description, String location, String locationType, Date startDate, Date endDate, List<TicketCategoryDTO> ticketCategories) {
        this.name = name;
        this.eventType = eventType;
        this.description = description;
        this.location = location;
        this.locationType = locationType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ticketCategories = ticketCategories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<TicketCategoryDTO> getTicketCategories() {
        return ticketCategories;
    }

    public void setTicketCategories(List<TicketCategoryDTO> ticketCategories) {
        this.ticketCategories = ticketCategories;
    }
}


