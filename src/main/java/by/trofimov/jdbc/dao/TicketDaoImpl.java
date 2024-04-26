package by.trofimov.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.trofimov.jdbc.entity.Ticket;
import by.trofimov.jdbc.exception.DaoException;
import by.trofimov.jdbc.util.ConnectionManager;

import static by.trofimov.jdbc.util.Constant.*;

public class TicketDaoImpl implements TicketDao {

    private static final TicketDao INSTANCE = new TicketDaoImpl();

    private TicketDaoImpl() {
    }

    @Override
    public Ticket save(Ticket ticket) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, ticket.getPassengerNo());
            preparedStatement.setString(2, ticket.getPassengerName());
            preparedStatement.setLong(3, ticket.getFlightId());
            preparedStatement.setString(4, ticket.getSeatNo());
            preparedStatement.setBigDecimal(5, ticket.getCost());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                ticket.setId(generatedKeys.getLong(KEY_ID));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return ticket;
    }

    @Override
    public void update(Ticket ticket) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
            preparedStatement.setString(1, ticket.getPassengerNo());
            preparedStatement.setString(2, ticket.getPassengerName());
            preparedStatement.setLong(3, ticket.getFlightId());
            preparedStatement.setString(4, ticket.getSeatNo());
            preparedStatement.setBigDecimal(5, ticket.getCost());
            preparedStatement.setLong(6, ticket.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean delete(Long id) {
        boolean result;
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setLong(1, id);
            result = (preparedStatement.executeUpdate() > 0);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return result;
    }

    public static TicketDao getInstance() {
        return INSTANCE;
    }

}
