package Business.boleto;

import negocio.Cine.Funcion;
import negocio.Cliente.Cliente;
import negocio.Promocion.Promocion;

public class Reserva extends EstadoBoleto{
    private String codigo;
    private Cliente cliente;
    private int numeroSala;
    private int precioGeneral;
    private int precioFinal;
    private Funcion funcion;
    private Promocion promocion;
    private String filaColumna;
    private int descuentProductos;
    public void setDescuentProductos()
    {
        this.descuentProductos = 0;
    }
    public void cancelarReserva(Cliente cliente)
    {
        this.funcion.disponibilidadBoleto(this.filaColumna,true);
    }
    public void  pagarReserva(Boleto reserva)
    {
        Boleto nuevaEntrada = new Boleto(this.cliente,this.funcion,this.filaColumna,this);
        cliente.removeReserva(reserva);
        cliente.addEntrada(nuevaEntrada);
        reserva.setEstadoBoleto(new Pagado());
    }
}
