/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mapimpress.SQLplanner;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.xml.sax.SAXException;

/**
 *
 * @author Programmer
 */
public class ConfigTest {
    
    private Config instance;
    
    @Before
    public void setUp() throws ParserConfigurationException, SAXException, IOException {
        instance = new Config("d:\\NBProjects\\SQLplanner\\sqlplanner.conf");
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getLastError method, of class Config.
     */
    @Test
    public void testMethod_GetLastError() throws ParserConfigurationException, SAXException, IOException {
        Config conf = new Config("sqlplanner.conf");
        assertEquals("", conf.getLastError());
    }
    
    /**
     * Test of getLastError method, of class Config.
     */
    @Test
    public void testMethod_GetLastError_File_Not_Found() throws ParserConfigurationException, SAXException, IOException {
        Config conf = new Config("sqlplanner_not_found.conf");
        assertNotEquals("", conf.getLastError());
    }
    
    /**
     * Test of getLastError method, of class Config.
     */
    @Test
    public void testMethod_GetLastError_XML_Bad_Structure() throws ParserConfigurationException, SAXException, IOException {
        Config conf = new Config("sqlplanner_bad_structure.conf");
        assertNotEquals("", conf.getLastError());
    }
    
    /**
     * Test of getParameter method, of class Config.
     */
    @Test
    public void testMethod_getParameter_Type() throws ParserConfigurationException, SAXException, IOException {
        Config conf = new Config("sqlplanner.conf");
        assertEquals("Thin", conf.getParameter("Server", "Type"));
    }
    
    /**
     * Test of getParameter method, of class Config.
     */
    @Test
    public void testMethod_getParameter_Port() throws ParserConfigurationException, SAXException, IOException {
        Config conf = new Config("sqlplanner.conf");
        assertEquals("1521", conf.getParameter("Server", "Port"));
    }
    
    /**
     * Test of getParameter method, of class Config.
     */
    @Test
    public void testMethod_getParameter_Host() throws ParserConfigurationException, SAXException, IOException {
        Config conf = new Config("sqlplanner.conf");
        assertEquals("192.168.0.13", conf.getParameter("Server", "Host"));
    }

}
