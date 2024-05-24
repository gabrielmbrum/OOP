package exception;

import connection.DatabaseConnection;

public class DatabaseSearchException extends RuntimeException{
    public DatabaseSearchException (String message) {
        super(message);
    }
}
