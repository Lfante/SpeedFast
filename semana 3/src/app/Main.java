package app;

import interfaces.Cancelable;
import interfaces.Despachable;
import interfaces.Rastreable;
import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

/** Clase principal para simular la versión integral del sistema SpeedFast. */
public class Main {
    public static void main(String[] args) {
        // Creo un objeto de cada tipo para cubrir los tres casos pedidos en la actividad.
        PedidoComida pedidoComida = new PedidoComida(101, "Av. Italia 456", 4, true);
        PedidoEncomienda pedidoEncomienda = new PedidoEncomienda(102, "Av. Santa Rosa 567", 7, 6.5, true);
        PedidoExpress pedidoExpress = new PedidoExpress(103, "Av. Apoquindo 1500", 8, true);

        Pedido[] pedidos = {pedidoComida, pedidoEncomienda, pedidoExpress};

        System.out.println("========================================");
        System.out.println("SPEEDFAST - SISTEMA INTEGRAL DE ENTREGAS");
        System.out.println("========================================\n");

        System.out.println("1. RESERVA DE PEDIDOS");
        System.out.println("----------------------------------------");
        for (Pedido pedido : pedidos) pedido.reservar();

        System.out.println("\n2. ASIGNACIÓN DE REPARTIDORES");
        System.out.println("----------------------------------------");
        pedidoComida.asignarRepartidor();
        System.out.println();
        pedidoEncomienda.asignarRepartidor("Daniela Tapia");
        System.out.println();
        pedidoExpress.asignarRepartidor();

        System.out.println("\n3. RESUMEN Y TIEMPOS ESTIMADOS");
        System.out.println("----------------------------------------");
        for (Pedido pedido : pedidos) {
            pedido.mostrarResumen();
            System.out.println("Tiempo estimado: " + pedido.calcularTiempoEntrega() + " minutos");
            System.out.println();
        }

        System.out.println("4. DESPACHO MEDIANTE INTERFAZ");
        System.out.println("----------------------------------------");
        Despachable despachoComida = pedidoComida;
        Despachable despachoEncomienda = pedidoEncomienda;
        System.out.println("[Pedido Comida]");
        despachoComida.despachar();
        System.out.println("\n[Pedido Encomienda]");
        despachoEncomienda.despachar();

        System.out.println("\n5. CANCELACIÓN MEDIANTE INTERFAZ");
        System.out.println("----------------------------------------");
        Cancelable cancelable = pedidoExpress;
        cancelable.cancelar();

        System.out.println("\n6. HISTORIAL MEDIANTE INTERFAZ");
        System.out.println("----------------------------------------");
        Rastreable rastreable = pedidoComida;
        rastreable.verHistorial();
    }
}
