package com.system.ticketmanagement.service;

import com.system.ticketmanagement.model.EventType;
import com.system.ticketmanagement.repository.EventTypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventTypeServiceImpl implements EventTypeService {

    @Autowired
    private EventTypeDAO eventTypeDAO;

    @Override
    public Optional<EventType> findEventTypeByName(String eventTypeName) {
        Optional<EventType> eventType = eventTypeDAO.findByName(eventTypeName);
        return eventType;
    }
}
