package com.system.ticketmanagement.controller;

import com.system.ticketmanagement.dto.EventDTO;
import com.system.ticketmanagement.service.EventService;
import com.system.ticketmanagement.service.EventTypeService;
import com.system.ticketmanagement.service.VenueService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class EventController {
    private EventService eventService;
    private EventTypeService eventTypeService;
    private VenueService venueService;

    public EventController(EventService eventService, EventTypeService eventTypeService, VenueService venueService) {
        this.eventService = eventService;
        this.eventTypeService = eventTypeService;
        this.venueService = venueService;
    }

    @GetMapping("/events")
    public List<EventDTO> getEvents(@RequestParam(value = "venueId", required = false) Long venueId,
                                    @RequestParam(value = "eventType", required = false) String eventTypeName) {
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

        return events;
    }
}


