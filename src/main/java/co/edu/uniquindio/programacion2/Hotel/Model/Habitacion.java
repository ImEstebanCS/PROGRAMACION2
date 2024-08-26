package co.edu.uniquindio.programacion2.Hotel.Model;

import co.edu.uniquindio.programacion2.Hotel.Services.TipoHabitacion;

public class Habitacion {
    private Integer numero;
    private TipoHabitacion tipoHabitacion;
    private float precio;
    
    public Habitacion(Integer numero, TipoHabitacion tipoHabitacion, float precio) {
        this.numero=numero;
        this.tipoHabitacion=tipoHabitacion;
        this.precio=precio;

    }
    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
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
    




}
