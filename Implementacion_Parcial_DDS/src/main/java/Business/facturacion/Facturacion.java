package Business.facturacion;

import negocio.Boleto.Boleto;
import negocio.Tienda.Producto;

public class Facturacion {
    private int  precioFinal;
    private static int impuesto=10;
    public Facturacion()
    {
        this.precioFinal = 0;
    }
    public void generarFacturaProducto(Producto producto) {
        int precioProducto = producto.getPrecio();
        int nuevoPrecio = precioProducto - ((precioProducto * impuesto)/100);
        this.precioFinal += nuevoPrecio;
    };
    public void generarFacturaBoleto(Boleto boleto){
        int precioFactura = boleto.getPrecioFinal();
        int nuevoPrecio = precioFactura - (2*((precioFactura * impuesto)/100));
        this.precioFinal += nuevoPrecio;
    };
}
