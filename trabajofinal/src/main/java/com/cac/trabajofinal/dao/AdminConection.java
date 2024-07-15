package com.cac.trabajofinal.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdminConection {
    
    
    public static Connection conectar() {
        String url = "jdbc:mysql://127.0.0.1:3306/personas?serverTimeZone=UTC&userSSL=false";
        String user = "root";
        String password = "root";
        String driver = "com.mysql.cj.jdbc.Driver";
        Connection connection = null;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion exitosa");
        } catch (Exception e) {
            System.out.println("Error al conectarse: " + e.getMessage());
        }
        return connection;
    }

    public static void desconectar(Connection connection) {
        try {
            System.out.println("Se cerro la conexion");
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
