package com.mapimpress.SQLplanner;

import com.mapimpress.lib.misLibrary;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class Config {
    
    private String lastError = "";
    private Node root;
    
    public Config(String configFileName) throws ParserConfigurationException, SAXException, IOException {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String configPath = misLibrary.getJarDir();
            Document document = documentBuilder.parse(configPath + configFileName);
            root = document.getDocumentElement();
        } catch (Exception ex) {
            lastError = ex.getMessage();
        }

    }

    public String getLastError() {
        return lastError;
    }
}
