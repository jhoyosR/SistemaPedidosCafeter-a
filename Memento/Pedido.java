package Memento;

public class Pedido {
    private String estado;

    public Pedido() {
        this.estado = "En espera";
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public MementoPedido crearMemento() {
        return new MementoPedido(estado);
    }

    public void restaurar(MementoPedido memento) {
        if (memento != null) {
            this.estado = memento.getEstado();
        }
    }

    public void preparar() {
        setEstado("En preparación");
        System.out.println("Pedido en preparación");
    }

    public void listo() {
        setEstado("Listo");
        System.out.println("Pedido listo para recoger");
    }

    public void entregar() {
        setEstado("Entregado");
        System.out.println("Pedido entregado");
    }

    public void cancelar() {
        setEstado("Cancelado");
        System.out.println("Pedido cancelado");
    }
}
