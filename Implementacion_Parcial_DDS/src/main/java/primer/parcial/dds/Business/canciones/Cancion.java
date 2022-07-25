package primer.parcial.dds.Business.canciones;

import java.util.List;

public class Cancion extends CancionAEscuchar{

    public String backdrop_path;
    public List<Integer> generos_ids;
    public int id;
    public String titulo;
    public String overview;
    public Double popularity;
    public String fecha_publicacion;

    public boolean video;
    public Double vote_average;
    public int vote_count;
    public int nota;

    public Cancion Cancion(){
        return new Cancion();
    }

    public void mostrarTituloCancion() {
        System.out.printf("Titulo %s %n  es %s %n", titulo);
    }

    public void darNombreYnota(String nombreCancion,int nota1) {
        this.titulo = nombreCancion;
        this.nota = nota1;
    }

    public void mostrarCancion() {
        System.out.println("El nombre de la Cancion es: " + titulo);
        System.out.println("La calificacion otorgada es: " + nota);
        System.out.println("------------------------------------------------------");
    }


    @Override
    public boolean tieneElNombre(String unNombre) {
        return titulo.equals(unNombre);
    }

    @Override
    public void mostrarCancionAEscuchar() {
        System.out.println("El nombre de la Cancion es: " + titulo);
        System.out.println("------------------------------------------------------");
    }

    public void darNombre(String nombreCancion) {
        this.titulo= nombreCancion;
    }
}
