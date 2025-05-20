package Mediator;

class Cliente implements Observador {
    private String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(int idPedido, String estado) {
        switch (estado) {
            case "En preparación":
                System.out.println("Cliente " + nombre + ": ¡Tu pedido #" + idPedido + " está siendo preparado!");
                break;
            case "Listo":
                System.out.println("Cliente " + nombre + ": ¡Tu pedido #" + idPedido + " está listo!");
                break;
            case "Entregado":
                System.out.println("Cliente " + nombre + ": ¡Tu pedido #" + idPedido + " ha sido entregado!");
                break;
        
            default:
                break;
        }

        
        // if ("Listo".equals(estado)) {
        //     System.out.println("Cliente " + nombre + ": ¡Tu pedido #" + idPedido + " está listo!");
        // } else if ("Entregado".equals(estado)) {
        //     System.out.println("Cliente " + nombre + ": ¡Tu pedido #" + idPedido + " ha sido entregado!");
        // }
    }
    
    @Override
    public String toString() {
        return "Cliente " + nombre;
    }
}

