package model;

/** Pedido de encomienda con validación de peso y embalaje. */
public class PedidoEncomienda extends Pedido {

    private double pesoKg;
    private boolean embalajeAdecuado;

    public PedidoEncomienda(int idPedido, String direccionEntrega, double distanciaKm,
                            double pesoKg, boolean embalajeAdecuado) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.pesoKg = pesoKg;
        this.embalajeAdecuado = embalajeAdecuado;
    }

    public double getPesoKg() { return pesoKg; }
    public void setPesoKg(double pesoKg) { this.pesoKg = pesoKg; }

    public boolean isEmbalajeAdecuado() { return embalajeAdecuado; }
    public void setEmbalajeAdecuado(boolean embalajeAdecuado) {
        this.embalajeAdecuado = embalajeAdecuado;
    }

    // Tiempo = 20 minutos base + 1,5 minutos por kilómetro.
    @Override
    public int calcularTiempoEntrega() {
        return (int) Math.round(20 + (1.5 * getDistanciaKm()));
    }

    @Override
    public void asignarRepartidor() {
        if (pesoKg > 0 && embalajeAdecuado) {
            setRepartidorAsignado("Repartidor automático");
        }
    }

    @Override
    public void asignarRepartidor(String nombre) {
        if (pesoKg > 0 && embalajeAdecuado) {
            setRepartidorAsignado(nombre);
        }
    }
}
