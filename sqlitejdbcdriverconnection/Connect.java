package sqlitejdbcdriverconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect {

    private static Connection conn = null;

    public static void connect() {

        try {
            String url = "jdbc:sqlite:tests.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void disconnect() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
