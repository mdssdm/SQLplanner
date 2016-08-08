package com.mapimpress.SQLplanner.Oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

public class OraThinConnection implements iConnection {
    
    private Connection conn;
    private String lastError = "";

    @Override
    public Connection Connect(String userName, String userPass, String oraDBName, String oraDBRole) {
        conn = null;
        Locale defLocale = Locale.getDefault();
        Locale.setDefault(Locale.ENGLISH);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try {
                if (oraDBRole.toLowerCase() != "normal") {
                    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:" + oraDBName, userName + " as " + oraDBRole, userPass);
                } else {
                    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:" + oraDBName, userName, userPass);
                }
            } catch (SQLException ex) {
                lastError = ex.getMessage();
            }
        } catch (ClassNotFoundException ex) {
            lastError = ex.getMessage();
        } finally {
            Locale.setDefault(defLocale);
            lastError = "";
            return conn;
        }
    }
    
    public Connection Connect(String userName, String userPass, String oraDBName) {
        return Connect(userName, userPass, oraDBName, "Normal");
    }

    @Override
    public Connection getConnection() {
        return conn;
    }

    @Override
    public boolean closeConnection() {
        try {
            conn.close();
            conn = null;
            lastError = "";
            return true;
        }
        catch (SQLException ex) {
            lastError = ex.getMessage();
            return false;
        }
    }

    @Override
    public String getLastError() {
        return lastError;
    }

}
