package Business.promocion;

import negocio.Cine.Funcion;

public class SinPromocion extends Promocion {
    private static int porcentajedescuento = 0;
    public int setPorcentajedescuento()
    {
        return this.porcentajedescuento;
    }
    @Override
    public int precioEntradas(Funcion funcion) {
        int precioEntrada = funcion.getPrecioGeneral();
        //0 % de descuento
        int precio = precioEntrada - ((precioEntrada * porcentajedescuento)/100);
        return precio;
    }
}
