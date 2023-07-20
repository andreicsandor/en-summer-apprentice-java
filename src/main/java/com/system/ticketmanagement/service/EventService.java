package com.system.ticketmanagement.service;

import com.system.ticketmanagement.model.Event;
import com.system.ticketmanagement.model.EventType;
import com.system.ticketmanagement.model.Venue;
import com.system.ticketmanagement.repository.IEventDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService implements IEventService {

    @Autowired
    private IEventDAO eventDAO;

    @Override
    public List<Event> findEvents() {
        List<Event> events = eventDAO.findAll();
        return events;
    }

    @Override
    public List<Event> findEventsByVenueAndType(Venue venue, EventType eventType) {
        List<Event> events = eventDAO.searchByVenueAndType(venue, eventType);
        return events;
    }

    @Override
    public List<Event> findEventsByVenue(Venue venue) {
        List<Event> events = eventDAO.searchByVenue(venue);
        return events;
    }

    @Override
    public List<Event> findEventsByType(EventType eventType) {
        List<Event> events = eventDAO.searchByType(eventType);
        return events;
    }
}
