package primer.parcial.dds.Repository;

public class UsuarioMapper {
    private String nombre;
    private String contrasenia;
    private int credito;
    private int suscripcion;

    public UsuarioMapper(String nombre, String contrasenia,int suscrip, int credito) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.credito = credito;
        this.suscripcion = suscrip;
    }

//    public int insert() {
//        UsuarioDAO personaDAO = new UsuarioDAO();
//        return personaDAO.insert(this.nombre, this.contrasenia, this.suscripcion, this.credito);
//    }
}
