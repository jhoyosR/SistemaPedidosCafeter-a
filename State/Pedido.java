package State;
public class Pedido {
    private EstadoPedido estado;

    public Pedido() {
        this.estado = new EnEsperaState(); // Estado inicial
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public void siguienteEstado() {
        estado.siguiente(this);
    }

    public void anteriorEstado() {
        estado.anterior(this);
    }

    public void mostrarEstado() {
        estado.mostrarEstado();
    }
}

