package com.mapimpress.SQLplanner.Oracle;

public class OraConnectionFactory {
    
    public static enum ocType {OCI, THIN};

    public static iConnection getOraConnection(ocType Type) {
        switch (Type) {
            case OCI:
                return new OraOciConnection();
            case THIN:
                return new OraThinConnection();
            default:
                return null;
        }
    }

}
