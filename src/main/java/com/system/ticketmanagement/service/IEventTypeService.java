package com.system.ticketmanagement.service;

import com.system.ticketmanagement.model.EventType;

public interface IEventTypeService {
    EventType findEventTypeByName(String eventTypeName);
}
