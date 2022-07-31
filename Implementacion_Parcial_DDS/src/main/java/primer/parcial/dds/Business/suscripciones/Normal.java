package primer.parcial.dds.Business.suscripciones;

import primer.parcial.dds.Business.canciones.Cancion;
import primer.parcial.dds.Security.sistema.Usuario;

public class Normal extends Suscripcion {
    public int modo=2;

    @Override
    public Suscripcion cambiarModo(Suscripcion unModo, Usuario unUsuario) {
        if(unModo.getInt() == 3) {
            if (unUsuario.restarCredito(5)){
                return new Premium();
            }else{System.out.println("No se puede cambiar la suscripcion, no hay credito"); }
        } else if (unModo.getInt() == 2) {
            System.out.println("Ya estaba en modo Normal");
        } else {
            return new SinSuscripcion();
        }
        return unModo;
    }

    @Override
    public void votarCancion(String nombrePeli, int nota, Usuario user) {
        Cancion cancion = new Cancion();
        cancion.darNombreYnota(nombrePeli,nota);
        user.agregarVotadas(cancion);

    }
    @Override
    public int getInt(){return modo;}


}
