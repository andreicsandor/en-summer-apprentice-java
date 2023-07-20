package com.system.ticketmanagement.repository;

import com.system.ticketmanagement.model.EventType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEventTypeDAO extends CrudRepository<EventType, Long> {
    Optional<EventType> searchByName(String name);
}