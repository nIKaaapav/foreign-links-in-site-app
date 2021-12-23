package db;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    public static final String URL = "jdbc:postgresql://localhost:5432/links-calculeted-luxoft-app?password=pg123456&user=postgres";
    public static final String USER = "postgres";
    public static final String PASS = "pg123456";

    public Connection getConnection(){
        try {
            Properties properties = new Properties();
            properties.setProperty("user", USER);
            properties.setProperty("pass", PASS);

            return new Driver().connect(URL, properties );
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
