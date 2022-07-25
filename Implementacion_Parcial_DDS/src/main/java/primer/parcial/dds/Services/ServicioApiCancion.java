package primer.parcial.dds.Services;

import primer.parcial.dds.Business.busquedas.Generos;
import primer.parcial.dds.Business.canciones.ListaCanciones;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class ServicioApiCancion {
    private static String apiKey = "2a28ead8355bebf7699f1a5084b2208a";
    private static ServicioApiCancion instancia = null;
    private Retrofit retrofit;
    private static final String urlApi = "https://api.themoviedb.org/3/";
    private ServicioApiCancion() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(urlApi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ServicioApiCancion getInstancia() {
        if (instancia == null) {
            instancia = new ServicioApiCancion();
        }
        return instancia;
    }

    public ListaCanciones obtenerPaginaDeCanciones(int paginaPedida) throws IOException {
        ApiCancion ApiCancion = this.retrofit.create(ApiCancion.class);
        Call<ListaCanciones> solicitarListaCanciones = ApiCancion.listaCanciones("es", paginaPedida, true, "AR", apiKey);
        Response<ListaCanciones> respuestaCanciones = solicitarListaCanciones.execute();
        return respuestaCanciones.body();
    }

    public int cuantasPaginasHay() throws IOException{
        ListaCanciones listaParaObtenercantPaginas = this.obtenerPaginaDeCanciones(1);
        return listaParaObtenercantPaginas.ultimaPagina();
    }

    public void mostrarGeneros()  throws IOException{
        ApiCancion ApiCancion = this.retrofit.create(ApiCancion.class);
        Call<Generos> listGeneros = ApiCancion.listGeneros("es", apiKey);
        Response<Generos> respuestaGeneros = listGeneros.execute();
        Generos generosObj = respuestaGeneros.body();
        for(int i=0; i<19;i++){
            (generosObj.genres[i]).mostrarGenero();
        }
    }

    public ListaCanciones obtenerCancionesPorGenero(Integer miGenero) throws IOException{
        ApiCancion ApiCancion = this.retrofit.create(ApiCancion.class);
        Call<ListaCanciones> ListaCanciones = ApiCancion.CancionesConGenero("es", apiKey, miGenero);
        Response<ListaCanciones> respuestaCanciones = ListaCanciones.execute();
        ListaCanciones Canciones = respuestaCanciones.body();
        return Canciones;
    }
}
