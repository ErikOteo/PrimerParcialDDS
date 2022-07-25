package primer.parcial.dds.Services;

import primer.parcial.dds.Business.busquedas.Generos;
import primer.parcial.dds.Business.canciones.ListaCanciones;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiCancion {

        @GET("movie/top_rated")
        Call<ListaCanciones> listaCanciones(@Query("language") String idiomaRespuesta, @Query("page") Integer pagina, @Query("include_adult") boolean paraAdultos, @Query("region") String region, @Query("api_key") String apiKey);

        @GET("genre/movie/list")
        Call<Generos> listGeneros(@Query("language") String idiomaRespuesta, @Query("api_key") String apiKey);


        @GET("discover/movie")
        Call<ListaCanciones> CancionesConGenero(@Query("language") String idiomaRespuesta, @Query("api_key") String apiKey, @Query("with_genres") Integer generos);



    }


