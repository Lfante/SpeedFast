package app;

import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

/**
 * Clase principal para probar la sobreescritura, la sobrecarga y el
 * polimorfismo solicitados en la actividad.
 */
public class Main {

    public static void main(String[] args) {

        // Creo un objeto de cada tipo de pedido con datos de ejemplo.
        PedidoComida pedidoComida = new PedidoComida(
                101,
                "Av. Providencia 1234, Santiago",
                true
        );

        PedidoEncomienda pedidoEncomienda = new PedidoEncomienda(
                102,
                "Av. Irarrázaval 2450, Ñuñoa",
                4.5,
                true
        );

        PedidoExpress pedidoExpress = new PedidoExpress(
                103,
                "Gran Avenida 5200, San Miguel",
                1.2,
                true
        );

        System.out.println("========================================");
        System.out.println("SPEEDFAST - PRUEBA DE POLIMORFISMO");
        System.out.println("========================================\n");

        /*
         * Guardo objetos distintos usando el tipo de la clase padre.
         * Cuando se llama asignarRepartidor(), Java ejecuta la versión
         * sobrescrita que corresponde al tipo real de cada objeto.
         */
        Pedido[] pedidos = {pedidoComida, pedidoEncomienda, pedidoExpress};

        for (Pedido pedido : pedidos) {
            pedido.asignarRepartidor();
            System.out.println();
        }

        System.out.println("========================================");
        System.out.println("PRUEBA DEL MÉTODO SOBRECARGADO");
        System.out.println("========================================\n");

        // Ahora uso la versión que recibe el nombre del repartidor.
        pedidoComida.asignarRepartidor("Juan Pérez");
        System.out.println();

        pedidoEncomienda.asignarRepartidor("Camila Soto");
        System.out.println();

        pedidoExpress.asignarRepartidor("Luis Díaz");
    }
}
