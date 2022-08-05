package Repository.cliente;

import java.sql.*;

public class ClienteDAO {
    private final Connection conn;

    public ClienteDAO(Connection connection){
        this.conn = connection;
    }

    public int insert(String nombre, String apellido) {
        String consulta = "INSERT INTO cliente (nombre, apellido) VALUES ('" + nombre + "','" + apellido + "');";

        try {
            // Ejecucion
            PreparedStatement stmt = this.conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);

            // execute the preparedstatement
            stmt.executeUpdate();

            // obtener ultimo id generado
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next())
                return generatedKeys.getInt(1);
            else
                return 0;
        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Insert");
            return 0;
        }

    }
}
