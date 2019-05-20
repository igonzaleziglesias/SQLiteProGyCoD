package sqlitejdbcdriverconnection;

import static sqlitejdbcdriverconnection.Connect.connect;
import static sqlitejdbcdriverconnection.Connect.disconnect;
import static sqlitejdbcdriverconnection.Create.createNewTable;

public class SQLiteJDBCDriverConnection {

    public static void main(String[] args) {
        connect();
        createNewTable();
        Consultas consulta = new Consultas();
        consulta.setVisible(true);
        disconnect();
//Querying quest = new Querying();
//quest.select("select id from clase where name=\"Cesar\"");
//        System.out.println("");
//    quest.select("select name from clase where id=6468");    
    }
}
