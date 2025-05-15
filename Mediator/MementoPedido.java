package Mediator;

class MementoPedido {
    private final EstadoPedido estado;
    private final String detalle;

    public MementoPedido(EstadoPedido estado, String detalle) {
        this.estado = estado;
        this.detalle = detalle;
    }

    public EstadoPedido getEstado() {
        return estado;
    }
    
    public String getDetalle() {
        return detalle;
    }
}
