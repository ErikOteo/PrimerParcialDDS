package Business.pelicula;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServicioPeliculas {
    private static ServicioPeliculas instancia = null;
    private static final String urlAPI = "https://api.themoviedb.org/3/";
    private static final String apiKey = "e13b1ea5ee4e10a0abe44e409721a9f6";
    private Retrofit retrofit;

    private ServicioPeliculas() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(urlAPI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ServicioPeliculas getInstancia() {
        if(instancia == null) {
            instancia = new ServicioPeliculas();
        }
        return instancia;
    }

    public List<Pelicula> getPeliculasEnCartelera() throws IOException {
        List<Pelicula> peliculas = new ArrayList<>();

        PeliculasServices peliculasServices = this.retrofit.create(PeliculasServices.class);
        Call<ListadoDePeliculas> requestPeliculas = peliculasServices.enCartelera(apiKey,String.valueOf(1),"AR");
        Response<ListadoDePeliculas> responsePeliculas = requestPeliculas.execute();
        List<PeliculaAdapter> peliculasAdapter = new ArrayList<>();
        if(responsePeliculas.body() != null)
            peliculasAdapter = responsePeliculas.body().getResults();

        // Obtener lista de actores
        peliculasAdapter.forEach(peliculaAdapter -> peliculaAdapter.setActores(this.getActoresPorPelicula(peliculaAdapter.getId())));

        peliculas = responsePeliculas.body().getResults().stream().map(PeliculaAdapter::getPelicula).collect(Collectors.toList());
        return peliculas;
    }

    private List<String> getActoresPorPelicula(int idPelicula){
        PeliculasServices peliculasServices = this.retrofit.create(PeliculasServices.class);
        Call<JsonObject> requestActores = peliculasServices.actoresPorPelicula(String.valueOf(idPelicula),apiKey);
        Response<JsonObject> responseActores = null;
        try {
            responseActores = requestActores.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> actores = new ArrayList<>();

        try{
            JsonArray jsonArrayActores = responseActores.body().getAsJsonArray("cast");
            jsonArrayActores.forEach(jsonElement -> actores.add(jsonElement.getAsJsonObject().get("name").getAsString()));
        } catch (NullPointerException e){
            return actores;
        }
        return actores;
    }
}
