package model;

/**
 * Pedido de comida. Para este tipo de entrega se debe comprobar que el
 * repartidor cuente con mochila térmica.
 */
public class PedidoComida extends Pedido {

    private boolean requiereMochilaTermica;

    public PedidoComida(int idPedido, String direccionEntrega, boolean requiereMochilaTermica) {
        super(idPedido, direccionEntrega, "Comida");
        this.requiereMochilaTermica = requiereMochilaTermica;
    }

    public boolean isRequiereMochilaTermica() {
        return requiereMochilaTermica;
    }

    public void setRequiereMochilaTermica(boolean requiereMochilaTermica) {
        this.requiereMochilaTermica = requiereMochilaTermica;
    }

    // Sobrescribo el método para aplicar la regla específica de los pedidos de comida.
    @Override
    public void asignarRepartidor() {
        System.out.println("[Pedido Comida]");
        mostrarDatosPedido();
        System.out.println("Asignando repartidor...");

        if (requiereMochilaTermica) {
            System.out.println("-> Verificando mochila térmica... OK");
        } else {
            System.out.println("-> Este pedido no requiere mochila térmica.");
        }
    }

    // Esta versión también sobrescribe la sobrecarga para mostrar la asignación final.
    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("[Pedido Comida - asignación]");

        if (requiereMochilaTermica) {
            System.out.println("-> Verificando mochila térmica para " + nombreRepartidor + "... OK");
        }

        System.out.println("-> Pedido asignado a " + nombreRepartidor);
    }
}
