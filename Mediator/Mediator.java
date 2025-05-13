package Mediator;

public interface Mediator {
    void enviar(String mensaje, Colaborador emisor);
    void registrarColaborador(Colaborador colaborador);
}
