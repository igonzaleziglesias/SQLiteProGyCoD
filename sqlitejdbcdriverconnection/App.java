/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlitejdbcdriverconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author igonzaleziglesias
 */
public class App {

    private static Connection connecta() {
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

    public void insert(int id, String name, String secondname, String pais) {
        String sql = "INSERT INTO clase(id,name,secondname,pais) VALUES(?,?,?,?)";
        String sql2 = "INSERT INTO procedencia (id,pais) VALUES(?,?)";

        try (Connection conn = this.connecta();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, secondname);
            pstmt.setString(4, pais);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try (Connection conn = this.connecta();
                PreparedStatement pstmt = conn.prepareStatement(sql2)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, pais);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
