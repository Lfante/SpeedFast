package model;

/** Pedido express con prioridad de disponibilidad inmediata. */
public class PedidoExpress extends Pedido {

    private boolean disponibilidadInmediata;

    public PedidoExpress(int idPedido, String direccionEntrega, double distanciaKm,
                         boolean disponibilidadInmediata) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.disponibilidadInmediata = disponibilidadInmediata;
    }

    public boolean isDisponibilidadInmediata() { return disponibilidadInmediata; }
    public void setDisponibilidadInmediata(boolean disponibilidadInmediata) {
        this.disponibilidadInmediata = disponibilidadInmediata;
    }

    // 10 minutos base y 5 minutos extra cuando la distancia supera los 5 km.
    @Override
    public int calcularTiempoEntrega() {
        return getDistanciaKm() > 5 ? 15 : 10;
    }

    @Override
    public void asignarRepartidor() {
        if (disponibilidadInmediata) {
            setRepartidorAsignado("Repartidor automático");
        }
    }

    @Override
    public void asignarRepartidor(String nombre) {
        if (disponibilidadInmediata) {
            setRepartidorAsignado(nombre);
        }
    }
}
