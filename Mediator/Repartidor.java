package Mediator;

class Repartidor implements Colaborador {
    private Mediator mediator;
    private String nombre;

    public Repartidor(String nombre, Mediator mediator) {
        this.nombre = nombre;
        this.mediator = mediator;
    }

    @Override
    public void recibirMensaje(String mensaje) {
        System.out.println("Repartidor " + nombre + " recibió: " + mensaje);
    }

    @Override
    public void enviarMensaje(String mensaje) {
        System.out.println("Repartidor " + nombre + " envía: " + mensaje);
        mediator.enviar(mensaje, this);
    }
    
    public void entregarPedido(int idPedido) {
        System.out.println("Repartidor " + nombre + " entrega el pedido #" + idPedido);
        mediator.entregarPedido(idPedido);
    }
}
