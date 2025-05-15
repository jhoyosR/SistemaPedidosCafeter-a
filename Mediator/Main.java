package Mediator;

public class Main {
    public static void main(String[] args) {
        // Crear el mediador/controlador central
        ControladorCafeteria controlador = new ControladorCafeteria();
        
        // Crear los colaboradores
        Cajero cajero1 = new Cajero("Juan", controlador);
        Barista barista1 = new Barista("María", controlador);
        Repartidor repartidor1 = new Repartidor("Carlos", controlador);
        
        // Crear clientes
        Cliente cliente1 = new Cliente("Ana");
        Cliente cliente2 = new Cliente("Pedro");
        
        System.out.println("\n--- SIMULACIÓN DE PEDIDOS ---\n");
        
        // Flujo del primer pedido
        cajero1.tomarPedido("Café Americano Grande");
        controlador.registrarClienteParaPedido(1, cliente1);
        controlador.mostrarEstadoPedido(1);
        
        barista1.prepararPedido(1);
        controlador.mostrarEstadoPedido(1);
        
        // Deshacer la última acción
        System.out.println("\n--- PROBANDO PATRÓN MEMENTO ---\n");
        controlador.deshacerUltimaAccion(1);
        controlador.mostrarEstadoPedido(1);
        
        // Continuar con el flujo normal
        barista1.prepararPedido(1);
        barista1.finalizarPedido(1);
        controlador.mostrarEstadoPedido(1);
        
        repartidor1.entregarPedido(1);
        controlador.mostrarEstadoPedido(1);
        
        // Segundo pedido
        System.out.println("\n--- NUEVO PEDIDO ---\n");
        cajero1.tomarPedido("Cappuccino y galletas");
        controlador.registrarClienteParaPedido(2, cliente2);
        
        barista1.prepararPedido(2);
        
        // Cancelar segundo pedido
        System.out.println("\n--- CANCELACIÓN DE PEDIDO ---\n");
        cajero1.cancelarPedido(2);
        
        // Comunicación a través del mediador
        System.out.println("\n--- COMUNICACIÓN VÍA MEDIADOR ---\n");
        cajero1.enviarMensaje("¿Algún pedido pendiente?");
        barista1.enviarMensaje("Todo en orden por ahora");
    }
}