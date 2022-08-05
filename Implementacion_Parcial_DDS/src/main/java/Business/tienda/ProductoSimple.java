package Business.tienda;

import negocio.Facturacion.Facturacion;
import persistencia.Conexion;
import persistencia.producto.ProductoSimpleDAO;

public class ProductoSimple extends Producto {
    @Override
    public int calcularPrecio() {
        return this.getPrecio();
    }

    @Override
    public void generarFactura(Facturacion facturaVisitor) {

    }

    public ProductoSimple(){}

    public ProductoSimple(String nombre, String codigo, int precio) {
        this.setNombre(nombre);
        this.setCodigo(codigo);
        this.setPrecio(precio);

        ProductoSimpleDAO productoSimpleDAO = new ProductoSimpleDAO(Conexion.getInstance().getConnection());
        this.setId(productoSimpleDAO.insert(nombre,codigo,precio));
    }
}
