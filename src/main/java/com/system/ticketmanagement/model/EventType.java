package com.system.ticketmanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name="EventType")
public class EventType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_type_id")
    private Long id;

    @Column(name = "event_type_name", nullable = false)
    private String name;

    public EventType() {
    }

    public EventType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getId() + ", " + getName();
    }
}
