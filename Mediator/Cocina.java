package Mediator;

class Cocina implements Observador {
    @Override
    public void actualizar(int idPedido, String estado) {
        switch(estado) {
            case "En espera":
                System.out.println("Cocina: Nuevo pedido #" + idPedido + " en espera");
                break;
            case "En preparación":
                System.out.println("Cocina: El pedido #" + idPedido + " está en preparación");
                break;
            case "Listo":
                System.out.println("Cocina: El pedido #" + idPedido + " está listo. Preparar entrega.");
                break;
            default:
                break;
        }
    }
}
