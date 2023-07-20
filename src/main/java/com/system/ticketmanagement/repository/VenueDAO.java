package com.system.ticketmanagement.repository;

import com.system.ticketmanagement.model.Venue;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VenueDAO extends CrudRepository<Venue, Long> {
    Optional<Venue> findById(Long id);
}
