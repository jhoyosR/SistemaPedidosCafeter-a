package Mediator;

interface Mediator {
    void enviar(String mensaje, Colaborador emisor);
    void registrarColaborador(Colaborador colaborador);
    void crearPedido(String detalle, Barista barista);
    void prepararPedido(int idPedido);
    void pedidoListo(int idPedido, Repartidor repartidor);
    void entregarPedido(int idPedido);
    void cancelarPedido(int idPedido);
    void deshacerUltimaAccion(int idPedido);
}
