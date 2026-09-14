package app;

import model.EstadoPedido;
import model.Pedido;
import model.Repartidor;
import model.ZonaDeCarga;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/** Prueba el acceso concurrente y sincronizado a la zona de carga. */
public class Main {
    public static void main(String[] args) {
        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();
        System.out.println();

        zonaDeCarga.agregarPedido(new Pedido(1, "Santiago Centro", EstadoPedido.PENDIENTE));
        zonaDeCarga.agregarPedido(new Pedido(2, "Providencia", EstadoPedido.PENDIENTE));
        zonaDeCarga.agregarPedido(new Pedido(3, "Ñuñoa", EstadoPedido.PENDIENTE));
        zonaDeCarga.agregarPedido(new Pedido(4, "Recoleta", EstadoPedido.PENDIENTE));
        zonaDeCarga.agregarPedido(new Pedido(5, "Las Condes", EstadoPedido.PENDIENTE));
        zonaDeCarga.agregarPedido(new Pedido(6, "San Miguel", EstadoPedido.PENDIENTE));

        System.out.println();
        System.out.println("Iniciando repartidores...");
        System.out.println();

        Repartidor juan = new Repartidor("Juan", zonaDeCarga);
        Repartidor camila = new Repartidor("Camila", zonaDeCarga);
        Repartidor pedro = new Repartidor("Pedro", zonaDeCarga);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(juan);
        executor.submit(camila);
        executor.submit(pedro);
        executor.shutdown();

        boolean finalizoCorrectamente = false;
        try {
            finalizoCorrectamente = executor.awaitTermination(30, TimeUnit.SECONDS);
            if (!finalizoCorrectamente) {
                System.out.println("Tiempo máximo superado. Deteniendo tareas pendientes...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            System.out.println("La ejecución principal fue interrumpida.");
        }

        System.out.println();
        if (finalizoCorrectamente && zonaDeCarga.estaVacia()) {
            System.out.println("Todos los pedidos han sido entregados correctamente");
        } else {
            System.out.println("La simulación terminó con pedidos pendientes.");
        }
    }
}
