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
public class Delete {

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

    public void delete(int id) {
        String sql = "DELETE FROM clase WHERE id = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        String sql2 = "DELETE FROM procedencia WHERE id = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql2)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            this.connect().close();
        } catch (SQLException ex) {

        }
    }

}
