package com.system.ticketmanagement.service.impl;

import com.system.ticketmanagement.model.EventType;
import com.system.ticketmanagement.repository.EventTypeDAO;
import com.system.ticketmanagement.service.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventTypeServiceImpl implements EventTypeService {

    @Autowired
    private EventTypeDAO eventTypeDAO;

    @Override
    public EventType findEventTypeByName(String eventTypeName) {
        Optional<EventType> eventType = eventTypeDAO.searchByName(eventTypeName);

        if (eventType.isPresent()) {
            return eventType.get();
        }

        return null;
    }
}
