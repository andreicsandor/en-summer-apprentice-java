package com.system.ticketmanagement.repository;

import com.system.ticketmanagement.model.Event;
import com.system.ticketmanagement.model.EventType;
import com.system.ticketmanagement.model.Venue;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEventDAO extends CrudRepository<Event, Long> {
    List<Event> findAll();
    List<Event> searchByVenueAndType(Venue venue, EventType eventType);
    List<Event> searchByVenue(Venue venue);
    List<Event> searchByType(EventType eventType);
}
