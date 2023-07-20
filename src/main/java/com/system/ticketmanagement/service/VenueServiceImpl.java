package com.system.ticketmanagement.service;

import com.system.ticketmanagement.model.Venue;
import com.system.ticketmanagement.repository.VenueDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VenueServiceImpl implements VenueService {

    @Autowired
    private VenueDAO venueDAO;

    @Override
    public Optional<Venue> findVenueById(Long venueId) {
        Optional<Venue> venue = venueDAO.findById(venueId);
        return venue;
    }
}