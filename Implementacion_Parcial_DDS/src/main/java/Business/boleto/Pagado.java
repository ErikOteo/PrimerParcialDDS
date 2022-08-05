package Business.boleto;

public class Pagado extends EstadoBoleto {
   private int descuentProductos;
   public void aplicarDescuento(int descuento)
   {
       this.descuentProductos= descuento;
   }
}
