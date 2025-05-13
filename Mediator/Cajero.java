package Mediator;

public class Cajero implements Colaborador {
    private Mediator mediator;

    public Cajero(Mediator mediator) {
        this.mediator = mediator;
        mediator.registrarColaborador(this);
    }

    @Override
    public void recibirMensaje(String mensaje) {
        System.out.println("Cajero recibió: " + mensaje);
    }

    @Override
    public void enviarMensaje(String mensaje) {
        System.out.println("Cajero envía: " + mensaje);
        mediator.enviar(mensaje, this);
    }
}
