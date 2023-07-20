package com.system.ticketmanagement.service;

import com.system.ticketmanagement.model.EventType;
import com.system.ticketmanagement.model.Venue;
import com.system.ticketmanagement.repository.IVenueDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VenueService implements IVenueService {

    @Autowired
    private IVenueDAO venueDAO;

    @Override
    public Venue findVenueById(Long venueId) {
        Optional<Venue> venue = venueDAO.searchById(venueId);

        if (venue.isPresent()) {
            return venue.get();
        }

        return null;
    }
}