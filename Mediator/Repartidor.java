package Mediator;

public class Repartidor implements Colaborador {
    private Mediator mediator;

    public Repartidor(Mediator mediator) {
        this.mediator = mediator;
        mediator.registrarColaborador(this);
    }

    @Override
    public void recibirMensaje(String mensaje) {
        System.out.println("Repartidor recibió: " + mensaje);
    }

    @Override
    public void enviarMensaje(String mensaje) {
        System.out.println("Repartidor envía: " + mensaje);
        mediator.enviar(mensaje, this);
    }
}
