package co.edu.uniquindio.programacion2.Hotel.Model;

public class ServicioHabitacion extends Servicio {

    public ServicioHabitacion() {
        super("Servicio de Habitación");
    }

    @Override
    public void consumir() {
        System.out.println("Servicio especial ha sido solicitado y será entregado a la habitación.");
    }
}
