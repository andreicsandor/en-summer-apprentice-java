package com.system.ticketmanagement.service;

import com.system.ticketmanagement.model.Venue;

public interface VenueService {
    Venue findVenueById(Long venueId);
}
