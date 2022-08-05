package Repository.boleto;

import negocio.Cine.Funcion;
import negocio.Cliente.Cliente;

import java.sql.*;

public class BoletoDAO {
    private final Connection conn;

    public BoletoDAO(Connection connection){
        this.conn = connection;
    }

    public int insert(Cliente cliente, Funcion funcion, String filaColumna) {
        String consulta = "INSERT INTO boleto(id_cliente, id_funcion, fila_columna) " +
                "VALUES (" + cliente.getId() + ","+ funcion.getId() + ",'" + filaColumna + "');";

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
