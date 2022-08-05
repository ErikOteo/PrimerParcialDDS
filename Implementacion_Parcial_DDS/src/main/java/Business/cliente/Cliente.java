package Business.cliente;

import negocio.Boleto.Boleto;
import negocio.Boleto.Pagado;
import negocio.Boleto.Reserva;
import negocio.Cine.Funcion;
import negocio.Tienda.Producto;
import persistencia.Conexion;
import persistencia.cliente.ClienteDAO;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int id;
    private String nombre;
    private String apellido;
    private List<Boleto> entradas;
    private List<Boleto> reservas;
    private List<Producto> combos;

    public Cliente(){

    }

    public Cliente(String nombre,String apellido)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.entradas = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.combos = new ArrayList<>();

        ClienteDAO clienteDAO = new ClienteDAO(Conexion.getInstance().getConnection());
        this.id = clienteDAO.insert(this.nombre,this.apellido);
    }

    public List<Boleto> getEntradas(){return this.entradas;};
    public List<Boleto> getReservas(){return this.reservas;};
    public void setEntradas(List<Boleto> entradas){this.entradas = entradas;}
    public void setReservas(List<Boleto> reservas){this.reservas = reservas;}
    public void removeReserva(Boleto reserva){this.reservas.remove(reserva);}
    public void addReserva(Boleto reserva){this.reservas.add(reserva);}
    public void removeEntrada(Boleto entrada){this.entradas.remove(entrada);}
    public void addEntrada(Boleto entrada){this.entradas.add(entrada);}

    public void pedirEntradaporfila(Funcion funcion,String filaColumna)
    {
        Boleto nuevaEntrada;
        if(funcion.validarUbicacion(filaColumna))
        {
            nuevaEntrada =  funcion.solicitarBoleto(filaColumna,this,new Pagado());
           this.addEntrada(nuevaEntrada);
        }
    }

    public void pedirEntradaaleatoria(Funcion funcion)
    {
            if(funcion.getAsientosLibres() >0)
            {
                Boleto nuevaEntrada = funcion.boletoAleatorio(this,new Pagado());
                this.addEntrada(nuevaEntrada);
            }
            else
            {
                //No hay mas entradas para la funcion solicitada
            }
    }
    public void pedirReserva(Funcion funcion,String filaColumna)
    {
        Boleto nuevaReserva;
        if(funcion.validarUbicacion(filaColumna))
        { nuevaReserva =  funcion.solicitarBoleto(filaColumna,this,new Reserva());
            this.addReserva(nuevaReserva);
        }
        //Si no hay ubicacion para esa columna fila debe seleccionar otra el sistema no le dara opciones
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }
}
