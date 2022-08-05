package Repository.funcion;

import negocio.Cine.Dia;
import negocio.Cine.Funcion;
import persistencia.pelicula.PeliculasDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FuncionesDAO {
    private Connection conn;

    public FuncionesDAO(Connection connection){
        this.conn = connection;
    }

    public List<Funcion> selectAll(){
        try {
            // generacion de query
            String consulta = "SELECT * FROM funcion;";

            // Ejecucion
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            PeliculasDAO peliculasDAO = new PeliculasDAO(conn);

            // Recorrer y usar cada linea retornada
            List<Funcion> funciones = new ArrayList<>();

            while (rs.next()) {
                Funcion obj = new Funcion();

                obj.setNumeroSala(rs.getInt("numero_sala"));
                obj.setAsientosLibres(rs.getInt("asientos_libres"));
                obj.setAsientosTotales(rs.getInt("asientos_totales"));
                obj.setDia(Dia.values()[rs.getInt("dia")]);
                obj.setFechaFuncion(rs.getDate("fecha_funcion"));
                obj.setPrecioGeneral(rs.getInt("precio_general"));
                obj.setPelicula(peliculasDAO.select(rs.getInt("id_pelicula")));
                funciones.add(obj);
            }
            return funciones;
        } catch (SQLException ex) {
            System.out.println("Error en Select");
            return null;
        }
    }

    public Funcion select(int idFuncion){
        try {
            // generacion de query
            String consulta = "SELECT * FROM funcion where id =" + idFuncion + ";";

            // Ejecucion
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            PeliculasDAO peliculasDAO = new PeliculasDAO(conn);

            Funcion obj = new Funcion();

            while (rs.next()) {
                obj.setNumeroSala(rs.getInt("numero_sala"));
                obj.setAsientosLibres(rs.getInt("asientos_libres"));
                obj.setAsientosTotales(rs.getInt("asientos_totales"));
                obj.setDia(Dia.values()[rs.getInt("dia")]);
                obj.setFechaFuncion(rs.getDate("fecha_funcion"));
                obj.setPrecioGeneral(rs.getInt("precio_general"));
                obj.setPelicula(peliculasDAO.select(rs.getInt("id_pelicula")));
            }
            return obj;
        } catch (SQLException ex) {
            System.out.println("Error en Select");
            return null;
        }
    }
}
