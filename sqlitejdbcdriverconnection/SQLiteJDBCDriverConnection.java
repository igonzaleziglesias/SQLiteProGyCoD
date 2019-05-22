package sqlitejdbcdriverconnection;

import static sqlitejdbcdriverconnection.Create.createNewTable;

public class SQLiteJDBCDriverConnection {

    public static void main(String[] args) {

        createNewTable();
        Consultas consulta = new Consultas();
        consulta.setVisible(true);    
    }
}
