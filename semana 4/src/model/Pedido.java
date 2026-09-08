package model;

import interfaces.Cancelable;
import interfaces.Despachable;
import interfaces.Rastreable;
import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Clase abstracta que mantiene los datos y comportamientos comunes
 * de los pedidos de SpeedFast.
 */
public abstract class Pedido implements Despachable, Cancelable, Rastreable {

    // Estos datos se reutilizan en todos los tipos de pedido.
    private int idPedido;
    private String direccionEntrega;
    private double distanciaKm;

    // Estado usado durante la simulación de las entregas.
    private String repartidorAsignado;
    private boolean reservado;
    private boolean despachado;
    private boolean cancelado;

    /*
     * Como varios repartidores pueden terminar pedidos al mismo tiempo,
     * uso una lista segura para hilos y evito problemas al registrar el historial.
     */
    private static final List<String> historialEntregas = new CopyOnWriteArrayList<>();

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

    // Este resumen se implementa una sola vez porque es común para todos los pedidos.
    public void mostrarResumen() {
        DecimalFormat formato = new DecimalFormat("0.##");
        System.out.println(getClass().getSimpleName() + " #" + String.format("%03d", idPedido));
        System.out.println("Dirección: " + direccionEntrega);
        System.out.println("Distancia: " + formato.format(distanciaKm) + " km");
    }

    // Cada subclase mantiene su propia fórmula de tiempo.
    public abstract int calcularTiempoEntrega();

    // Primera firma: asignación automática.
    public abstract void asignarRepartidor();

    // Segunda firma: asignación manual.
    public abstract void asignarRepartidor(String nombre);

    public void reservar() {
        if (!cancelado) {
            reservado = true;
        }
    }

    @Override
    public void despachar() {
        if (cancelado) {
            System.out.println("-> No se puede despachar el pedido porque está cancelado.");
            return;
        }

        if (!reservado) {
            reservar();
        }

        if (repartidorAsignado == null) {
            asignarRepartidor();
        }

        if (repartidorAsignado == null) {
            System.out.println("-> No se pudo despachar porque no existe un repartidor asignado.");
            return;
        }

        if (!despachado) {
            despachado = true;
            historialEntregas.add(
                    getClass().getSimpleName()
                    + " #" + String.format("%03d", idPedido)
                    + " - entregado por " + repartidorAsignado
            );
        }
    }

    @Override
    public void cancelar() {
        if (!despachado) {
            cancelado = true;
        }
    }

    @Override
    public void verHistorial() {
        System.out.println("Historial de entregas:");
        if (historialEntregas.isEmpty()) {
            System.out.println("- No existen entregas registradas.");
            return;
        }

        for (String registro : historialEntregas) {
            System.out.println("- " + registro);
        }
    }
}
