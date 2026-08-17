package model;

/**
 * Pedido express. La prioridad es encontrar un repartidor cercano y con
 * disponibilidad inmediata.
 */
public class PedidoExpress extends Pedido {

    private double distanciaRepartidorKm;
    private boolean disponibilidadInmediata;

    public PedidoExpress(int idPedido, String direccionEntrega,
                         double distanciaRepartidorKm, boolean disponibilidadInmediata) {
        super(idPedido, direccionEntrega, "Compra Express");
        this.distanciaRepartidorKm = distanciaRepartidorKm;
        this.disponibilidadInmediata = disponibilidadInmediata;
    }

    public double getDistanciaRepartidorKm() {
        return distanciaRepartidorKm;
    }

    public void setDistanciaRepartidorKm(double distanciaRepartidorKm) {
        this.distanciaRepartidorKm = distanciaRepartidorKm;
    }

    public boolean isDisponibilidadInmediata() {
        return disponibilidadInmediata;
    }

    public void setDisponibilidadInmediata(boolean disponibilidadInmediata) {
        this.disponibilidadInmediata = disponibilidadInmediata;
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("[Pedido Express]");
        mostrarDatosPedido();
        System.out.println("Asignando repartidor...");

        if (disponibilidadInmediata) {
            System.out.println("-> Repartidor más cercano encontrado a "
                    + distanciaRepartidorKm + " km con disponibilidad inmediata.");
        } else {
            System.out.println("-> No hay repartidor con disponibilidad inmediata.");
        }
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("[Pedido Express - asignación]");

        if (disponibilidadInmediata) {
            System.out.println("-> " + nombreRepartidor + " está a "
                    + distanciaRepartidorKm + " km y se encuentra disponible.");
            System.out.println("-> Pedido asignado a " + nombreRepartidor);
        } else {
            System.out.println("-> " + nombreRepartidor
                    + " no tiene disponibilidad inmediata para este pedido.");
        }
    }
}
