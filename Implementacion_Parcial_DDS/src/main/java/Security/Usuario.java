package Security;

public abstract class Usuario {
    private String nombreUsuario;
    private String constrasenia;

    public Boolean iniciarSesion(String nombreUsuario,String constrasenia)
    {
        return this.constrasenia.equals(constrasenia) && this.nombreUsuario.equals(nombreUsuario);
    }
    public String getNombreUsuario(){return  this.nombreUsuario;}
    public String getConstrasenia(){return  this.constrasenia;}
    public void setNombreUsuario(String nombreUsuario){this.nombreUsuario = nombreUsuario;}
    public void setConstrasenia(String contrasenia){this.constrasenia = contrasenia;}
}
