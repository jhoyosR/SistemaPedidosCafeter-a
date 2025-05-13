package Memento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {
     private final List<MementoPedido> historial = new ArrayList<>();

    public void guardarEstado(MementoPedido memento) {
        historial.add(memento);
    }

    public MementoPedido getUltimoEstado() {
        if (historial.isEmpty()) {
            return null;
        }
        return historial.remove(historial.size() - 1);
    }

    public boolean hayEstados() {
        return !historial.isEmpty();
    }
    
}
