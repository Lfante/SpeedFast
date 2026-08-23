package model;

/**
 * Pedido de comida.
 * Su tiempo se calcula usando 15 minutos base más 2 minutos por kilómetro.
 */
public class PedidoComida extends Pedido {

    // Valores propios de este tipo de pedido.
    private static final int TIEMPO_BASE_MINUTOS = 15;
    private static final int MINUTOS_POR_KM = 2;

    public PedidoComida(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    /**
     * Aplico la fórmula indicada para los pedidos de comida.
     * Uso Math.round para obtener un tiempo final expresado en minutos enteros.
     */
    @Override
    public int calcularTiempoEntrega() {
        double tiempo = TIEMPO_BASE_MINUTOS
                + (MINUTOS_POR_KM * getDistanciaKm());

        return (int) Math.round(tiempo);
    }
}
