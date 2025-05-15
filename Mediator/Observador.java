package Mediator;

//Interface que van a implementar los objetos que serán notificados cuando un pedido este listo
public interface Observador {
    void actualizar(int idPedido, String estado);
}
