package model;

/**
 * Pedido de encomienda. En este caso se valida el peso y el embalaje antes
 * de realizar la asignación.
 */
public class PedidoEncomienda extends Pedido {

    private double pesoKg;
    private boolean embalajeAdecuado;

    public PedidoEncomienda(int idPedido, String direccionEntrega, double pesoKg, boolean embalajeAdecuado) {
        super(idPedido, direccionEntrega, "Encomienda");
        this.pesoKg = pesoKg;
        this.embalajeAdecuado = embalajeAdecuado;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public boolean isEmbalajeAdecuado() {
        return embalajeAdecuado;
    }

    public void setEmbalajeAdecuado(boolean embalajeAdecuado) {
        this.embalajeAdecuado = embalajeAdecuado;
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("[Pedido Encomienda]");
        mostrarDatosPedido();
        System.out.println("Asignando repartidor...");
        System.out.println("-> Peso informado: " + pesoKg + " kg");

        if (pesoKg > 0 && embalajeAdecuado) {
            System.out.println("-> Validando peso y embalaje... OK");
        } else {
            System.out.println("-> Validación pendiente: revisar peso o embalaje.");
        }
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("[Pedido Encomienda - asignación]");

        if (pesoKg > 0 && embalajeAdecuado) {
            System.out.println("-> Peso y embalaje validados correctamente.");
            System.out.println("-> Pedido asignado a " + nombreRepartidor);
        } else {
            System.out.println("-> No se puede asignar a " + nombreRepartidor
                    + " hasta corregir la validación de la encomienda.");
        }
    }
}
