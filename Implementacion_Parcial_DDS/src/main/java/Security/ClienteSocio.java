package Security;

import negocio.Cine.Cine;

public class ClienteSocio extends Usuario{
    private int puntosAcumulados;
    public void realizarReclamo(String reclamo){
        Cine cine = Cine.getInstance();
        cine.getReclamos().add(reclamo);
    }
    public void setPuntosAcumulados(int puntos){this.puntosAcumulados = puntos;}
    public ClienteSocio(String nombreUsuario,String contrasenia)
    {
        ValidadorContrasenia validador = new ValidadorContrasenia();
        if(!validador.validarContrasenia(contrasenia))
        {
            contrasenia = validador.contraseniaAleatoria(contrasenia);
        }
        this.setNombreUsuario(nombreUsuario);
        this.setConstrasenia(contrasenia);
        this.setPuntosAcumulados(0);
    }
}
