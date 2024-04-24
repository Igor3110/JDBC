package by.trofimov.jdbc.util;

public final class Constant {

    private Constant() {}

    public static final String DELETE_SQL = """
            DELETE FROM ticket
            WHERE id = ?
            """;
    public static final String SAVE_SQL = """
            INSERT INTO ticket
            (passenger_no, passenger_name, flight_id, seat_no, cost)
            VALUES (?, ?, ?, ?, ?)
            """;

    public static final String KEY_ID = "id";

}
