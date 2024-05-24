package service;

import connection.DatabaseConnection;
import dao.HomeDAO;
import view.Home;

import java.sql.Connection;
import java.util.List;

public class HomeService {
    private DatabaseConnection connection;
    public HomeService() {this.connection = new DatabaseConnection();}
    public List<Integer> searchSongs(String text) {
        Connection conn = connection.getConnection();
        return new HomeDAO(conn).search("songs", "id", text);
    }

    public List<Integer> searchArtists(String text) {
        Connection conn = connection.getConnection();
        return new HomeDAO(conn).search("artists", "id", text);
    }
}
