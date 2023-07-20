package com.system.ticketmanagement.service;

import com.system.ticketmanagement.model.Event;
import com.system.ticketmanagement.model.EventType;
import com.system.ticketmanagement.model.Venue;

import java.util.List;

public interface EventService {
    List<Event> findEvents();
    List<Event> findEventsByVenueAndType(Venue venue, EventType eventType);
    List<Event> findEventsByVenue(Venue venue);
    List<Event> findEventsByType(EventType eventType);
}
