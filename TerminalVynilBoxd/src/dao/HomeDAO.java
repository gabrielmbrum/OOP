package dao;

import exception.DatabaseSearchException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HomeDAO {
    private Connection connection;

    public HomeDAO(Connection connection) {this.connection = connection;}

    public List<Integer> search(String table, String column, String text) {
        PreparedStatement ps;
        ResultSet rs;
        List<Integer> result = new ArrayList<>();

        char formatter = '\'';
        text = formatter + text + '%' + formatter;

        String sql = "SELECT ? FROM ? WHERE name LIKE ?";

        try {
            ps = connection.prepareStatement(sql);

            ps.setString(1, column);
            ps.setString(2, table);
            ps.setString(3, text);

            rs = ps.executeQuery();

            while(rs.next()) {
                result.add(rs.getInt(1));
            }

            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            throw new DatabaseSearchException("ERROR WHILE SEARCHING SONG!!!");
        }

        return result;
    }

}
