package com.system.ticketmanagement.service.impl;

import com.system.ticketmanagement.dto.EventDTO;
import com.system.ticketmanagement.mapper.EventMapper;
import com.system.ticketmanagement.model.Event;
import com.system.ticketmanagement.model.EventType;
import com.system.ticketmanagement.model.Venue;
import com.system.ticketmanagement.repository.EventDAO;
import com.system.ticketmanagement.service.EventService;
import com.system.ticketmanagement.service.EventTypeService;
import com.system.ticketmanagement.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDAO eventDAO;
    @Autowired
    private VenueService venueService;
    @Autowired
    private EventTypeService eventTypeService;
    @Autowired
    private EventMapper eventMapper;

    @Override
    public List<EventDTO> findEvents() {
        List<Event> events = eventDAO.findAll();
        return eventMapper.convertDTOs(events);
    }

    @Override
    public List<EventDTO> findEventsByVenueAndType(Long venueId, String eventTypeName) {
        List<Event> events = eventDAO.searchByVenueAndType(venueId, eventTypeName);

        if (!events.isEmpty()) {
            return eventMapper.convertDTOs(events);
        }

        return Collections.EMPTY_LIST;
    }

    @Override
    public List<EventDTO> findEventsByVenue(Long venueId) {
        Venue venue = venueService.findVenueById(venueId);

        if (venue != null) {
            List<Event> events = eventDAO.searchByVenue(venue);
            return eventMapper.convertDTOs(events);
        }

        return Collections.EMPTY_LIST;
    }

    @Override
    public List<EventDTO> findEventsByType(String eventTypeName) {
        EventType eventType = eventTypeService.findEventTypeByName(eventTypeName);

        if (eventType != null) {
            List<Event> events = eventDAO.searchByType(eventType);
            return eventMapper.convertDTOs(events);
        }

        return Collections.EMPTY_LIST;
    }
}
