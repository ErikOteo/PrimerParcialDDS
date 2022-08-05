package Repository.cliente;

import negocio.Cliente.Cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientesDAO {
    private Connection conn;

    public ClientesDAO(Connection connection){
        this.conn = connection;
    }

    public Cliente select(int idCliente){
        try {
            // generacion de query
            String consulta = "SELECT * FROM cliente where id = " + idCliente + ";";

            // Ejecucion
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            Cliente obj = new Cliente();
            while (rs.next()) {
                obj.setNombre(rs.getString("nombre"));
                obj.setApellido(rs.getString("apellido"));
            }
            return obj;
        } catch (SQLException ex) {
            System.out.println("Error en Select");
            return null;
        }
    }
}
