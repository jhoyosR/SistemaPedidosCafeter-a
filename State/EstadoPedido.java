package State;

public interface EstadoPedido {
    void siguiente(Pedido pedido);
    void anterior(Pedido pedido);
    void mostrarEstado();
}
