package model;

/** Pedido de encomienda con validación de peso y embalaje. */
public class PedidoEncomienda extends Pedido {
    private double pesoKg;
    private boolean embalajeAdecuado;

    public PedidoEncomienda(int idPedido, String direccionEntrega, double distanciaKm, double pesoKg, boolean embalajeAdecuado) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.pesoKg = pesoKg;
        this.embalajeAdecuado = embalajeAdecuado;
    }

    public double getPesoKg() { return pesoKg; }
    public void setPesoKg(double pesoKg) { this.pesoKg = pesoKg; }
    public boolean isEmbalajeAdecuado() { return embalajeAdecuado; }
    public void setEmbalajeAdecuado(boolean embalajeAdecuado) { this.embalajeAdecuado = embalajeAdecuado; }

    // Tiempo = 20 minutos base + 1,5 minutos por kilómetro, ajustado a entero.
    @Override
    public int calcularTiempoEntrega() {
        return (int) (20 + (1.5 * getDistanciaKm()));
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("[Asignación automática - Pedido Encomienda]");
        if (pesoKg > 0 && embalajeAdecuado) {
            System.out.println("-> Validando peso y embalaje... OK");
            setRepartidorAsignado("Daniela Tapia");
            System.out.println("-> Repartidor asignado: " + getRepartidorAsignado());
        } else {
            System.out.println("-> No se puede asignar: revisar peso o embalaje.");
        }
    }

    @Override
    public void asignarRepartidor(String nombre) {
        System.out.println("[Asignación manual - Pedido Encomienda]");
        if (pesoKg > 0 && embalajeAdecuado) {
            System.out.println("-> Validando peso y embalaje... OK");
            setRepartidorAsignado(nombre);
            System.out.println("-> Repartidor asignado: " + getRepartidorAsignado());
        } else {
            System.out.println("-> No se puede asignar a " + nombre + ": revisar peso o embalaje.");
        }
    }
}
