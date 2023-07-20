package com.system.ticketmanagement.mapper;

import com.system.ticketmanagement.dto.EventDTO;
import com.system.ticketmanagement.model.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventMapper {

    public EventDTO convertDTO(Event event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setName(event.getName());
        eventDTO.setEventType(event.getType().getName());
        eventDTO.setDescription(event.getDescription());
        eventDTO.setLocation(event.getVenue().getLocation());
        eventDTO.setLocationType(event.getVenue().getType());
        eventDTO.setStartDate(event.getStartDate());
        eventDTO.setEndDate(event.getEndDate());

        return eventDTO;
    }

    public List<EventDTO> convertDTOs(List<Event> events) {
        List<EventDTO> eventDTOs = new ArrayList<>();

        for (Event event : events) {
            eventDTOs.add(convertDTO(event));
        }

        return eventDTOs;
    }
}
