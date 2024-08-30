package co.edu.uniquindio.programacion2.Hotel.Model;

import java.util.ArrayList;
import java.util.List;

public class Habitacion {
    private int numeroHabitacion;
    private String tipoHabitacion;
    private float precio;
    private final List<Servicio> servicios = new ArrayList<>();

    public Habitacion(int numeroHabitacion, String tipoHabitacion, float precio) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.precio = precio;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(Integer numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void agregarServicio(Servicio servicio) {
        this.servicios.add(servicio);
    }



    public List<Servicio> getServicios() {
        return servicios;
    }

    @Override
    public String toString() {
        return "Habitación número " + numeroHabitacion + " (" + tipoHabitacion + ") - Precio: $" + precio +
                "\nServicios: " + servicios;
    }
}
