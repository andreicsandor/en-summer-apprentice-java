package com.system.ticketmanagement.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="Event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long id;

    @JoinColumn(name = "venue_id", nullable = false)
    @ManyToOne
    private Venue venue;

    @JoinColumn(name = "event_type_id", nullable = false)
    @ManyToOne
    private EventType type;

    @Column(name = "event_description", nullable = false)
    private String description;

    @Column(name = "event_name", nullable = false)
    private String name;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER)
    private List<TicketCategory> ticketCategories;

    public Event() {
    }

    public Event(Venue venue, EventType type, String description, String name, Date startDate, Date endDate) {
        this.venue = venue;
        this.type = type;
        this.description = description;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<TicketCategory> getTicketCategories() {
        return ticketCategories;
    }

    public void setTicketCategories(List<TicketCategory> ticketCategories) {
        this.ticketCategories = ticketCategories;
    }

    @Override
    public String toString() {
        return getId() + ", " + getName() + ", " + getVenue() + ", " + getDescription() + ", " + getStartDate() + " — " + getEndDate();
    }
}

