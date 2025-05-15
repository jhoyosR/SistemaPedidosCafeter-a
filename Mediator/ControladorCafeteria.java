package Mediator;

import java.util.ArrayList;
import java.util.List;

class ControladorCafeteria implements Mediator {
    private List<Colaborador> colaboradores = new ArrayList<>();
    private List<Pedido> pedidos = new ArrayList<>();
    private int contadorPedidos = 0;
    private Cocina cocina = new Cocina();
    
    @Override
    public void enviar(String mensaje, Colaborador emisor) {
        for (Colaborador c : colaboradores) {
            if (c != emisor) {
                c.recibirMensaje(mensaje);
            }
        }
    }

    @Override
    public void registrarColaborador(Colaborador colaborador) {
        colaboradores.add(colaborador);
    }
    
    @Override
    public void crearPedido(String detalle) {
        contadorPedidos++;
        Pedido nuevoPedido = new Pedido(contadorPedidos, detalle);
        nuevoPedido.agregarObservador(cocina);
        pedidos.add(nuevoPedido);
        
        String mensaje = "Nuevo pedido #" + contadorPedidos + " creado: " + detalle;
        System.out.println(mensaje);
        notificarATodos(mensaje);
    }
    
    @Override
    public void prepararPedido(int idPedido) {
        Pedido pedido = buscarPedido(idPedido);
        if (pedido != null) {
            pedido.siguienteEstado();
            String mensaje = "Pedido #" + idPedido + " en preparación";
            notificarATodos(mensaje);
        }
    }
    
    @Override
    public void pedidoListo(int idPedido) {
        Pedido pedido = buscarPedido(idPedido);
        if (pedido != null) {
            pedido.siguienteEstado();
            String mensaje = "Pedido #" + idPedido + " está listo para entregar";
            notificarATodos(mensaje);
        }
    }
    
    @Override
    public void entregarPedido(int idPedido) {
        Pedido pedido = buscarPedido(idPedido);
        if (pedido != null) {
            pedido.siguienteEstado();
            String mensaje = "Pedido #" + idPedido + " ha sido entregado";
            notificarATodos(mensaje);
        }
    }
    
    @Override
    public void cancelarPedido(int idPedido) {
        Pedido pedido = buscarPedido(idPedido);
        if (pedido != null) {
            // Podríamos tener un estado Cancelado, pero por simplicidad solo notificamos
            String mensaje = "Pedido #" + idPedido + " ha sido cancelado";
            notificarATodos(mensaje);
            pedidos.remove(pedido);
        }
    }
    
    @Override
    public void deshacerUltimaAccion(int idPedido) {
        Pedido pedido = buscarPedido(idPedido);
        if (pedido != null) {
            pedido.restaurarEstado();
            String mensaje = "Se ha deshecho la última acción en el pedido #" + idPedido;
            notificarATodos(mensaje);
        }
    }
    
    private Pedido buscarPedido(int idPedido) {
        for (Pedido p : pedidos) {
            if (p.getId() == idPedido) {
                return p;
            }
        }
        System.out.println("Pedido #" + idPedido + " no encontrado");
        return null;
    }
    
    private void notificarATodos(String mensaje) {
        for (Colaborador c : colaboradores) {
            c.recibirMensaje(mensaje);
        }
    }
    
    public void registrarClienteParaPedido(int idPedido, Cliente cliente) {
        Pedido pedido = buscarPedido(idPedido);
        if (pedido != null) {
            pedido.agregarObservador(cliente);
            System.out.println(cliente + " registrado para el pedido #" + idPedido);
        }
    }
    
    public void mostrarEstadoPedido(int idPedido) {
        Pedido pedido = buscarPedido(idPedido);
        if (pedido != null) {
            System.out.println("Pedido #" + idPedido + " - Estado: " + pedido.getEstadoNombre() +
                            " - Detalle: " + pedido.getDetalle());
        }
    }
}