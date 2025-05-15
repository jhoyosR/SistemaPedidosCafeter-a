package Mediator;

class ListoState implements EstadoPedido {
    @Override
    public void siguiente(Pedido pedido) {
        pedido.setEstado(new EntregadoState());
    }

    @Override
    public void anterior(Pedido pedido) {
        pedido.setEstado(new EnPreparacionState());
    }
    
    @Override
    public String getNombre() {
        return "Listo";
    }
}

