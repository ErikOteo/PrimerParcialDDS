package Business.pelicula;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PeliculaAdapter {
    private List<Integer> genre_ids;
    private int id;
    private String release_date;
    private String title;
    private List<String> actores;
    private Pelicula pelicula = null;

    public Pelicula getPelicula(){
        if(pelicula == null)
            pelicula = new Pelicula(title, this.getActoresAsString(), this.getEstrenoAsDate());
        return pelicula;
    }

    public int getId() {
        return id;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setActores(List<String> actores){
        this.actores = actores;
    }

    private Date getEstrenoAsDate() {
        Date estreno;
        try{
            estreno = new SimpleDateFormat("yyyy-MM-dd").parse(release_date);
        }catch (ParseException e){
            estreno = new Date();
        }
        return estreno;
    }

    private String getActoresAsString(){
        return String.join(", ", actores);
    }
}