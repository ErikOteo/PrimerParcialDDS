package Business.tienda;

import negocio.Facturacion.Facturacion;

public abstract class Producto {
    private int id;
    private String  nombre;
    private String codigo;
    private int precio;

    abstract public int calcularPrecio ();
    public void generarFactura(Facturacion faturador)
    {
        faturador.generarFacturaProducto(this);
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
