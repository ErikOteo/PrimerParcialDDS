package primer.parcial.dds.Security.sistema;

import primer.parcial.dds.Business.canciones.Cancion;
import primer.parcial.dds.Business.canciones.CancionAEscuchar;
import primer.parcial.dds.Business.suscripciones.Normal;
import primer.parcial.dds.Business.suscripciones.Premium;
import primer.parcial.dds.Business.suscripciones.SinSuscripcion;
import primer.parcial.dds.Business.suscripciones.Suscripcion;
import primer.parcial.dds.Repository.UsuarioDAO;
import primer.parcial.dds.Repository.UsuarioMapper;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    String nombre;
    String contrasenia;
    public Suscripcion miSuscripcion;
    List<Cancion> listaCalificadas = new ArrayList<>();
    List<CancionAEscuchar> todoLoEscuchado = new ArrayList<>();
    int credito=50;


    public Usuario(String usuario, String contrasenia, Suscripcion modo) {
        nombre = usuario;
        contrasenia = contrasenia;
        miSuscripcion = modo;

        UsuarioMapper oMapper = new UsuarioMapper (this.nombre, this.contrasenia, this.dameIntSusc(),this.credito);
       // oMapper.insert();
    }

    private int dameIntSusc() {
        return miSuscripcion.getInt();
    }

    public Usuario() {}


    public String getNombre() {
        return nombre;
    }
    public String getContra() {
        return contrasenia;
    }

    public void decimeQuienSoy() {
        System.out.println(nombre);
        System.out.println(contrasenia);
        return;
    }

    public void cambiarEstado(Suscripcion unModo) {
        miSuscripcion = miSuscripcion.cambiarModo(unModo, this);
       // UsuarioDAO.cambiarCreditoyModo(this);
    }

    public boolean restarCredito(int i) {

        if( credito >=i ){
            this.credito =credito-i;
            return true;
        }else{
            return false;
        }
    }

    public Suscripcion miSuscripcion() {
        return miSuscripcion;
    }

    public void agregarVotadas(Cancion cancion) {
        listaCalificadas.add(cancion);
    }

    public void agregarVistas(Cancion peli) {
        todoLoEscuchado.add(peli);
    }

    public boolean laEscucho(String nombreCancion) {

        return todoLoEscuchado.stream().anyMatch(algoPaVer -> algoPaVer.tieneElNombre(nombreCancion));
    }



    public void mostrarCancionesCalificadas() {
        for(Cancion p : listaCalificadas) {
            p.mostrarCancionAEscuchar();
        }
    }

    public void mostrarCancionesReproducidas() {
        for(CancionAEscuchar p : todoLoEscuchado) {
            p.mostrarCancionAEscuchar();
        }
    }

    public void setNombre(String n) {
        nombre =n;
    }

    public void setContrasena(String c) {
        contrasenia = c;
    }

    public void setPlata(int p) {
        credito = p;
    }
    public void mostrarUsuario() {
        System.out.println("nombre " + nombre);
        System.out.println("credito " + credito);
        System.out.println("---------------------------");
    }

    public void setSuscripcion(int s) {
        if(s == 1) {miSuscripcion = new SinSuscripcion();}
        else if (s == 2) {miSuscripcion = new Normal();}
        else {miSuscripcion = new Premium();}
    }

}
