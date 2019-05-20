package sqlitejdbcdriverconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {

    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:prog.db";

        // SQL statement for creating a new table
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
            // create a new table
            stmt.execute(sql2);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
//    
//    public static void borrar(){
//         String url = "jdbc:sqlite:tests.db";
//            String sql = "DROP TABLE clase;";
//                 try (Connection conn = DriverManager.getConnection(url);
//                Statement stmt = conn.createStatement()) {
//            // create a new table
//            stmt.execute(sql);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public Create( int id, String name, String secondname, String pais) {
//        // SQLite connection string
//        String url = "jdbc:sqlite:tests.db";
//
//        // SQL statement for creating a new table
//        String sql = "CREATE TABLE IF NOT EXISTS clase ("
//                + "	" + id + " integer PRIMARY KEY,"
//                + "	" + name + " text NOT NULL,"
//                + "	" + secondname + "secondname text NOT NULL"
//                + "     " + pais + " text NOT NULL"
//                + ");";
//        String sql2 = "CREATE TABLE IF NOT EXISTS procedencia ("
//                + "	" + id + " integer PRIMARY KEY,"
//                + "     " + pais + " text NOT NULL"
//                + ");";
//
//        try (Connection conn = DriverManager.getConnection(url);
//                Statement stmt = conn.createStatement()) {
//            // create a new table
//            stmt.execute(sql2);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        try (Connection conn = DriverManager.getConnection(url);
//                Statement stmt = conn.createStatement()) {
//            // create a new table
//            stmt.execute(sql);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }

}
