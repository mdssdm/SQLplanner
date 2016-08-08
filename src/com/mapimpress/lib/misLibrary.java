package com.mapimpress.lib;

public class misLibrary {
    
    public static void main(String[] args) {
        System.out.println("");
    }

    public static String getJarDir() {
        String path = new java.io.File(".").getAbsolutePath();
	String FileSeparator = (String)System.getProperty("file.separator");
	return path.substring(0, path.lastIndexOf(FileSeparator) + 1);
    }
    
}
