package primer.parcial.dds.Security.sistema;

import primer.parcial.dds.Business.busquedas.PorGenero;
import primer.parcial.dds.Business.busquedas.TopGlobal;
import primer.parcial.dds.Business.canciones.PaqueteCanciones;
import primer.parcial.dds.Business.suscripciones.Normal;
import primer.parcial.dds.Business.suscripciones.Premium;
import primer.parcial.dds.Business.suscripciones.SinSuscripcion;
import primer.parcial.dds.Business.suscripciones.Suscripcion;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuInicio {

    Usuario usuarioConsumidor;
    boolean sesionIniciada = false;
    public void iniciarMenu() throws IOException {

        Scanner sn = new Scanner(System.in);
        Scanner str = new Scanner(System.in);

        boolean salir = false;
        int opcion; // Se guarda la opcion del usuarioConsumidor
        Suscripcion modoSuscripcion;
        Sistema sistema= Sistema.getInstancia();
        //sistema.cargarUsuarios();
        while (!salir) {

            System.out.println("1. Buscar");
            System.out.println("2. Crear usuarioConsumidor");
            System.out.println("3. Iniciar Sesion");
            System.out.println("4. Calificar Cancion");
            System.out.println("5. Obtener Canciones Calificadas");
            System.out.println("6. Agregar Cancioncula Vista");
            System.out.println("7. Obtener Canciones Reproducidas");
            System.out.println("8. Obtener Paquete de Canciones al azar");
            System.out.println("9. Cambiar Suscripcion");
            System.out.println("0. Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        if (sesionIniciada) {
                            System.out.println("Has seleccionado Buscar");
                            System.out.println("Seleccione el metodo de busqueda");
                            System.out.println("1. Top global");
                            System.out.println("2. Por genero");
                            opcion = sn.nextInt();
                            this.busquedaPor(opcion);

                        }else{
                            System.out.println("Seleccione la opcion 3 para iniciar sesion y vuelva a intentarlo");
                        }
                        break;
                    case 2:
                        System.out.println("Has seleccionado Crear usuarioConsumidor");
                        System.out.println("Ingrese usuarioConsumidor");
                        String usuarioConsumidorProvisorio = str.nextLine();
                        while (sistema.usuarioNoValido(usuarioConsumidorProvisorio)) {
                            System.out.println("Nombre de usuarioConsumidor no valido, vuelva a intentarlo");
                            usuarioConsumidorProvisorio = str.nextLine();
                        }
                        System.out.println("Ingrese Contrasena");
                        String contrasenaProvisoria = str.nextLine();
                        while (sistema.contrasenaNoValida(contrasenaProvisoria)) {
                            System.out.println("Contrasena no valida, vuelva a intentarlo");
                            contrasenaProvisoria = str.nextLine();
                        }
                        modoSuscripcion = this.menuSuscripcion();
                       Usuario usuario = new Usuario(usuarioConsumidorProvisorio, contrasenaProvisoria, modoSuscripcion);
                        sistema.agregarUsuario(usuarioConsumidor);
                        usuarioConsumidor=usuario;
                        sesionIniciada=true;

                        break;
                    case 3:
                        System.out.println("Has seleccionado Iniciar Sesion");
                        while (!sesionIniciada) {
                            System.out.println("Ingrese usuarioConsumidor");
                            usuarioConsumidorProvisorio = str.nextLine();
                            System.out.println("Ingrese contrasena");
                            contrasenaProvisoria = str.nextLine();
                            if (sistema.validarIngreso(usuarioConsumidorProvisorio, contrasenaProvisoria)) {
                              
                                usuarioConsumidor = sistema.otorgarUsuario(usuarioConsumidorProvisorio);
                                sesionIniciada = true;
                            }
                        }

                        break;
                    case 4:
                        System.out.println("Ingrese el nombre de la Cancion que desea votar ");
                        String nombreCancion = str.nextLine();
                        int nota = sn.nextInt();
                        usuarioConsumidor.miSuscripcion().votarPelicula(nombreCancion,nota,usuarioConsumidor);
                        break;
                    case 5:
                        usuarioConsumidor.mostrarCancionesCalificadas();
                        break;
                    case 6:
                        System.out.println("Ingrese el nombre de la Cancioncula que vio ");
                        String nombreCancionVista = str.nextLine();
                        usuarioConsumidor.miSuscripcion().agregarVista(nombreCancionVista,usuarioConsumidor);
                        break;
                    case 7:
                        usuarioConsumidor.mostrarCancionesReproducidas();
                        break;
                    case 8:
                        PaqueteCanciones miPaquete = new PaqueteCanciones();
                        miPaquete.crearNuevo();
                        usuarioConsumidor.todoLoEscuchado.add(miPaquete);
                        break;
                    case 9:
                        Suscripcion unaSus = this.menuSuscripcion();
                        usuarioConsumidor.cambiarEstado(unaSus);
                        break;
//                    case 10:
//                        List<Usuario> usuarioConsumidors = null;
//                        usuarioConsumidors = usuarioConsumidorsDAO.listaDeusuarioConsumidors();
//                        for(usuarioConsumidor u : usuarioConsumidors) {
//                            u.mostrar();
//                        }
//                        break;
                    case 0:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 0 y 9");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

    }

    private void busquedaPor(int opcion) throws IOException{
        Scanner scn = new Scanner(System.in);
        if(opcion >=1 && opcion <=3) {
            try {
                switch (opcion) {
                    case 1:
                        TopGlobal.realizarBusqueda();
                        break;
                    case 2:
                        PorGenero.realizarBusqueda();
                        break;
                    case 3:

                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                scn.next();
            }
        }
    }

    private Suscripcion menuSuscripcion() {
        Scanner scn = new Scanner(System.in);
        int elegido;
        boolean noTermine = true;
        Suscripcion devolver = new SinSuscripcion();

        while(noTermine) {
            System.out.println("Ingrese tipo de suscripcion");
            System.out.println("1. No deseo tener suscripcion");
            System.out.println("2. Deseo suscripcion NORMAL");
            System.out.println("3. Deseo suscripcion PREMIUM");
            try {
                System.out.println("Escribe una de las opciones");
                elegido = scn.nextInt();
                switch (elegido) {
                    case 1:
                        devolver = new SinSuscripcion();
                        noTermine = false;
                        break;
                    case 2:
                        devolver = new Normal();
                        noTermine = false;
                        break;
                    case 3:
                        devolver = new Premium();
                        noTermine = false;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                scn.next();
            }
        }
        return devolver;
    }
}
