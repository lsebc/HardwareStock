/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardwarestock;

/**
 *
 * @author ls
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class DBConn {

    public Connection dbConnection() throws Exception {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String myDB = "jdbc:odbc:Driver={Microsoft Access Driver "
                + "(*.mdb, *.accdb)};DBQ=C:\\NetbeansProject\\AccessDB\\HardwareStock.accdb";
        return DriverManager.getConnection(myDB);

    }

    public Vector getPcInfo(String s) throws Exception {

        Vector<Vector<String>> roomVector = new Vector<Vector<String>>();

        Connection conn = dbConnection();
        PreparedStatement ps = conn.prepareStatement(s);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Vector<String> room = new Vector<String>();
            //room.add(rs.getString("room_no")); //Empid
            room.add(rs.getString("pc_id")); //name
            room.add(rs.getString("pcname"));
            room.add(rs.getString("cpu"));
            room.add(rs.getString("mobo"));
            room.add(rs.getString("memory"));
            room.add(rs.getString("gpu"));
            room.add(rs.getString("storage"));
            
            roomVector.add(room);
        }

        /*Close the connection after use (MUST)*/
        if (conn != null) {
            conn.close();
        }

        return roomVector;
    }
}
