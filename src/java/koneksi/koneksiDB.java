/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Topan
 */
public class koneksiDB {
     public static koneksiDB instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/mgs?zeroDateTimeBehavior=convertToNull";
    private String username = "root";
    private String password = "";

    private koneksiDB() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database Connection success");
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public  Connection getConnection() {
        return connection;
    }

    public static koneksiDB getInstance() throws SQLException {
        if (instance == null) {
            instance = new koneksiDB();
        } else if (instance.getConnection().isClosed()) {
            instance = new koneksiDB();
        }

        return instance;
    }
}
