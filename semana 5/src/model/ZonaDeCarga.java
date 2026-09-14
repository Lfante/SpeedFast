package model;

import java.util.LinkedList;
import java.util.List;

/** Recurso compartido al que acceden todos los repartidores. */
public class ZonaDeCarga {
    private final List<Pedido> pedidos = new LinkedList<>();

    public ZonaDeCarga() {
        System.out.println("[Zona de carga inicializada]");
    }

    public synchronized void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
        System.out.println("Pedido #" + pedido.getId() + " agregado. Destino: " + pedido.getDireccionEntrega());
    }

    /*
     * El retiro y el cambio a EN_REPARTO ocurren dentro del mismo bloque
     * synchronized. Así dos repartidores no pueden tomar el mismo pedido.
     */
    public synchronized Pedido retirarPedido() {
        for (int i = 0; i < pedidos.size(); i++) {
            Pedido pedido = pedidos.get(i);
            if (pedido.getEstado() == EstadoPedido.PENDIENTE) {
                pedido.setEstado(EstadoPedido.EN_REPARTO);
                pedidos.remove(i);
                return pedido;
            }
        }
        return null;
    }

    public synchronized boolean estaVacia() { return pedidos.isEmpty(); }
    public synchronized int cantidadPedidos() { return pedidos.size(); }
}
