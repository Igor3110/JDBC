package by.trofimov.jdbc;

import java.math.BigDecimal;

import by.trofimov.jdbc.entity.Ticket;
import by.trofimov.jdbc.dao.TicketDao;
import by.trofimov.jdbc.dao.TicketDaoImpl;

public class DaoRunner {

    public static void main(String[] args) {
        deleteTest();
        saveTest();
    }

    private static void deleteTest() {
        TicketDao ticketDao = TicketDaoImpl.getInstance();
        boolean deleteResult = ticketDao.delete(23L);
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

}
