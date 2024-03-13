package com.mycompany.examen.DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class SQLiteDataHelper {
    // URL de conexión a la base de datos SQLite en el contenedor Docker
    private static final String DB_URL = "jdbc:sqlite:C:/Users/LPILAMUNGA/OneDrive - COBIS/Documents/NetBeansProjects/Examen/db/ASSIST_CONTROL.sqlite";
    private static Connection conn = null;

    // Constructor protegido para evitar que se cree una instancia de la clase
    protected SQLiteDataHelper(){}

    // Método para abrir una conexión a la base de datos
    public static synchronized Connection openConnection() throws SQLException {
        try {
            if(conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(DB_URL);
            }
        } catch (SQLException e) {
            throw e;
        }
        return conn;
    }

    // Método para cerrar la conexión a la base de datos
    protected static void closeConnection() throws SQLException {
        try {
            if(conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }
}
