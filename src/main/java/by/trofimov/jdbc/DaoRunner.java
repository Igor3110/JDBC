package by.trofimov.jdbc;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import by.trofimov.jdbc.entity.Ticket;
import by.trofimov.jdbc.dao.TicketDao;
import by.trofimov.jdbc.dao.TicketDaoImpl;

import by.trofimov.jdbc.util.TicketDaoUtil;

public class DaoRunner {

    public static void main(String[] args) {
        deleteTest(30L);
        saveTest();
        updateTest(2L, 208.11);
        findAllTest();
    }

    private static void deleteTest(Long id) {
        TicketDao ticketDao = TicketDaoImpl.getInstance();
        boolean deleteResult = ticketDao.delete(id);
        System.out.println(deleteResult);
    }

    private static void saveTest() {
        TicketDao ticketDao = TicketDaoImpl.getInstance();
        Ticket ticket = new Ticket();
        ticket.setPassengerNo("1234567");
        ticket.setPassengerName("Test");
        ticket.setFlightId(3L);
        ticket.setSeatNo("83");
        ticket.setCost(BigDecimal.TEN);
        Ticket savedTicket = ticketDao.save(ticket);
        System.out.println(savedTicket);
    }

    private static void updateTest(Long id, double value) {
        TicketDao ticketDao = TicketDaoImpl.getInstance();
        Optional<Ticket> maybeTicket = TicketDaoUtil.findById(id);
        System.out.println(maybeTicket);
        maybeTicket.ifPresent(ticket -> {
            ticket.setCost(BigDecimal.valueOf(value));
            ticketDao.update(ticket);
        });
    }

    private static void findAllTest() {
        List<Ticket> tickets = TicketDaoUtil.findAll();
        tickets.forEach(System.out::println);
    }

}
