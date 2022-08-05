package Repository.boleto;

import negocio.Boleto.Boleto;
import persistencia.cliente.ClientesDAO;
import persistencia.funcion.FuncionesDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BoletosDAO {
    private Connection conn;

    public BoletosDAO(Connection connection){
        this.conn = connection;
    }

    public List<Boleto> selectAll(){
        try {
            // generacion de query
            String consulta = "SELECT * FROM boleto;";

            // Ejecucion
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            ClientesDAO clientesDAO = new ClientesDAO(conn);
            FuncionesDAO funcionesDAO = new FuncionesDAO(conn);

            // Recorrer y usar cada linea retornada
            List<Boleto> entradas = new ArrayList<>();

            while (rs.next()) {
                Boleto obj = new Boleto();

                obj.setCliente(clientesDAO.select(rs.getInt("id_cliente")));
                obj.setFuncion(funcionesDAO.select(rs.getInt("id_funcion")));
                obj.setFilaColumna(rs.getString("fila_columna"));

                entradas.add(obj);
            }
            return entradas;
        } catch (SQLException ex) {
            System.out.println("Error en Select");
            return null;
        }
    }
}
