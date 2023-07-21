package com.system.ticketmanagement.service;

import com.system.ticketmanagement.model.TicketCategory;
import com.system.ticketmanagement.repository.ITicketCategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketCategoryService implements ITicketCategoryService {

    @Autowired
    private ITicketCategoryDAO ticketCategoryDAO;

    @Override
    public TicketCategory findTicketCategoryById(Long ticketCategoryId) {
        Optional<TicketCategory> ticketCategory = ticketCategoryDAO.searchById(ticketCategoryId);

        if (ticketCategory.isPresent()) {
            return ticketCategory.get();
        }

        return null;
    }
}
