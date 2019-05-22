package sqlitejdbcdriverconnection;

;
import java.sql.DriverManager;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Querying {

    private Connection connect() {
        String url = "jdbc:sqlite:prog.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void select(String sql) {

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                try {
                    System.out.print(rs.getInt("id") + " ");
                } catch (Exception e) {

                }
                try {
                    System.out.print(rs.getString("name") + " ");
                } catch (Exception e) {

                }
                try {
                    System.out.print(rs.getString("secondname"));
                } catch (Exception e) {

                }
                try {
                    System.out.print(rs.getString("pais"));
                } catch (Exception e) {

                }
                System.out.println("");
                System.out.println("");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            this.connect().close();
        } catch (SQLException ex) {
        }
    }
}
