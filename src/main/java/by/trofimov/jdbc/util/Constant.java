package by.trofimov.jdbc.util;

public final class Constant {

    private Constant() {
    }

    public static final String SEPARATOR = ";";

    public static final String DB_URL = "db.url";
    public static final String DB_USERNAME = "db.username";
    public static final String DB_PASSWORD = "db.password";

    public static final String FIND_ALL_SQL = """
            SELECT id,
                   passenger_no,
                   passenger_name,
                   flight_id,
                   seat_no,
                   cost
            FROM ticket
            """;

    public static final String FILTER_SQL = FIND_ALL_SQL + """
            LIMIT ?
            OFFSET ?
             """;

    public static final String FIND_BY_ID_SQL = FIND_ALL_SQL + """
            WHERE id = ?
            """;

    public static final String SAVE_SQL = """
            INSERT INTO ticket
            (passenger_no, passenger_name, flight_id, seat_no, cost)
            VALUES (?, ?, ?, ?, ?)
            """;

    public static final String UPDATE_SQL = """
            UPDATE ticket
            SET passenger_no = ?,
                passenger_name = ?,
                flight_id = ?,
                seat_no = ?,
                cost = ?
            WHERE id = ?
            """;

    public static final String DELETE_SQL = """
            DELETE FROM ticket
            WHERE id = ?
            """;

    public static final String KEY_ID = "id";
    public static final String KEY_PASSENGER_NO = "passenger_no";
    public static final String KEY_PASSENGER_NAME = "passenger_name";
    public static final String KEY_FLIGHT_ID = "flight_id";
    public static final String KEY_SEAT_NO = "seat_no";
    public static final String KEY_COST = "cost";

}
