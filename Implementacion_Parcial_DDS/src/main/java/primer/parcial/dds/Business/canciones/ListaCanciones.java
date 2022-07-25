package primer.parcial.dds.Business.canciones;

public class ListaCanciones {
    int page;
    public Cancion[] results;
    int total_pages;



    public int ultimaPagina() {
        return total_pages;
    }
}
