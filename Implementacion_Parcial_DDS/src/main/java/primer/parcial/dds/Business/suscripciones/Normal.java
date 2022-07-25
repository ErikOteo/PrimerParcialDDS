package primer.parcial.dds.Business.suscripciones;

public class Normal extends Suscripcion {
    public int modo=2;

    @Override
    public Suscripcion cambiarModo(Suscripcion unModo, Usuario unUsuario) {
        if(unModo.getInt() == 3) {
            if (unUsuario.restarCredito(5)){
                return new Premium();
            }else{System.out.println("No se puede cambiar la suscripcion, no hay credito"); }
        } else if (unModo.getInt() == 2) {
            System.out.println("Ya estabas en modo Normal... Te recomendamos un oculista");
            System.out.println("Dr. Lucas Giorgio                                  Tel. 4855-4821");
        } else {
            return new SinSuscripcion();
        }
        return unModo;
    }

    @Override
    public void votarPelicula(String nombrePeli, int nota, Usuario user) {
        Pelicula peli = new Pelicula();
        peli.darNombreYnota(nombrePeli,nota);
        user.agregarVotadas(peli);

    }
    @Override
    public int getInt(){return modo;}


}
