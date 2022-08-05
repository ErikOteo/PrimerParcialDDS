package Repository.producto;

import negocio.Tienda.Producto;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductosDAO {
    private Connection conn;

    public ProductosDAO(Connection connection){
        this.conn = connection;
    }

    public List<Producto> selectAll(){
        ProductosSimplesDAO productosSimplesDAO = new ProductosSimplesDAO(conn);
        CombosDAO combosDAO = new CombosDAO(conn);

        return Stream.concat(productosSimplesDAO.selectAll().stream(),combosDAO.selectAll().stream()).collect(Collectors.toList());
    }
}
