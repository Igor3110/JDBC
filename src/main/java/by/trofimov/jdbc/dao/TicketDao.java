package by.trofimov.jdbc.dao;

import by.trofimov.jdbc.entity.Ticket;

public interface TicketDao {

   Ticket save(Ticket ticket);
   void update(Ticket ticket);
   boolean delete(Long id);

}
