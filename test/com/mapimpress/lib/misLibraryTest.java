package com.mapimpress.lib;

import com.mapimpress.lib.misLibrary;
import org.junit.Test;
import static org.junit.Assert.*;

public class misLibraryTest {
    
    /**
     * Test of CurrentDir method, of class misLibrary.
     */
    @Test
    public void test_Method_getJarDir() {
        assertEquals("D:\\NBProjects\\SQLplanner\\", misLibrary.getJarDir());
    }
    
}
