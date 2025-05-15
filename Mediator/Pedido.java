package Mediator;

import java.util.ArrayList;
import java.util.List;

class Pedido {
    private int id;
    private EstadoPedido estado;
    private List<Observador> observadores = new ArrayList<>();
    private Caretaker caretaker = new Caretaker();
    private String detalle;

    public Pedido(int id, String detalle) {
        this.id = id;
        this.detalle = detalle;
        this.estado = new EnEsperaState(); // Estado inicial
    }

    public void setEstado(EstadoPedido estado) {
        // Guardar estado anterior
        guardarEstado();
        
        this.estado = estado;
        notificarObservadores();
    }
    
    public int getId() {
        return id;
    }
    
    public String getDetalle() {
        return detalle;
    }

    public void siguienteEstado() {
        estado.siguiente(this);
    }

    public void anteriorEstado() {
        estado.anterior(this);
    }
    
    public String getEstadoNombre() {
        return estado.getNombre();
    }
    
    public void agregarObservador(Observador o) {
        observadores.add(o);
        // Notificar al nuevo observador del estado actual
        o.actualizar(id, estado.getNombre());
    }

    public void quitarObservador(Observador o) {
        observadores.remove(o);
    }
    
    private void notificarObservadores() {
        for (Observador o : observadores) {
            o.actualizar(id, estado.getNombre());
        }
    }
    
    public void guardarEstado() {
        caretaker.guardarEstado(new MementoPedido(estado, detalle));
    }
    
    public void restaurarEstado() {
        MementoPedido memento = caretaker.getUltimoEstado();
        if (memento != null) {
            // No llamamos a setEstado para evitar guardar un nuevo memento
            this.estado = memento.getEstado();
            this.detalle = memento.getDetalle();
            notificarObservadores();
            System.out.println("Estado restaurado a: " + estado.getNombre());
        } else {
            System.out.println("No hay estados previos para restaurar");
        }
    }
}
