package primer.parcial.dds.Business.canciones;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaqueteCanciones extends CancionAEscuchar {
    List<CancionAEscuchar> paquete = new ArrayList<>();
    public void agregarCancion(Cancion unaCancion) {
        paquete.add(unaCancion);
    }

    @Override
    public void mostrarCancionAEscuchar() {
        for (CancionAEscuchar p : paquete) {
            p.mostrarCancionAEscuchar();
        }
    }

    @Override
    public boolean tieneElNombre(String unNombre) {
        return paquete.stream().anyMatch(CancionAEscuchar -> CancionAEscuchar.tieneElNombre(unNombre));
    }

    public void agregarAlgo() throws IOException {
        Scanner can = new Scanner(System.in);
        boolean noTermine = true;
        System.out.println("1. Agregar cancion a paquete");
        System.out.println("2. Agregar paquete a paquete");

        int cant = can.nextInt();
        while(noTermine) {
            if (cant == 1) {
                //paquete.add(TopGlobal.obtenerCancion());
                noTermine = false;
            } else if (cant == 2) {
                PaqueteCanciones unPaquete = new PaqueteCanciones();
                unPaquete.crearNuevo();
                paquete.add(unPaquete);
                noTermine = false;
            } else {
                System.out.println("Te equivocaste, solo podes poner 1 o 2!");
                System.out.println("1. Agregar Cancion a paquete");
                System.out.println("2. Agregar paquete a paquete");
            }
        }
    }



    public void crearNuevo() throws IOException {
        Scanner can = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de elementos que desea en el paquete");
        int cant = can.nextInt();
        for(int i = 0; i < cant; i ++) {
            this.agregarAlgo();
        }
    }
}
