package com.system.ticketmanagement.service;

import com.system.ticketmanagement.model.TicketCategory;

public interface ITicketCategoryService {
    TicketCategory findTicketCategoryById(Long ticketCategoryId);
}
