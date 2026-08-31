package model;

import interfaces.Cancelable;
import interfaces.Despachable;
import interfaces.Rastreable;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta que reúne los datos y comportamientos comunes
 * para todos los tipos de pedido de SpeedFast.
 */
public abstract class Pedido implements Despachable, Cancelable, Rastreable {

    // Estos atributos son comunes a todos los pedidos, por eso los dejo en la clase padre.
    private int idPedido;
    private String direccionEntrega;
    private double distanciaKm;

    // Estos datos permiten controlar las operaciones que se simulan durante la actividad.
    private String repartidorAsignado;
    private boolean reservado;
    private boolean despachado;
    private boolean cancelado;

    // Uso una lista compartida para registrar las entregas realizadas durante la ejecución.
    private static final List<String> historialEntregas = new ArrayList<>();

    public Pedido(int idPedido, String direccionEntrega, double distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
    }

    public int getIdPedido() { return idPedido; }
    public void setIdPedido(int idPedido) { this.idPedido = idPedido; }
    public String getDireccionEntrega() { return direccionEntrega; }
    public void setDireccionEntrega(String direccionEntrega) { this.direccionEntrega = direccionEntrega; }
    public double getDistanciaKm() { return distanciaKm; }
    public void setDistanciaKm(double distanciaKm) { this.distanciaKm = distanciaKm; }
    public String getRepartidorAsignado() { return repartidorAsignado; }
    protected void setRepartidorAsignado(String repartidorAsignado) { this.repartidorAsignado = repartidorAsignado; }
    public boolean isReservado() { return reservado; }
    public boolean isDespachado() { return despachado; }
    public boolean isCancelado() { return cancelado; }

    // El resumen se implementa una sola vez porque es común para todos los pedidos.
    public void mostrarResumen() {
        DecimalFormat formatoDistancia = new DecimalFormat("0.##");
        System.out.println(getClass().getSimpleName() + " #" + String.format("%03d", idPedido));
        System.out.println("Dirección: " + direccionEntrega);
        System.out.println("Distancia: " + formatoDistancia.format(distanciaKm) + " km");
        System.out.println("Repartidor asignado: " + (repartidorAsignado == null ? "pendiente" : repartidorAsignado));
    }

    // Cada subclase aplica una fórmula distinta.
    public abstract int calcularTiempoEntrega();

    // Primera firma: asignación automática.
    public abstract void asignarRepartidor();

    // Segunda firma: asignación manual. Esta firma demuestra la sobrecarga.
    public abstract void asignarRepartidor(String nombre);

    // La reserva es común y se reutiliza en todos los tipos de pedido.
    public void reservar() {
        if (cancelado) {
            System.out.println("-> No se puede reservar un pedido cancelado.");
            return;
        }
        if (reservado) {
            System.out.println("-> El pedido #" + String.format("%03d", idPedido) + " ya se encuentra reservado.");
            return;
        }
        reservado = true;
        System.out.println("-> " + getClass().getSimpleName() + " #" + String.format("%03d", idPedido) + " reservado correctamente.");
    }

    // Implementación común de la interfaz Despachable.
    @Override
    public void despachar() {
        if (cancelado) {
            System.out.println("-> No se puede despachar el pedido porque está cancelado.");
            return;
        }
        if (!reservado) {
            System.out.println("-> El pedido debe estar reservado antes de ser despachado.");
            return;
        }
        if (despachado) {
            System.out.println("-> El pedido ya fue despachado.");
            return;
        }
        if (repartidorAsignado == null) {
            asignarRepartidor();
        }
        if (repartidorAsignado == null) {
            System.out.println("-> No se puede despachar porque no existe un repartidor asignado.");
            return;
        }
        despachado = true;
        historialEntregas.add(getClass().getSimpleName() + " #" + String.format("%03d", idPedido) + " - entregado por " + repartidorAsignado);
        System.out.println("-> Pedido despachado correctamente.");
    }

    // Implementación común de la interfaz Cancelable.
    @Override
    public void cancelar() {
        System.out.println("Cancelando " + getClass().getSimpleName() + " #" + String.format("%03d", idPedido) + "...");
        if (despachado) {
            System.out.println("-> No se puede cancelar porque el pedido ya fue despachado.");
            return;
        }
        if (cancelado) {
            System.out.println("-> El pedido ya se encuentra cancelado.");
            return;
        }
        cancelado = true;
        System.out.println("-> Pedido cancelado exitosamente.");
    }

    // Implementación común de la interfaz Rastreable.
    @Override
    public void verHistorial() {
        System.out.println("Historial:");
        if (historialEntregas.isEmpty()) {
            System.out.println("- No existen entregas registradas.");
            return;
        }
        for (String registro : historialEntregas) {
            System.out.println("- " + registro);
        }
    }
}
