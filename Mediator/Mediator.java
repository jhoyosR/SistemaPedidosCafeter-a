package Mediator;

interface Mediator {
    void enviar(String mensaje, Colaborador emisor);
    void registrarColaborador(Colaborador colaborador);
    void crearPedido(String detalle);
    void prepararPedido(int idPedido);
    void pedidoListo(int idPedido);
    void entregarPedido(int idPedido);
    void cancelarPedido(int idPedido);
    void deshacerUltimaAccion(int idPedido);
}
