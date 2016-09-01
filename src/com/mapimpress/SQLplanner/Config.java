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
    
    private Node getChildByName(Node node, String name) {
        Node child = node.getFirstChild();
        while (child != null) {
            if (child.getNodeName() == name) {
                return child;
            }
            child = child.getNextSibling();
        }
        return null;
    }
    
    private String getNodeText(Node node) {
        Node child = node.getFirstChild();
        while (child != null) {
            if (child.getNodeName() == "#text") {
                return child.getNodeValue();
            }
            child = child.getNextSibling();
        }
        return null;
    }
    
    public String getParameter(String Section, String Parameter) {
        Node section = getChildByName(root, Section);
        if (section != null) {
            Node parameter = getChildByName(section, Parameter);
            if (parameter != null) {
                return getNodeText(parameter);
            }
        }
        return null;
    }

    public String getLastError() {
        return lastError;
    }
}
