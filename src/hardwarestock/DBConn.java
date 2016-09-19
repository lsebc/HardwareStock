/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardwarestock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ls
 */
public class DBConn {
    public void dbCon(){
        try {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String url = "jdbc:odbc:Driver={Microsoft Access Driver " +
            "(*.mdb, *.accdb)};DBQ=C:\\NetbeansProject\\AccessDB\\HardwareStock.accdb";
        Connection con = DriverManager.getConnection(url);
        System.out.println("Connected!");
        Statement stmt = null;
            ResultSet rs = null;
 
            // SQL query command
            String SQL = "SELECT * FROM PC";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                System.out.println(rs.getString("pcname") + " : "
                        + rs.getString("room_No")+ " : "
                        + rs.getString("cpu"));
            }
        con.close();
        } catch (SQLException e) {
            System.out.println("SQL Exception: "+ e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: "+
                cE.toString());
        }
    }
}
