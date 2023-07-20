package com.system.ticketmanagement.service;

import com.system.ticketmanagement.model.Venue;

public interface IVenueService {
    Venue findVenueById(Long venueId);
}
