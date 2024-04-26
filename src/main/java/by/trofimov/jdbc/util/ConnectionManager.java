package by.trofimov.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static by.trofimov.jdbc.util.Constant.*;

public final class ConnectionManager {

    public static final String URL_KEY = DB_URL;
    public static final String USERNAME_KEY = DB_USERNAME;
    public static final String PASSWORD_KEY = DB_PASSWORD;

    private ConnectionManager() {
    }

    public static Connection get() {
        try {
            return DriverManager.getConnection(
                    PropertiesUtil.get(URL_KEY),
                    PropertiesUtil.get(USERNAME_KEY),
                    PropertiesUtil.get(PASSWORD_KEY)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
