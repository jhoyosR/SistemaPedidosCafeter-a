package Mediator;

public interface EstadoPedido {
    void siguiente(Pedido pedido);
    void anterior(Pedido pedido);
    String getNombre();
}
