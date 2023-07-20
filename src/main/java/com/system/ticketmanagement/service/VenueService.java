package com.system.ticketmanagement.service;

import com.system.ticketmanagement.model.Venue;

import java.util.Optional;

public interface VenueService {
    Optional<Venue> findVenueById(Long venueId);
}
