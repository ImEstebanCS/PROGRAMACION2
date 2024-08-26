package co.edu.uniquindio.programacion2.Hotel.Model;

public class Cliente {
    private String nombre;
    private String dni;
    private Integer cantidadReservas;
    public Cliente(){}

    public Cliente(String nombre, String dni, Integer cantidadReservas){
        this.nombre=nombre;
        this.dni=dni;
        this.cantidadReservas=cantidadReservas;
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

    public Integer getCantidadReservas() {
        return cantidadReservas;
    }

    public void setCantidadReservas(Integer cantidadReservas) {
        this.cantidadReservas = cantidadReservas;
    }
}
