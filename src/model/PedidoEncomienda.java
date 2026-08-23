package model;

/**
 * Pedido de encomienda.
 * Su tiempo se calcula usando 20 minutos base más 1,5 minutos por kilómetro.
 */
public class PedidoEncomienda extends Pedido {

    // Valores propios de este tipo de pedido.
    private static final int TIEMPO_BASE_MINUTOS = 20;
    private static final double MINUTOS_POR_KM = 1.5;

    public PedidoEncomienda(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    /**
     * La pauta pide ajustar el resultado a entero, por eso redondeo
     * el cálculo antes de devolver el tiempo estimado.
     */
    @Override
    public int calcularTiempoEntrega() {
        double tiempo = TIEMPO_BASE_MINUTOS
                + (MINUTOS_POR_KM * getDistanciaKm());

        return (int) Math.round(tiempo);
    }
}
