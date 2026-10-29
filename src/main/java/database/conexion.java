
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author doria
 */
public class conexion {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/gestion_clientes";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin89";
    
    
    public static Connection getConnection() throws SQLException {
        try {
            // Cargar el driver JDBC para PostgreSQL
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se pudo cargar el driver de PostgreSQL", e);
        }
    }
    
    
    public static void testConnection() {
        try (Connection conn = getConnection()) {
            if (conn != null) {
                System.out.println("Conexion exitosa a la base de datos.");
            } else {
                System.out.println("No se pudo conectar a la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        testConnection();
    }
    
}
