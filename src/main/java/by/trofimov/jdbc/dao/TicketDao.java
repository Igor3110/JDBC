package by.trofimov.jdbc.dao;

import by.trofimov.jdbc.dto.TicketFilter;
import by.trofimov.jdbc.entity.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketDao<K, E> {

   E save(E ticket);
   Optional<E> findById(K id);
   List<E> findAll();
   List<E> findByFilter(TicketFilter ticketFilter);
   void update(E ticket);
   boolean delete(K id);

}
