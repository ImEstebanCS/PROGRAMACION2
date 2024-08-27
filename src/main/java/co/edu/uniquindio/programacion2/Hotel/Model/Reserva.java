package co.edu.uniquindio.programacion2.Hotel.Model;

public class Reserva {
    private String fechaEntrada;
    private String fechaSalida;
    Habitacion habitacion;

    public Reserva(String fechaEntrada, String fechaSalida, Habitacion habitacion) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida=fechaSalida;
        this.habitacion= habitacion;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    
    @Override
    public String toString() {
        return "Reserva [fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", habitacion=" + habitacion
                + "]";
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    

    
}
