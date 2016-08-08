package com.mapimpress.SQLplanner.Oracle;

import java.sql.Connection;

public interface iConnection {

    public Connection Connect(String userName, String userPass, String oraDBName, String oraDBRole);

    public Connection getConnection();

    public boolean closeConnection();

    public String getLastError();

}
