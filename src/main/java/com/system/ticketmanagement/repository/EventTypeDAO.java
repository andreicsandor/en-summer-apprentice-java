package com.system.ticketmanagement.repository;

import com.system.ticketmanagement.model.EventType;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EventTypeDAO extends CrudRepository<EventType, Long> {
    Optional<EventType> findByName(String name);
}