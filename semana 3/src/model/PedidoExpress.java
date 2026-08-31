package model;

/** Pedido express con prioridad de disponibilidad inmediata. */
public class PedidoExpress extends Pedido {
    private boolean disponibilidadInmediata;

    public PedidoExpress(int idPedido, String direccionEntrega, double distanciaKm, boolean disponibilidadInmediata) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.disponibilidadInmediata = disponibilidadInmediata;
    }

    public boolean isDisponibilidadInmediata() { return disponibilidadInmediata; }
    public void setDisponibilidadInmediata(boolean disponibilidadInmediata) { this.disponibilidadInmediata = disponibilidadInmediata; }

    // 10 minutos base y 5 minutos extra cuando la distancia supera los 5 km.
    @Override
    public int calcularTiempoEntrega() {
        int tiempo = 10;
        if (getDistanciaKm() > 5) tiempo += 5;
        return tiempo;
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("[Asignación automática - Pedido Express]");
        if (disponibilidadInmediata) {
            setRepartidorAsignado("Camila Soto");
            System.out.println("-> Repartidor más cercano con disponibilidad inmediata encontrado.");
            System.out.println("-> Repartidor asignado: " + getRepartidorAsignado());
        } else {
            System.out.println("-> No hay repartidor con disponibilidad inmediata.");
        }
    }

    @Override
    public void asignarRepartidor(String nombre) {
        System.out.println("[Asignación manual - Pedido Express]");
        if (disponibilidadInmediata) {
            setRepartidorAsignado(nombre);
            System.out.println("-> " + nombre + " se encuentra disponible.");
            System.out.println("-> Repartidor asignado: " + getRepartidorAsignado());
        } else {
            System.out.println("-> " + nombre + " no tiene disponibilidad inmediata.");
        }
    }
}
