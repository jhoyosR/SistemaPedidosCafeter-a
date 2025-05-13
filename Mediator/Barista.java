package Mediator;

public class Barista implements Colaborador {
    private Mediator mediator;

    public Barista(Mediator mediator) {
        this.mediator = mediator;
        mediator.registrarColaborador(this);
    }

    @Override
    public void recibirMensaje(String mensaje) {
        System.out.println("Barista recibió: " + mensaje);
    }

    @Override
    public void enviarMensaje(String mensaje) {
        System.out.println("Barista envía: " + mensaje);
        mediator.enviar(mensaje, this);
    }
}
