package primer.parcial.dds.Business.suscripciones;

public class Premium extends Suscripcion {
    public int modo=3;

    @Override
    public Suscripcion cambiarModo(Suscripcion unModo, Usuario unUsuario) {
        if(unModo.getInt() == 3) {
            System.out.println("Ya estabas en modo Premium... Te recomendamos un oculista");
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
    public void votarPelicula(String nombrePeli, int nota, Usuario user) {
        Pelicula peli = new Pelicula();
        peli.darNombreYnota(nombrePeli,nota);
        user.agregarVotadas(peli);
        if(!user.laVio(nombrePeli)){
        user.agregarVistas(peli);}
    }
    @Override
    public void agregarVista(String nombrePeli, Usuario yo) {
        Pelicula peli = new Pelicula();
        peli.darNombre(nombrePeli);
        yo.agregarVistas(peli);
    }

    @Override
    public int getInt(){return modo;}
}