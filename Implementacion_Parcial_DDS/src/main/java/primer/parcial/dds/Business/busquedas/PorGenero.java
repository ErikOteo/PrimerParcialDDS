package primer.parcial.dds.Business.busquedas;

import primer.parcial.dds.Business.canciones.ListaCanciones;
import primer.parcial.dds.Services.ServicioApiCancion;

import java.io.IOException;
import java.util.Scanner;

public class PorGenero extends Busqueda {

    public static void realizarBusqueda() throws IOException {
        Scanner scn = new Scanner(System.in);
        ServicioApiCancion miApi = ServicioApiCancion.getInstancia();
        miApi.mostrarGeneros();
        System.out.println("Ingrese Un Genero segun ID");
        Integer miGenero = scn.nextInt();
        ListaCanciones miLista = miApi.obtenerCancionesPorGenero(miGenero);

    }
}
