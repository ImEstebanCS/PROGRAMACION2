package co.edu.uniquindio.programacion2.Hotel.Model;

public class Reserva {
    private String fechaEntrada;
    private String fechaSalida;
    public Reserva(String fechaEntrada, String fechaSalida) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida=fechaSalida;
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
}
