
package sqlitejdbcdriverconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

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

    public void update(int id, String name, String secondname, String pais) {
        String sql = "UPDATE clase SET name = ? , "
                + "secondname = ? , "
                + "pais = ? "
                + "WHERE id = ?";

        String sql2 = "UPDATE procedencia SET pais = ? "
                + "WHERE id = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, secondname);
            pstmt.setString(3, pais);
            pstmt.setInt(4, id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql2)) {

            pstmt.setString(1, pais);
            pstmt.setInt(2, id);

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
