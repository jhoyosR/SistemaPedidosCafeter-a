package State;
public class EnEsperaState implements EstadoPedido {
    @Override
    public void siguiente(Pedido pedido) {
        pedido.setEstado(new EnPreparacionState());
    }

    @Override
    public void anterior(Pedido pedido) {
        System.out.println("El pedido ya está en el estado inicial.");
    }

    @Override
    public void mostrarEstado() {
        System.out.println("Pedido en espera.");
    }
}
