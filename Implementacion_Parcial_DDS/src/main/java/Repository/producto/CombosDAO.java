package Repository.producto;

import negocio.Tienda.Combo;
import negocio.Tienda.Producto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CombosDAO {
    private Connection conn;

    public CombosDAO(Connection connection){
        this.conn = connection;
    }

    public List<Producto> selectAll(){
        try {
            // generacion de query
            String consulta = "SELECT * FROM combo;";

            // Ejecucion
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            ProductosSimplesDAO productosSimplesDAO = new ProductosSimplesDAO(conn);

            // Recorrer y usar cada linea retornada
            List<Producto> combos = new ArrayList<>();

            while (rs.next()) {
                Combo obj = new Combo();

                obj.setNombre(rs.getString("nombre"));
                obj.setCodigo(rs.getString("codigo"));
                obj.setPorcentajedescuento(rs.getInt("descuento"));
                obj.setProductos(productosSimplesDAO.selectPorCombo(rs.getInt("id")));
                combos.add(obj);
            }
            return combos;
        } catch (SQLException ex) {
            System.out.println("Error en Select");
            return null;
        }
    }
}
