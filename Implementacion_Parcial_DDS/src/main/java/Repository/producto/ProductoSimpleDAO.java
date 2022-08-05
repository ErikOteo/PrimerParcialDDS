package Repository.producto;

import java.sql.*;

public class ProductoSimpleDAO {
    private final Connection conn;

    public ProductoSimpleDAO(Connection connection){
        this.conn = connection;
    }

    public int insert(String nombre, String codigo, int precio) {

        String consulta = "INSERT INTO productoSimple (nombre, codigo, precio) " +
                "VALUES ('" + nombre + "','" + codigo + "'," + precio + ");";

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

    public boolean updateCombo(int idProductoSimple,int idCombo) {
        String consulta = "UPDATE productoSimple SET id_combo = " + idCombo + " WHERE id = " + idProductoSimple + ";";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(consulta);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error en Update");
            return false;
        }
    }
}
