package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Conexion instance = null;
    private final Connection connection;

    private Conexion(){
        connection = this.newConnection();
    }

    public static Conexion getInstance(){
        if(instance == null){
            instance = new Conexion();
        }
        return instance;
    }

    private Connection newConnection() {
        Connection conn = null;
        try {
            String connectionUrl = "jdbc:mysql://localhost:3306/dds";
            conn = DriverManager.getConnection(connectionUrl, "root", "1234");
            return conn;
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return null;
        }
    }

    public Connection getConnection(){
        return connection;
    }
}
