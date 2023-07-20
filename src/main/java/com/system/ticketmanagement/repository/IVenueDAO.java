package com.system.ticketmanagement.repository;

import com.system.ticketmanagement.model.Venue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IVenueDAO extends CrudRepository<Venue, Long> {
    Optional<Venue> searchById(Long id);
}
