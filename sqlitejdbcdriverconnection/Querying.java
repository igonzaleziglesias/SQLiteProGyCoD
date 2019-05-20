package sqlitejdbcdriverconnection;

;
import java.sql.DriverManager;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Querying {

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:prog.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

//    public void selectAll() {
//        String sql = "SELECT id, name, secondname, pais FROM clase";
//System.out.println("ID      NAME    SECONDNAME      PAIS");
//        try (Connection conn = this.connect();
//                Statement stmt = conn.createStatement();
//                ResultSet rs = stmt.executeQuery(sql)) {
//
//            // loop through the result set
//            while (rs.next()) {
//                System.out.println(rs.getInt("id") + "\t"
//                        + rs.getString("name") + "\t"
//                        + rs.getString("secondname")+ "\t"
//                        + rs.getString("pais"));
//
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        System.out.println("");
//        System.out.println("ID      PAIS");
//                String sql2 = "SELECT id, pais FROM procedencia";
//
//        try (Connection conn = this.connect();
//                Statement stmt = conn.createStatement();
//                ResultSet rs = stmt.executeQuery(sql2)) {
//
//            // loop through the result set
//            while (rs.next()) {
//                System.out.println(rs.getInt("id") + "\t"
//                        + rs.getString("pais"));
//
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//
//    }

    public void select(String sql) {

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            // loop through the result set
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
                    System.out.println(rs.getString("secondname"));
                } catch (Exception e) {

                }
                try {
                    System.out.println(rs.getString("pais"));
                } catch (Exception e) {

                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
