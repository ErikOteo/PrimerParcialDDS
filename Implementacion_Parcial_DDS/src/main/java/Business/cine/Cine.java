package Business.cine;

import Business.cliente.Cliente;
import Business.tienda.Tienda;


import java.util.List;

public class Cine {
    private static Cine instance = null;
    private List<Funcion> funciones;
    private List<Cliente> clientes;
    private List<String> reclamos;
    private List<String> contrasenias;
    private Tienda tienda;

    private Cine(){
    }
    public static Cine getInstance(){
        if(instance == null){
            instance = new Cine();
        }
        return instance;
    }
    public List<String> getReclamos(){
        return this.reclamos;
    }
    public List<String> getContrasenias(){
        return this.contrasenias;
    }

}
