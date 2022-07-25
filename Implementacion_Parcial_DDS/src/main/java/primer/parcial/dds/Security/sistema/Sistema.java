package primer.parcial.dds.Security.sistema;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private static List<Usuario> listaUsuarios = new ArrayList<>();

    private static Sistema instancia = null;

    public static Sistema getInstancia() {
        if (instancia == null) {
            instancia = new Sistema();
        }
        return instancia;
    }

    public static boolean usuarioNoValido(String usuarioProvisorio) {
        if (listaUsuarios.stream().anyMatch(usuario -> usuario.getNombre().equals(usuarioProvisorio))){
            return true;}
        else{
            return false;
        }
    }

    public static boolean contrasenaNoValida(String contrasenaProvisoria) {
        if (contrasenaProvisoria.length() >= 8){
            return false;
        }else{
            return true;
        }

    }

    public Usuario otorgarUsuario(String usuarioProvisorio) {
        int index=0;
        for (Usuario u : listaUsuarios) {
            if (u.getNombre().equals(usuarioProvisorio)){
                return listaUsuarios.get(index);
            }else{index= index + 1 ; }
        }
        return listaUsuarios.get(index);
    }


    public void agregarUsuario(Usuario miUsuario) {
        listaUsuarios.add(miUsuario);
    }


    public boolean validarIngreso(String usuarioProvisorio, String contrasenaProvisoria) {
        if (listaUsuarios.stream().anyMatch(usuario -> usuario.getNombre().equals(usuarioProvisorio) && usuario.getContra().equals(contrasenaProvisoria))){
            return true;}
        else{
            if(listaUsuarios.stream().anyMatch(usuario -> usuario.getNombre().equals(usuarioProvisorio))){
                System.out.println("Contraseña invalida, vuelva a intentarlo");
            }else{
                System.out.println("Usuario invalido, vuelva a intentarlo");
            }
            return false;
        }

    }

//    public void cargarUsuarios() {
//        listaUsuarios = UsuariosDAO.listaDeUsuarios();
//    }
}
