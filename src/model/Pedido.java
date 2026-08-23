package model;

import java.text.DecimalFormat;

/**
 * Clase abstracta que reúne los datos y comportamientos comunes
 * de todos los pedidos de SpeedFast.
 */
public abstract class Pedido {

    // Estos datos se repiten en todos los tipos de pedido, por eso quedan en la clase padre.
    private int idPedido;
    private String direccionEntrega;
    private double distanciaKm;

    // Constructor común para inicializar los datos básicos de cualquier pedido.
    public Pedido(int idPedido, String direccionEntrega, double distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
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

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    /**
     * Este método ya queda implementado porque el resumen se muestra
     * de la misma forma para todos los tipos de pedido.
     */
    public void mostrarResumen() {
        DecimalFormat formatoDistancia = new DecimalFormat("0.##");

        System.out.println(getClass().getSimpleName()
                + " #" + String.format("%03d", idPedido));
        System.out.println("Dirección: " + direccionEntrega);
        System.out.println("Distancia: "
                + formatoDistancia.format(distanciaKm) + " km");
    }

    /**
     * Cada tipo de pedido calcula su tiempo de una manera diferente,
     * por eso dejo este método abstracto y lo implemento en las clases hijas.
     */
    public abstract int calcularTiempoEntrega();
}
