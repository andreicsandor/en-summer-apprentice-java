package com.system.ticketmanagement.service;

import com.system.ticketmanagement.model.EventType;

import java.util.Optional;

public interface EventTypeService {
    Optional<EventType> findEventTypeByName(String eventTypeName);
}
