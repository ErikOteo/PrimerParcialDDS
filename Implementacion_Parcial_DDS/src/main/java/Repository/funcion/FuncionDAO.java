package Repository.funcion;

import negocio.Cine.Dia;
import negocio.pelicula.Pelicula;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FuncionDAO {
    private final Connection conn;

    public FuncionDAO(Connection connection){
        this.conn = connection;
    }

    public int insert(int numeroSala, int asientosLibres, int asientosTotales, int precioGeneral, Dia dia, Date fechaFuncion, Pelicula pelicula) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaFuncionMySql = sdf.format(fechaFuncion);

        String consulta = "INSERT INTO funcion (numero_sala, asientos_libres, asientos_totales, dia, fecha_funcion, precio_general,id_pelicula) " +
                "VALUES (" + numeroSala + "," + asientosLibres + "," + asientosTotales + "," + dia.ordinal() + ",'" + fechaFuncionMySql + "'," + precioGeneral + "," + pelicula.getId() + ");";

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
