package connection;

import exception.FailedConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/NOME_BANCO?user=root&password=Brum@mysql180580"
            );
        } catch (SQLException e) {
            throw new FailedConnectionException("FAILED TO CONNECT TO DATABASE!!!");
        }
    }
}
