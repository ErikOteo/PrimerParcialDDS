package Business.promocion;

import negocio.Cine.Funcion;

public class Miercoles extends Promocion {
    private static int porcentajedescuento = 25;
    public int setPorcentajedescuento()
    {
        return this.porcentajedescuento;
    }
    @Override
    public int precioEntradas(Funcion funcion)
    {
        int precioEntrada = funcion.getPrecioGeneral();
        //25 % de descuento
        int precio = precioEntrada - ((precioEntrada * porcentajedescuento)/100);
        return precio;
    }
}
