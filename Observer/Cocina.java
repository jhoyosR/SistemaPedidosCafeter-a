
public class Cocina implements Observador {
    @Override
    public void actualizar(String estado) {
        if ("Listo".equals(estado)) {
            System.out.println("El pedido está listo. Preparar entrega.");
        }
    }
}
