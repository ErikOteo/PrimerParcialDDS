package primer.parcial.dds.Business.suscripciones;

import primer.parcial.dds.Business.canciones.Cancion;
import primer.parcial.dds.Security.sistema.Usuario;

public class Premium extends Suscripcion {
    public int modo=3;

    @Override
    public Suscripcion cambiarModo(Suscripcion unModo, Usuario unUsuario) {
        if(unModo.getInt() == 3) {
            System.out.println("Ya estaba en modo Premium... Te recomendamos un oculista");
            System.out.println("Dr. Lucas Giorgio                                  Tel. 4855-4821");
        } else if (unModo.getInt() == 2) {
            if (unUsuario.restarCredito(1)){
                return new Normal();
            }else{System.out.println("No se puede cambiar la suscripcion, no hay credito"); }
        } else {
            return new SinSuscripcion();
        }
        return unModo;
    }

    @Override
    public void votarCancion(String nombrePeli, int nota, Usuario user) {
        Cancion peli = new Cancion();
        peli.darNombreYnota(nombrePeli,nota);
        user.agregarVotadas(peli);
        if(!user.laEscucho(nombrePeli)){
        user.agregarVistas(peli);}
    }
    @Override
    public void agregarVista(String nombrePeli, Usuario yo) {
        Cancion cancion = new Cancion();
        cancion.darNombre(nombrePeli);
        yo.agregarVistas(cancion);
    }

    @Override
    public int getInt(){return modo;}
}