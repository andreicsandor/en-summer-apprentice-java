package com.system.ticketmanagement.mapper;

import com.system.ticketmanagement.dto.TicketCategoryDTO;
import com.system.ticketmanagement.model.TicketCategory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TicketCategoryMapper {
    public TicketCategoryDTO convertDTO(TicketCategory ticketCategory) {
        TicketCategoryDTO ticketCategoryDTO = new TicketCategoryDTO();
        ticketCategoryDTO.setDescription(ticketCategory.getDescription());
        ticketCategoryDTO.setPrice(ticketCategory.getPrice());

        return ticketCategoryDTO;
    }

    public List<TicketCategoryDTO> convertDTOs(List<TicketCategory> ticketCategories) {
        List<TicketCategoryDTO> ticketCategoryDTOs = new ArrayList<>();

        for (TicketCategory ticketCategory : ticketCategories) {
            ticketCategoryDTOs.add(convertDTO(ticketCategory));
        }

        return ticketCategoryDTOs;
    }
}
