package model;

/** Pedido de comida con validación de mochila térmica. */
public class PedidoComida extends Pedido {

    private boolean requiereMochilaTermica;

    public PedidoComida(int idPedido, String direccionEntrega, double distanciaKm,
                        boolean requiereMochilaTermica) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.requiereMochilaTermica = requiereMochilaTermica;
    }

    public boolean isRequiereMochilaTermica() { return requiereMochilaTermica; }
    public void setRequiereMochilaTermica(boolean requiereMochilaTermica) {
        this.requiereMochilaTermica = requiereMochilaTermica;
    }

    // Tiempo = 15 minutos base + 2 minutos por kilómetro.
    @Override
    public int calcularTiempoEntrega() {
        return (int) Math.round(15 + (2 * getDistanciaKm()));
    }

    @Override
    public void asignarRepartidor() {
        setRepartidorAsignado("Repartidor automático");
    }

    @Override
    public void asignarRepartidor(String nombre) {
        if (requiereMochilaTermica) {
            setRepartidorAsignado(nombre);
        }
    }
}
