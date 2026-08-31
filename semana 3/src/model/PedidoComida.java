package model;

/** Pedido de comida con validación de mochila térmica. */
public class PedidoComida extends Pedido {
    private boolean requiereMochilaTermica;

    public PedidoComida(int idPedido, String direccionEntrega, double distanciaKm, boolean requiereMochilaTermica) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.requiereMochilaTermica = requiereMochilaTermica;
    }

    public boolean isRequiereMochilaTermica() { return requiereMochilaTermica; }
    public void setRequiereMochilaTermica(boolean requiereMochilaTermica) { this.requiereMochilaTermica = requiereMochilaTermica; }

    // Tiempo = 15 minutos base + 2 minutos por kilómetro.
    @Override
    public int calcularTiempoEntrega() {
        return (int) (15 + (2 * getDistanciaKm()));
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("[Asignación automática - Pedido Comida]");
        if (requiereMochilaTermica) {
            System.out.println("-> Verificando repartidor con mochila térmica... OK");
        }
        setRepartidorAsignado("Luis Díaz");
        System.out.println("-> Repartidor asignado: " + getRepartidorAsignado());
    }

    @Override
    public void asignarRepartidor(String nombre) {
        System.out.println("[Asignación manual - Pedido Comida]");
        if (requiereMochilaTermica) {
            System.out.println("-> Validando mochila térmica para " + nombre + "... OK");
        }
        setRepartidorAsignado(nombre);
        System.out.println("-> Repartidor asignado: " + getRepartidorAsignado());
    }
}
