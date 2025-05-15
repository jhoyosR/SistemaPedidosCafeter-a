package Mediator;

class Cliente implements Observador {
    private String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(int idPedido, String estado) {
        if ("Listo".equals(estado)) {
            System.out.println("Cliente " + nombre + ": ¡Tu pedido #" + idPedido + " está listo!");
        } else if ("Entregado".equals(estado)) {
            System.out.println("Cliente " + nombre + ": ¡Tu pedido #" + idPedido + " ha sido entregado!");
        }
    }
    
    @Override
    public String toString() {
        return "Cliente " + nombre;
    }
}

