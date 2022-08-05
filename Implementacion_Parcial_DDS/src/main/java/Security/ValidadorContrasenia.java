package Security;

import negocio.Cine.Cine;

public class ValidadorContrasenia {
    public  Boolean validarContrasenia(String contrasenia){
        Cine cine = Cine.getInstance();
        return  cine.getContrasenias().contains(contrasenia);
    }
    public  String contraseniaAleatoria(String contrasenia)
    {
        return  contrasenia + contrasenia + "Nueva";
    }
}
