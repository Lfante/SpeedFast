package model;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Cada objeto Repartidor funciona como una tarea independiente.
 * Dentro de su propio hilo procesa sus pedidos uno por uno.
 */
public class Repartidor implements Runnable {

    private String nombre;
    private List<Pedido> pedidosAsignados;

    public Repartidor(String nombre, List<Pedido> pedidosAsignados) {
        this.nombre = nombre;

        // Creo una copia para evitar que la lista cambie mientras se ejecuta el hilo.
        this.pedidosAsignados = List.copyOf(pedidosAsignados);
    }

    public String getNombre() { return nombre; }
    public List<Pedido> getPedidosAsignados() { return pedidosAsignados; }

    @Override
    public void run() {
        System.out.println("[Repartidor: " + nombre + "] Iniciando ruta con "
                + pedidosAsignados.size() + " pedidos.");

        for (Pedido pedido : pedidosAsignados) {

            if (Thread.currentThread().isInterrupted()) {
                System.out.println("[Repartidor: " + nombre
                        + "] Ruta interrumpida antes de completar todos los pedidos.");
                return;
            }

            try {
                pedido.reservar();
                pedido.asignarRepartidor(nombre);

                System.out.println("[Repartidor: " + nombre + "] Entregando "
                        + pedido.getClass().getSimpleName()
                        + " #" + String.format("%03d", pedido.getIdPedido()) + "...");

                /*
                 * La pausa aleatoria simula que cada entrega tarda un tiempo distinto.
                 * Los otros repartidores pueden seguir trabajando durante esta espera.
                 */
                int pausaMs = ThreadLocalRandom.current().nextInt(500, 1201);
                Thread.sleep(pausaMs);

                pedido.despachar();

                System.out.println("[Repartidor: " + nombre + "] Pedido #"
                        + String.format("%03d", pedido.getIdPedido()) + " entregado.");

            } catch (InterruptedException e) {
                // Conservo la señal de interrupción y termino este hilo de forma controlada.
                Thread.currentThread().interrupt();
                System.out.println("[Repartidor: " + nombre
                        + "] Entrega interrumpida. Finalizando ruta.");
                return;

            } catch (RuntimeException e) {
                /*
                 * Un problema con un pedido no debería detener toda la simulación,
                 * así que informo el error y continúo con el siguiente.
                 */
                System.out.println("[Repartidor: " + nombre + "] Error en Pedido #"
                        + String.format("%03d", pedido.getIdPedido())
                        + ": " + e.getMessage());
            }
        }

        System.out.println("[Repartidor: " + nombre + "] Ruta completada.");
    }
}
