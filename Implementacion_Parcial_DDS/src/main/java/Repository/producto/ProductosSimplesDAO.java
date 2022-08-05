package Repository.producto;

import negocio.Tienda.Producto;
import negocio.Tienda.ProductoSimple;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductosSimplesDAO {

    private Connection conn;

    public ProductosSimplesDAO(Connection connection){
        this.conn = connection;
    }

    public List<Producto> selectAll(){
        try {
            // generacion de query
            String consulta = "SELECT * FROM productoSimple where id_combo is null;";

            // Ejecucion
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            // Recorrer y usar cada linea retornada
            List<Producto> productosSimples = new ArrayList<>();

            while (rs.next()) {
                ProductoSimple obj = new ProductoSimple();

                obj.setNombre(rs.getString("nombre"));
                obj.setPrecio(rs.getInt("precio"));
                obj.setCodigo(rs.getString("codigo"));

                productosSimples.add(obj);
            }
            return productosSimples;
        } catch (SQLException ex) {
            System.out.println("Error en Select");
            return null;
        }
    }

    public List<Producto> selectPorCombo(int idCombo){
        try {
            // generacion de query
            String consulta = "SELECT * FROM productoSimple  where id_combo = " + idCombo + ";";

            // Ejecucion
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            // Recorrer y usar cada linea retornada
            List<Producto> productosSimples = new ArrayList<>();

            while (rs.next()) {
                ProductoSimple obj = new ProductoSimple();

                obj.setNombre(rs.getString("nombre"));
                obj.setPrecio(rs.getInt("precio"));
                obj.setCodigo(rs.getString("codigo"));

                productosSimples.add(obj);
            }
            return productosSimples;
        } catch (SQLException ex) {
            System.out.println("Error en Select");
            return null;
        }
    }
}
