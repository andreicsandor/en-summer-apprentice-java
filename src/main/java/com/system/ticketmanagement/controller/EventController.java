package com.system.ticketmanagement.controller;

import com.system.ticketmanagement.dto.EventDTO;
import com.system.ticketmanagement.service.IEventService;
import com.system.ticketmanagement.service.IEventTypeService;
import com.system.ticketmanagement.service.IVenueService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

@RestController
public class EventController {
    private IEventService eventService;
    private IEventTypeService eventTypeService;
    private IVenueService venueService;

    public EventController(IEventService eventService, IEventTypeService eventTypeService, IVenueService venueService) {
        this.eventService = eventService;
        this.eventTypeService = eventTypeService;
        this.venueService = venueService;
    }

    @GetMapping("/events")
    public List<EventDTO> getEvents(@RequestParam(value = "venueId", required = false) Long venueId,
                                    @RequestParam(value = "eventTypeName", required = false) String eventTypeName) {
        List<EventDTO> events;

        if (venueId == null && eventTypeName == null) {
            events = eventService.findEvents();
        } else if (venueId != null && eventTypeName == null) {
            events = eventService.findEventsByVenue(venueId);
        } else if (venueId == null && eventTypeName != null) {
            events = eventService.findEventsByType(eventTypeName);
        } else if (venueId != null && eventTypeName != null) {
            events = eventService.findEventsByVenueAndType(venueId, eventTypeName);
        } else {
            events = Collections.emptyList();
        }

        if (events.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No events found");
        }

        return events;
    }
}


