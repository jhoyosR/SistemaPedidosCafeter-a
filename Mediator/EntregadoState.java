package Mediator;

class EntregadoState implements EstadoPedido {
    @Override
    public void siguiente(Pedido pedido) {
        System.out.println("El pedido ya fue entregado. No puede avanzar.");
    }

    @Override
    public void anterior(Pedido pedido) {
        pedido.setEstado(new ListoState());
    }
    
    @Override
    public String getNombre() {
        return "Entregado";
    }
}
