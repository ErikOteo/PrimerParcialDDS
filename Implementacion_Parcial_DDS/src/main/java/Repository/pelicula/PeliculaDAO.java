package Repository.pelicula;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PeliculaDAO {
    private final Connection conn;

    public PeliculaDAO(Connection connection){
        this.conn = connection;
    }

    public int insert(String nombre, String actores, Date estreno) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String estrenoMySql = sdf.format(estreno);

        String consulta = "INSERT INTO pelicula (nombre, actores, estreno) VALUES ('" + nombre + "','" + actores + "','" + estrenoMySql + "');";

        try {
            // Ejecucion
            PreparedStatement stmt = this.conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);

            // execute the preparedstatement
            stmt.executeUpdate();

            // obtener ultimo id generado
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next())
                return generatedKeys.getInt(1);
            else
                return 0;
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("Error en Insert");
            return 0;
        }
    }
}