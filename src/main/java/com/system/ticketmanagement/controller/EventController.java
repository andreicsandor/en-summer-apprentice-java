package com.system.ticketmanagement.controller;

import com.system.ticketmanagement.model.Event;
import com.system.ticketmanagement.model.EventType;
import com.system.ticketmanagement.model.Venue;
import com.system.ticketmanagement.service.EventService;
import com.system.ticketmanagement.service.EventTypeService;
import com.system.ticketmanagement.service.VenueService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

    @RequestMapping("/api/events")
    public List<Event> getEvents(){
        return eventService.findEvents();
    }

    @GetMapping("/api/events?venueId={venueId}&eventType={eventTypeName}")
    public List<Event> getEventsByVenueIdAndType(@PathVariable Long venueId, @PathVariable String eventTypeName) {
        Optional<Venue> venueOptional = venueService.findVenueById(venueId);
        Optional<EventType> eventTypeOptional = eventTypeService.findEventTypeByName(eventTypeName);

        if (venueOptional.isPresent() && eventTypeOptional.isPresent()) {
            return eventService.findEventsByVenueAndType(venueOptional.get(), eventTypeOptional.get());
        } else if (venueOptional.isPresent() && !eventTypeOptional.isPresent()) {
            return eventService.findEventsByVenue(venueOptional.get());
        } else if (!venueOptional.isPresent() && eventTypeOptional.isPresent()) {
            return eventService.findEventsByType(eventTypeOptional.get());
        } else return Collections.emptyList();
    }
}


