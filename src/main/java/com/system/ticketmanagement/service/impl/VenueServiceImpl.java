package com.system.ticketmanagement.service.impl;

import com.system.ticketmanagement.model.Venue;
import com.system.ticketmanagement.repository.VenueDAO;
import com.system.ticketmanagement.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VenueServiceImpl implements VenueService {

    @Autowired
    private VenueDAO venueDAO;

    @Override
    public Venue findVenueById(Long venueId) {
        Optional<Venue> venue = venueDAO.searchById(venueId);

        if (venue.isPresent()) {
            return venue.get();
        }

        return null;
    }
}