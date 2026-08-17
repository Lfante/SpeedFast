package model;

/**
 * Clase base para representar los datos que comparten todos los pedidos.
 */
public class Pedido {

    // Los atributos quedan privados para aplicar encapsulamiento.
    private int idPedido;
    private String direccionEntrega;
    private String tipoPedido;

    // Constructor completo solicitado para inicializar todos los datos del pedido.
    public Pedido(int idPedido, String direccionEntrega, String tipoPedido) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.tipoPedido = tipoPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    /**
     * Método base. Las clases hijas lo sobrescriben con la lógica que corresponde
     * a cada tipo de pedido.
     */
    public void asignarRepartidor() {
        System.out.println("Asignando repartidor de forma genérica...");
    }

    /**
     * Sobrecarga del método anterior: mantiene el mismo nombre, pero ahora recibe
     * el nombre del repartidor como parámetro.
     */
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Pedido asignado a " + nombreRepartidor + ".");
    }

    // Método auxiliar para no repetir los datos básicos en cada subclase.
    protected void mostrarDatosPedido() {
        System.out.println("ID pedido: " + idPedido);
        System.out.println("Dirección de entrega: " + direccionEntrega);
        System.out.println("Tipo de pedido: " + tipoPedido);
    }
}
