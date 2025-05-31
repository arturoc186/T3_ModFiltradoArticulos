package DAO;

import POJOS.*;

import java.sql.*;

public class DBUtils {
    private static Connection conn = null;

    public DBUtils() {
    }

    public void conecta(){
        try {
            System.out.println("Conectando con la Base de datos...");
            String jdbcUrl = "jdbc:mysql://localhost:3306/tienda_ropa";
            conn = DriverManager.getConnection(jdbcUrl, "root", "MySQL24-25");
            System.out.println("Conexión establecida con la Base de datos...");
        } catch (SQLException se) {
            //Errores de JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Errores de Class.forName
            e.printStackTrace();
        }
    }

    public void cerrarConexion() {
        // se cerrará la conexión a la BBDD.
        try {
            if (conn != null) {
                conn.close();
            }
            System.out.println("\nConexión cerrada con éxito.");
        } catch (SQLException ex) {
            System.out.println("\nERROR: NO se ha PODIDO CERRAR la conexión.");
        }
    }

    public static Connection getConexion(){
        return conn;
    }
}