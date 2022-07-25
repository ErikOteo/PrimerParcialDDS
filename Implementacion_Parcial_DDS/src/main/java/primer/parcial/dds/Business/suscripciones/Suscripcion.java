package primer.parcial.dds.Business.suscripciones;

import primer.parcial.dds.Security.sistema.Usuario;

public class Suscripcion {
    int modo;

    public Suscripcion cambiarModo(Suscripcion unModo, Usuario unUsuario) { return unModo; }


    public void votarPelicula(String nombrePeli, int nota,Usuario user) {
    }

    public void agregarVista(String nombrePeli, Usuario yo) {
    }

    public int getInt(){return modo;}
}
