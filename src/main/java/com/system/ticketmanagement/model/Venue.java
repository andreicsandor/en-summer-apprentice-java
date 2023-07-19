package com.system.ticketmanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name="Venue")
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "venue_id")
    private Long id;

    @Column(name = "venue_location", nullable = false)
    private String location;

    @Column(name = "venue_type", nullable = false)
    private String type;

    @Column(name = "venue_capacity", nullable = false)
    private Integer capacity;

    public Venue() {
    }

    public Venue(String location, String type, Integer capacity) {
        this.location = location;
        this.type = type;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return getId() + ", " + getType() + ", " + getCapacity() + ", " + getLocation();
    }
}

