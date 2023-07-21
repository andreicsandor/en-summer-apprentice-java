package com.system.ticketmanagement.service;

import com.system.ticketmanagement.model.EventType;

public interface EventTypeService {
    EventType findEventTypeByName(String eventTypeName);
}
