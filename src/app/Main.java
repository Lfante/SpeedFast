package app;

import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

/**
 * Clase principal para probar la clase abstracta y las distintas
 * implementaciones del cálculo de tiempo de entrega.
 */
public class Main {

    public static void main(String[] args) {

        // Creo un objeto de cada tipo usando datos similares al ejemplo de la pauta.
        PedidoComida pedidoComida = new PedidoComida(
                1,
                "Av. Italia 456",
                4
        );

        PedidoEncomienda pedidoEncomienda = new PedidoEncomienda(
                2,
                "Av. Independencia 123",
                6
        );

        PedidoExpress pedidoExpress = new PedidoExpress(
                3,
                "Av. Apoquindo 1500",
                7
        );

        /*
         * Guardo todos los objetos como Pedido.
         * Esto me permite recorrerlos de la misma manera aunque cada clase
         * tenga su propia implementación de calcularTiempoEntrega().
         */
        Pedido[] pedidos = {
                pedidoComida,
                pedidoEncomienda,
                pedidoExpress
        };

        System.out.println("========================================");
        System.out.println("SPEEDFAST - TIEMPOS ESTIMADOS DE ENTREGA");
        System.out.println("========================================");
        System.out.println();

        for (Pedido pedido : pedidos) {
            pedido.mostrarResumen();

            int tiempoEstimado = pedido.calcularTiempoEntrega();

            System.out.println("Tiempo estimado de entrega: "
                    + tiempoEstimado + " minutos");
            System.out.println();
        }
    }
}
