package com.system.ticketmanagement.service;

import com.system.ticketmanagement.dto.EventDTO;
import com.system.ticketmanagement.mapper.EventMapper;
import com.system.ticketmanagement.model.Event;
import com.system.ticketmanagement.model.EventType;
import com.system.ticketmanagement.model.Venue;
import com.system.ticketmanagement.repository.IEventDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EventService implements IEventService {

    @Autowired
    private IEventDAO eventDAO;
    @Autowired
    private IVenueService venueService;
    @Autowired
    private IEventTypeService eventTypeService;
    @Autowired
    private EventMapper eventMapper;

    @Override
    public List<EventDTO> findEvents() {
        List<Event> events = eventDAO.findAll();
        return eventMapper.convertDTOs(events);
    }

    @Override
    public List<EventDTO> findEventsByVenueAndType(Long venueId, String eventTypeName) {
        Venue venue = venueService.findVenueById(venueId);
        EventType eventType = eventTypeService.findEventTypeByName(eventTypeName);

        if (venue != null && eventType != null) {
            List<Event> events = eventDAO.searchByVenueAndType(venue, eventType);
            return eventMapper.convertDTOs(events);
        } else {
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    public List<EventDTO> findEventsByVenue(Long venueId) {
        Venue venue = venueService.findVenueById(venueId);

        if (venue != null) {
            List<Event> events = eventDAO.searchByVenue(venue);
            return eventMapper.convertDTOs(events);
        } else {
            return Collections.EMPTY_LIST;
        }
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
