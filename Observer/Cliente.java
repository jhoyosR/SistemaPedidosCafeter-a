
public class Cliente implements Observador {

    private String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(String estado) {
        if ("Listo".equals(estado)) {
            System.out.println("Cliente " + nombre + ": ¡Tu pedido está listo!");
        }
    }
}

