package com.system.ticketmanagement.repository;

import com.system.ticketmanagement.model.Event;
import com.system.ticketmanagement.model.EventType;
import com.system.ticketmanagement.model.Venue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventDAO extends CrudRepository<Event, Long> {
    List<Event> findAll();
    @Query("SELECT e FROM Event e WHERE e.venue.id = :venueId AND e.type.name = :typeName")
    List<Event> searchByVenueAndType(@Param("venueId") Long venueId, @Param("typeName") String typeName);
    List<Event> searchByVenue(Venue venue);
    List<Event> searchByType(EventType eventType);
}
