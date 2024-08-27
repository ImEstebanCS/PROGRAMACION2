package co.edu.uniquindio.programacion2.Hotel.Model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String dni;
    
    private List<Reserva> reservas;
    
    public Cliente(){}

    public Cliente(String nombre, String dni){
        this.nombre=nombre;
        this.dni=dni;
        
        this.reservas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void agregarReserva(Reserva reserva){
        this.reservas.add(reserva);
    }

    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + ", dni=" + dni + ", reservas=" + reservas + "]";
    }

    

}
