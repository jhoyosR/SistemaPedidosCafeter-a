package State;

public class EnPreparacionState implements EstadoPedido {
    @Override
    public void siguiente(Pedido pedido) {
        pedido.setEstado(new ListoState());
    }

    @Override
    public void anterior(Pedido pedido) {
        pedido.setEstado(new EnEsperaState());
    }

    @Override
    public void mostrarEstado() {
        System.out.println("Pedido en preparación.");
    }
}
