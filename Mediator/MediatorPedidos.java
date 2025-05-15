package Mediator;

import Observerr.Observador;
import java.util.ArrayList;
import java.util.List;
 
public class MediatorPedidos implements Mediator {
    private List<Colaborador> colaboradores = new ArrayList<>();
    private List<Observador> observadores = new ArrayList<>();

    @Override
    public void enviar(String mensaje, Colaborador emisor) {
        for (Colaborador c : colaboradores) {
            if (c != emisor) {
                c.recibirMensaje(mensaje);
            }
        }

        // Aquí notificamos a los observadores si el mensaje es que el pedido está listo
        if ("Listo".equalsIgnoreCase(mensaje)) {
            notificarObservadores();
        }
    }

    @Override
    public void registrarColaborador(Colaborador colaborador) {
        colaboradores.add(colaborador);
    }

    // Métodos para manejar observadores
    public void agregarObservador(Observador o) {
        observadores.add(o);
    }

    public void quitarObservador(Observador o) {
        observadores.remove(o);
    }

    private void notificarObservadores() {
        for (Observador o : observadores) {
            o.actualizar("Listo");
        }
    }
}
