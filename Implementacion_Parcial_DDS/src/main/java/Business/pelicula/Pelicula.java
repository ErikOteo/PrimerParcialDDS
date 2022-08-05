package Business.pelicula;

import persistencia.Conexion;
import persistencia.pelicula.PeliculaDAO;

import java.util.Date;

public class Pelicula {
    private int id;
    private String nombre;
    private String actores;
    private Date estreno;

    public Pelicula(){}

    public Pelicula(String nombre, String actores, Date estreno){
        this.nombre = nombre;
        this.actores = actores;
        this.estreno = estreno;

        PeliculaDAO peliculaDAO = new PeliculaDAO(Conexion.getInstance().getConnection());
        this.id = peliculaDAO.insert(nombre,actores,estreno);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public void setEstreno(Date estreno) {
        this.estreno = estreno;
    }

    public int getId() {
        return id;
    }
}
