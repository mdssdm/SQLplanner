package com.mapimpress.SQLplanner.Oracle;

import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OraOciConnectionTest {

    private OraOciConnection instance = null;
    
    @Before
    public void setUp() throws ClassNotFoundException, SQLException {
        instance = new OraOciConnection();
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of Connect method, of class OracleConnection.
     */
    @Test
    public void test_Method_Connect_As_Normal_User() {
        assertNotNull(instance.Connect("sys", "admin", "XE", "SYSDBA"));
    }

    /**
     * Test of Connect as SYSDBA method, of class OracleConnection.
     */
    @Test
    public void test_Method_Connect_As_SYSDBA_User() {
        assertNotNull(instance.Connect("hr", "hr", "XE", "Normal"));
    }

    /**
     * Test of getConnection method, of class OracleConnection.
     */
    @Test
    public void test_Method_GetConnection() {
        instance.Connect("hr", "hr", "XE");
        assertNotNull(instance.getConnection());
    }

    /**
     * Test of closeConnection method, of class OracleConnection.
     */
    @Test
    public void test_Method_CloseConnection() {
        instance.Connect("hr", "hr", "XE");
        assertTrue(instance.closeConnection());
    }

    /**
     * Test of getLastError method, of class OracleConnection.
     */
    @Test
    public void test_Method_getLastError() {
        instance.Connect("hr", "hr", "XE");
        assertEquals("", instance.getLastError());
    }
    
}
