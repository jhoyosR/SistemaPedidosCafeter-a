package Mediator;

class Cajero implements Colaborador {
    private Mediator mediator;
    private String nombre;

    public Cajero(String nombre, Mediator mediator) {
        this.nombre = nombre;
        this.mediator = mediator;
        mediator.registrarColaborador(this);
    }

    @Override
    public void recibirMensaje(String mensaje) {
        System.out.println("Cajero " + nombre + " recibió: " + mensaje);
    }

    @Override
    public void enviarMensaje(String mensaje) {
        System.out.println("Cajero " + nombre + " envía: " + mensaje);
        mediator.enviar(mensaje, this);
    }
    
    public void tomarPedido(String detalle) {
        System.out.println("Cajero " + nombre + " toma un nuevo pedido: " + detalle);
        mediator.crearPedido(detalle);
    }
    
    public void cancelarPedido(int idPedido) {
        System.out.println("Cajero " + nombre + " cancela el pedido #" + idPedido);
        mediator.cancelarPedido(idPedido);
    }
}
