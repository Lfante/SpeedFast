package model;

import java.util.concurrent.ThreadLocalRandom;

/** Cada repartidor se ejecuta como una tarea independiente. */
public class Repartidor implements Runnable {
    private String nombre;
    private ZonaDeCarga zonaDeCarga;

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public ZonaDeCarga getZonaDeCarga() { return zonaDeCarga; }
    public void setZonaDeCarga(ZonaDeCarga zonaDeCarga) { this.zonaDeCarga = zonaDeCarga; }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Pedido pedido = zonaDeCarga.retirarPedido();

            if (pedido == null) {
                System.out.println("[Repartidor - " + nombre + "] No quedan pedidos por retirar.");
                return;
            }

            try {
                System.out.println("[Repartidor - " + nombre + "] Retirando pedido #" + pedido.getId() + "...");
                System.out.println("[Repartidor - " + nombre + "] Estado: " + pedido.getEstado());
                System.out.println("[Repartidor - " + nombre + "] Entregando pedido #" + pedido.getId() + "...");

                int pausaMs = ThreadLocalRandom.current().nextInt(700, 1501);
                Thread.sleep(pausaMs);

                pedido.setEstado(EstadoPedido.ENTREGADO);
                System.out.println("[Repartidor - " + nombre + "] Pedido #" + pedido.getId() + " entregado.");
                System.out.println("[Repartidor - " + nombre + "] Estado: " + pedido.getEstado());

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("[Repartidor - " + nombre + "] Proceso interrumpido.");
                return;
            } catch (RuntimeException e) {
                System.out.println("[Repartidor - " + nombre + "] Error al procesar pedido #" + pedido.getId() + ": " + e.getMessage());
            }
        }
    }
}
