package com.system.ticketmanagement.service.impl;

import com.system.ticketmanagement.model.TicketCategory;
import com.system.ticketmanagement.repository.TicketCategoryDAO;
import com.system.ticketmanagement.service.TicketCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketCategoryServiceImpl implements TicketCategoryService {

    @Autowired
    private TicketCategoryDAO ticketCategoryDAO;

    @Override
    public TicketCategory findTicketCategoryById(Long ticketCategoryId) {
        Optional<TicketCategory> ticketCategory = ticketCategoryDAO.searchById(ticketCategoryId);

        if (ticketCategory.isPresent()) {
            return ticketCategory.get();
        }

        return null;
    }
}
