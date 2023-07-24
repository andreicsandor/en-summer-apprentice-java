package com.system.ticketmanagement.service;

import com.system.ticketmanagement.model.TicketCategory;

public interface TicketCategoryService {
    TicketCategory findTicketCategoryById(Long ticketCategoryId);
}
