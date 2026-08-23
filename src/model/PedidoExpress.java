package model;

/**
 * Pedido express.
 * Tiene 10 minutos base y agrega 5 minutos cuando la distancia supera los 5 km.
 */
public class PedidoExpress extends Pedido {

    // Reglas propias de los pedidos express.
    private static final int TIEMPO_BASE_MINUTOS = 10;
    private static final double LIMITE_DISTANCIA_KM = 5.0;
    private static final int RECARGO_DISTANCIA_MINUTOS = 5;

    public PedidoExpress(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    /**
     * Si la distancia es mayor a 5 km agrego el recargo definido para este servicio.
     */
    @Override
    public int calcularTiempoEntrega() {
        int tiempo = TIEMPO_BASE_MINUTOS;

        if (getDistanciaKm() > LIMITE_DISTANCIA_KM) {
            tiempo += RECARGO_DISTANCIA_MINUTOS;
        }

        return tiempo;
    }
}
