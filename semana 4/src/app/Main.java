package app;

import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;
import model.Repartidor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/** Ejecuta la simulación concurrente de entregas de SpeedFast. */
public class Main {

    public static void main(String[] args) {

        // La pauta pide al menos tres repartidores con dos o más pedidos cada uno.
        Repartidor camila = new Repartidor(
                "Camila",
                List.of(
                        new PedidoComida(101, "Av. Italia 456", 4, true),
                        new PedidoEncomienda(102, "Av. Santa Rosa 567", 7, 5.5, true)
                )
        );

        Repartidor luis = new Repartidor(
                "Luis",
                List.of(
                        new PedidoExpress(103, "Av. Apoquindo 1500", 8, true),
                        new PedidoComida(104, "Av. Providencia 1234", 3, true)
                )
        );

        Repartidor daniela = new Repartidor(
                "Daniela",
                List.of(
                        new PedidoEncomienda(105, "Av. Irarrázaval 2450", 6, 3.2, true),
                        new PedidoExpress(106, "Gran Avenida 5200", 5, true)
                )
        );

        System.out.println("========================================");
        System.out.println("SPEEDFAST - SIMULACIÓN CONCURRENTE");
        System.out.println("========================================");
        System.out.println();

        /*
         * Uso tres hilos para que los tres repartidores puedan procesar
         * sus rutas al mismo tiempo.
         */
        ExecutorService executor = Executors.newFixedThreadPool(3);

        try {
            executor.submit(camila);
            executor.submit(luis);
            executor.submit(daniela);
        } finally {
            // Dejo de aceptar tareas nuevas, pero permito que terminen las actuales.
            executor.shutdown();
        }

        try {
            // La simulación continúa hasta que todos los repartidores terminan.
            boolean finalizo = executor.awaitTermination(30, TimeUnit.SECONDS);

            if (!finalizo) {
                System.out.println("Tiempo máximo superado. Cancelando tareas pendientes...");
                executor.shutdownNow();
            }

        } catch (InterruptedException e) {
            // Si se interrumpe el hilo principal, detengo las tareas de forma segura.
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            System.out.println("La simulación fue interrumpida.");
        }

        System.out.println();
        System.out.println("========================================");
        System.out.println("TODOS LOS REPARTIDORES FINALIZARON");
        System.out.println("========================================");

        // Uso un pedido ya procesado para mostrar el historial compartido final.
        camila.getPedidosAsignados().get(0).verHistorial();
    }
}
