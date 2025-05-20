package Mediator;

class Barista implements Colaborador {
    private Mediator mediator;
    private String nombre;

    public Barista(String nombre, Mediator mediator) {
        this.nombre = nombre;
        this.mediator = mediator;
    }

    @Override
    public void recibirMensaje(String mensaje) {
        System.out.println("Barista " + nombre + " recibió: " + mensaje);
    }

    @Override
    public void enviarMensaje(String mensaje) {
        System.out.println("Barista " + nombre + " envía: " + mensaje);
        mediator.enviar(mensaje, this);
    }
    
    public void prepararPedido(int idPedido) {
        System.out.println("Barista " + nombre + " comienza a preparar el pedido #" + idPedido);
        mediator.prepararPedido(idPedido);
    }
    
    public void finalizarPedido(int idPedido, Repartidor repartidor) {
        System.out.println("Barista " + nombre + " ha finalizado el pedido #" + idPedido);
        mediator.pedidoListo(idPedido, repartidor);
    }
}
