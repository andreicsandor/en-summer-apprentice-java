package com.system.ticketmanagement.service;

import com.system.ticketmanagement.model.EventType;
import com.system.ticketmanagement.repository.IEventTypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventTypeService implements IEventTypeService {

    @Autowired
    private IEventTypeDAO eventTypeDAO;

    @Override
    public Optional<EventType> findEventTypeByName(String eventTypeName) {
        Optional<EventType> eventType = eventTypeDAO.findByName(eventTypeName);
        return eventType;
    }
}
