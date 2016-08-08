package com.mapimpress.SQLplanner.Oracle;

import org.junit.Test;
import static org.junit.Assert.*;

public class OraConnectionFactoryTest {
    
    @Test
    public void test_Mathod_GetOraConnection_Get_OCI() {
        assertNotNull(OraConnectionFactory.getOraConnection(OraConnectionFactory.ocType.OCI));
    }
    
    @Test
    public void test_Mathod_GetOraConnection_Get_THIN() {
        assertNotNull(OraConnectionFactory.getOraConnection(OraConnectionFactory.ocType.THIN));
    }
    
}
