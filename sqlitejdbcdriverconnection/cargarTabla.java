/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlitejdbcdriverconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author igonzaleziglesias
 */
public class cargarTabla {

    static Object[] alumno;
    static Object[] datos;

    ArrayList<Object[]> lista = new ArrayList<Object[]>();
    ArrayList<Object[]> lista2 = new ArrayList<Object[]>();

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

    public ArrayList selectAll() {
        String sql = "SELECT id, name, secondname, pais FROM clase";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                alumno = new Object[4];
                alumno[0] = rs.getInt("id");
                alumno[1] = rs.getString("name");
                alumno[2] = rs.getString("secondname");
                alumno[3] = rs.getString("pais");
//                System.out.println(alumno[0] + " " + alumno[1] + " " + alumno[2]);
//                modelo.addRow(alumno);
                lista.add(alumno);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public ArrayList selectAll2() {
        String sql = "SELECT id, pais FROM procedencia";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                datos = new Object[2];
                datos[0] = rs.getInt("id");
                datos[1] = rs.getString("pais");
//                System.out.println(alumno[0] + " " + alumno[1] + " " + alumno[2]);
//                modelo.addRow(alumno);
                lista2.add(datos);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista2;
    }

}
