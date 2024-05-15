package br.com.alura.bytebank;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionFactory {

    public Connection recuperarConexao() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/byte_bank?user=root&password=Brum@mysql180580");
        } catch (SQLException e) {
            System.out.println("ola");
            throw new RuntimeException(e);
        }
    }

    private HikariDataSource createDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/byte_bank");
        config.setUsername("root");
        config.setPassword("root");
        config.setMaximumPoolSize(10);

        return new HikariDataSource(config);
    }
}
