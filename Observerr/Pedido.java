package Observerr;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    //Tiene una lista del tipo Observador, es decir, va a notificar a los objetos que implementen esta interface
    private List<Observador> observadores = new ArrayList<>();
    private String estado;

    public void agregarObservador(Observador o) {
        observadores.add(o);
    }

    public void quitarObservador(Observador o) {
        observadores.remove(o);
    }

    public void setEstado(String estado) {
        this.estado = estado;
        notificarObservadores();
    }

    public String getEstado() {
        return estado;
    }
//Es el único metodo privado para que solo cuando se cambie el estado se notifique a los observadores,
//se invoca automaticamente cuando el pedido cambie su estado
    private void notificarObservadores() {
        for (Observador o : observadores) {
            o.actualizar(estado);
        }
    }
}
