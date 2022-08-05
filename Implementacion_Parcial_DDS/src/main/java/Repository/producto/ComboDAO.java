package Repository.producto;

import java.sql.*;

public class ComboDAO {
    private final Connection conn;

    public ComboDAO(Connection connection){
        this.conn = connection;
    }

    public int insert(String nombre, String codigo) {

        String consulta = "INSERT INTO combo (nombre, codigo) " +
                "VALUES ('" + nombre + "','" + codigo + "');";

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

    public boolean updateDescuento(int idCombo,int descuento) {
        String consulta = "UPDATE combo SET descuento = " + descuento + " WHERE id = " + idCombo + ";";

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
