package co.edu.uniquindio.programacion2.Hotel.Model;

import java.util.ArrayList;
import java.util.List;

import co.edu.uniquindio.programacion2.Hotel.Services.TipoHabitacion;

public class Habitacion {
    private Integer numeroHabitacion;
    private TipoHabitacion tipoHabitacion;
    private float precio;
    private List<Servicio> servicios;

    public Habitacion(Integer numeroHabitacion, TipoHabitacion tipoHabitacion, float precio) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.precio = precio;
        this.servicios = new ArrayList<>();
    }

    public Integer getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(Integer numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
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
