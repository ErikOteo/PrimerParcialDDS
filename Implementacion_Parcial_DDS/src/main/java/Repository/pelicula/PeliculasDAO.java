package Repository.pelicula;

import negocio.pelicula.Pelicula;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PeliculasDAO {
    private Connection conn;

    public PeliculasDAO(Connection connection){
        this.conn = connection;
    }

    public List<Pelicula> selectAll(){
        try {
            // generacion de query
            String consulta = "SELECT * FROM pelicula;";

            // Ejecucion
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            // Recorrer y usar cada linea retornada
            List<Pelicula> peliculas = new ArrayList<>();

            while (rs.next()) {
                Pelicula obj = new Pelicula();

                obj.setNombre(rs.getString("nombre"));
                obj.setActores(rs.getString("actores"));
                obj.setEstreno(rs.getDate("estreno"));

                peliculas.add(obj);
            }
            return peliculas;
        } catch (SQLException ex) {
            System.out.println("Error en Select");
            return null;
        }
    }

    public Pelicula select(int idPelicula){
        try {
            // generacion de query
            String consulta = "SELECT * FROM pelicula where id = " + idPelicula + ";";

            // Ejecucion
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            Pelicula obj = new Pelicula();
            while (rs.next()) {

                obj.setNombre(rs.getString("nombre"));
                obj.setActores(rs.getString("actores"));
                obj.setEstreno(rs.getDate("estreno"));

            }
            return obj;
        } catch (SQLException ex) {
            System.out.println("Error en Select");
            return null;
        }
    }
}
