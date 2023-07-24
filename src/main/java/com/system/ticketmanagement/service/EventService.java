package com.system.ticketmanagement.service;

import com.system.ticketmanagement.dto.EventDTO;

import java.util.List;

public interface EventService {
    List<EventDTO> findEvents();
    List<EventDTO> findEventsByVenueAndType(Long venueId, String eventTypeName);
    List<EventDTO> findEventsByVenue(Long venueId);
    List<EventDTO> findEventsByType(String eventTypeName);
}
