package by.trofimov.jdbc.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.trofimov.jdbc.entity.Ticket;
import by.trofimov.jdbc.exception.DaoException;

import static by.trofimov.jdbc.util.Constant.*;

public final class TicketDaoUtil {

    private TicketDaoUtil() {
    }

    public static List<Ticket> findAll() {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Ticket> tickets = new ArrayList<>();
            while (resultSet.next()) {
                tickets.add(buildTicket(resultSet));
            }
            return tickets;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public static Optional<Ticket> findById(Long id) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Ticket ticket = null;
            if (resultSet.next()) {
                ticket = buildTicket(resultSet);
            }
            return Optional.ofNullable(ticket);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private static Ticket buildTicket(ResultSet resultSet) throws SQLException {
        return new Ticket(
                resultSet.getLong(KEY_ID),
                resultSet.getString(KEY_PASSENGER_NO),
                resultSet.getString(KEY_PASSENGER_NAME),
                resultSet.getLong(KEY_FLIGHT_ID),
                resultSet.getString(KEY_SEAT_NO),
                resultSet.getBigDecimal(KEY_COST)
        );
    }

}
