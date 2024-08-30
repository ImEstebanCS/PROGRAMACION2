package co.edu.uniquindio.programacion2.Hotel.Model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


public class Hotel {
    private String nombre;
    private List<Reserva> reservas = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    public Hotel() {
    }

    public Hotel(String nombre){
        this.nombre = nombre;
    }

    public void agregarReserva(Reserva reserva){
        this.reservas.add(reserva);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void reservar(Cliente cliente, Reserva reserva) {
        cliente.agregarReserva(reserva);
        reservas.add(reserva);
        mostrarConfirmacion(cliente, reserva);
    }

    private void mostrarConfirmacion(Cliente cliente, Reserva reserva) {
        System.out.println("Reserva realizada con éxito.");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Reserva desde " + reserva.getFechaEntrada() + " hasta " + reserva.getFechaSalida());
        System.out.println("Tipo de habitación: " + reserva.getHabitacion());
        System.out.println("Precio: " + reserva.getHabitacion().getPrecio());
    }

    public void serviciosCliente(Cliente cliente, int numeroHabitacion, List<Servicio> servicios) {
        Habitacion habitacion = buscarHabitacionNumero(cliente, numeroHabitacion);
        verificarHabitacionExiste(habitacion);

        if (habitacion != null) {
            for (Servicio servicio : servicios) {
                habitacion.agregarServicio(servicio);
                System.out.println("Servicio agregado: " + servicio.getNombre());
            }
        }
    }

    public void mostrarServicios() {
        System.out.println("1 - Servicio Spa");
        System.out.println("2 - Servicio Restaurante");
        System.out.println("3 - Servicio Limpieza");
        System.out.println("4 - Otro Servicio");
    }

    public void menuServicios(Habitacion habitacion, int opcion){
        Servicio servicio = null;
        switch (opcion) {
            case 1:
                servicio = Servicio.spa();
                break;
            case 2:
                servicio = Servicio.restaurante();
                break;
            case 3:
                servicio = Servicio.limpieza();
                break;
            case 4:
                servicio = new ServicioHabitacion();
                servicio.consumir();
                break;
            default:
                System.out.println("Servicio no válido.");
                return;
        }

        if (servicio != null) {
            habitacion.agregarServicio(servicio);
            System.out.println("Servicio agregado: " + servicio.getNombre());
        }
    }

    public void mostrarReservas() {
        System.out.println("Listado de reservas:");
        for (Cliente cliente : clientes) {
            System.out.println("--------------------------------------");
            System.out.println("Nombre del cliente: " + cliente.getNombre());
            for (Reserva reserva : cliente.getReservas()) {
                System.out.println("Reserva desde " + reserva.getFechaEntrada() + " hasta " + reserva.getFechaSalida());
            }
            System.out.println("--------------------------------------");
        }
    }

    public void mostrarServiciosCliente(Cliente cliente, int numeroHabitacion) {
        verificarClienteExiste(cliente);
        Habitacion habitacion = buscarHabitacionNumero(cliente, numeroHabitacion);
        verificarHabitacionExiste(habitacion);

        if (habitacion != null) {
            System.out.println("----------------------------------------");
            System.out.println("Servicios consumidos en la habitación " + numeroHabitacion + ":");
            serviciosConsumidosHabitacion(habitacion);
            System.out.println("----------------------------------------");
        }
    }

    public void serviciosConsumidosHabitacion(Habitacion habitacion){
        for (Servicio servicio : habitacion.getServicios()) {
            System.out.println("- " + servicio.getNombre());
        }
    }

    public void verificarClienteExiste(Cliente cliente){
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
        }
    }

    public void verificarHabitacionExiste(Habitacion habitacion){
        if (habitacion == null) {
            System.out.println("Habitación no encontrada para el cliente dado.");
        }
    }

    public Habitacion buscarHabitacionNumero(Cliente cliente, int numeroHabitacion) {
        for (Reserva reserva : cliente.getReservas()) {
            Habitacion habitacion = reserva.getHabitacion();
            if (habitacion.getNumeroHabitacion() == numeroHabitacion) {
                return habitacion;
            }
        }
        return null;
    }

    public void costoEstadia(Cliente cliente, Reserva reserva) {
        int dias = calcularDias(reserva);
        float costo = reserva.getHabitacion().getPrecio();
        float costoTotal = dias * costo;

        System.out.println("El costo de la estadía es: " + costoTotal + " , espero que vuelvas =). ");
    }

    public int calcularDias(Reserva reserva){
        long diferenciaDias = calcularDiferenciaDias(reserva.getFechaEntrada(), reserva.getFechaSalida());
        return (int) diferenciaDias;
    }

    public long calcularDiferenciaDias(LocalDateTime fechaInicial, LocalDateTime fechaFinal) {
        return ChronoUnit.DAYS.between(fechaInicial, fechaFinal);
    }
}
