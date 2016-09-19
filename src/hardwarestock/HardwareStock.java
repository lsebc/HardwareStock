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
import java.sql.*;
public class HardwareStock {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        RoomInventory ri = new RoomInventory();
        ri.addPC();
        ri.DisplayList();
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
