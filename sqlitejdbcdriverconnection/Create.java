package sqlitejdbcdriverconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {

    public static void createNewTable() {

        String url = "jdbc:sqlite:prog.db";

        String sql = "CREATE TABLE IF NOT EXISTS clase ("
                + "	id integer PRIMARY KEY,"
                + "	name text NOT NULL,"
                + "	secondname text  NOT NULL,"
                + "     pais text NOT NULL"
                + ");";

        String sql2 = "CREATE TABLE IF NOT EXISTS procedencia ("
                + "     id integer PRIMARY KEY,"
                + "     pais text NOT NULL"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {

            stmt.execute(sql2);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
