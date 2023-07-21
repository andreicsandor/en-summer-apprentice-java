package com.system.ticketmanagement.repository;

import com.system.ticketmanagement.model.Event;
import com.system.ticketmanagement.model.TicketCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketCategoryDAO extends CrudRepository<Event, Long> {
    @Query("SELECT tc FROM TicketCategory tc WHERE tc.id = :id")
    Optional<TicketCategory> searchById(@Param("id") Long id);
}
