package com.system.ticketmanagement.controller;

import com.system.ticketmanagement.dto.EventDTO;
import com.system.ticketmanagement.mapper.EventMapper;
import com.system.ticketmanagement.model.EventType;
import com.system.ticketmanagement.model.Venue;
import com.system.ticketmanagement.service.IEventService;
import com.system.ticketmanagement.service.IEventTypeService;
import com.system.ticketmanagement.service.IVenueService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/api/events")
    public List<EventDTO> getEvents(@RequestParam(value = "venueId", required = false) Long venueId,
                                    @RequestParam(value = "eventTypeName", required = false) String eventTypeName) {

        EventMapper eventMapper = new EventMapper();

        if (venueId == null && eventTypeName == null) {
            return eventMapper.convertDTOs(eventService.findEvents());
        }

        Optional<Venue> venueOptional = Optional.empty();
        Optional<EventType> eventTypeOptional = Optional.empty();

        if (venueId != null) {
            venueOptional = venueService.findVenueById(venueId);
        }

        if (eventTypeName != null) {
            eventTypeOptional = eventTypeService.findEventTypeByName(eventTypeName);
        }

        if (venueOptional.isPresent() && eventTypeOptional.isPresent()) {
            return eventMapper.convertDTOs(eventService.findEventsByVenueAndType(venueOptional.get(), eventTypeOptional.get()));
        } else if (venueOptional.isPresent()) {
            return eventMapper.convertDTOs(eventService.findEventsByVenue(venueOptional.get()));
        } else if (eventTypeOptional.isPresent()) {
            return eventMapper.convertDTOs(eventService.findEventsByType(eventTypeOptional.get()));
        }

        return Collections.emptyList();
    }
}


