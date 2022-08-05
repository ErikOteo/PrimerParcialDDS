package Business.tienda;

import persistencia.Conexion;
import persistencia.producto.ComboDAO;
import persistencia.producto.ProductoSimpleDAO;

import java.util.List;

public class Combo extends Producto {
    private int Porcentajedescuento;
    private List<Producto> productos;

    public Combo(){}

    public Combo(String nombre, String codigo) {
        this.setNombre(nombre);
        this.setCodigo(codigo);
        this.setPrecio(0);

        ComboDAO comboDAO = new ComboDAO(Conexion.getInstance().getConnection());
        this.setId(comboDAO.insert(nombre,codigo));
    }

    @Override
    public int calcularPrecio() {
        int precioCombo = this.getPrecio();//sumar el precio de todos los productos
        for (Producto producto : productos)
        {
             precioCombo += producto.calcularPrecio();
        }
        precioCombo = calcularDescuento(precioCombo);
        this.setPrecio(precioCombo);
        return precioCombo;
    }


    public void setProductos(List<Producto> productos) {
        ProductoSimpleDAO productoSimpleDAO = new ProductoSimpleDAO(Conexion.getInstance().getConnection());
        productos.forEach(producto -> productoSimpleDAO.updateCombo(producto.getId(),this.getId()));
        this.productos = productos;
    }
    public int calcularDescuento(int precioCombo)
    {
        return  precioCombo - ((precioCombo * Porcentajedescuento)/100);
    }

    public void setPorcentajedescuento(int porcentajedescuento) {
        ComboDAO comboDAO = new ComboDAO(Conexion.getInstance().getConnection());
        comboDAO.updateDescuento(this.getId(),porcentajedescuento);
        this.Porcentajedescuento = porcentajedescuento;
    }
}

