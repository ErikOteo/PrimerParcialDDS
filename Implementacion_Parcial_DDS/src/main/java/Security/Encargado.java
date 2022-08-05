package Security;

import negocio.Cine.Dia;
import negocio.Cine.Funcion;
import negocio.pelicula.Pelicula;

import java.util.Date;

public class Encargado extends Usuario{
    public Funcion crearFunciones(int numeroSala, int asientosTotales, int precioGeneral, Dia dia, Date fechaFuncion, Pelicula pelicula)
    {
        Funcion funcionNueva = new Funcion(numeroSala,asientosTotales,asientosTotales,precioGeneral,dia,fechaFuncion,pelicula);
        return funcionNueva;
    }
    public Encargado(String nombreUsuario,String contrasenia)
    {
        ValidadorContrasenia validador = new ValidadorContrasenia();
        if(!validador.validarContrasenia(contrasenia))
        {
            contrasenia = validador.contraseniaAleatoria(contrasenia);
        }
        this.setNombreUsuario(nombreUsuario);
        this.setConstrasenia(contrasenia);
    }
}
