package co.edu.uniquindio.programacion2.Hotel.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.edu.uniquindio.programacion2.Hotel.Services.TipoHabitacion;

public class Hotel {
    
    private List<Reserva> reservas = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    

    public Hotel() {
    }

    public void inicializarDatos() {
        System.out.println("Inicializando datos");
    }

    public void agregarReserva(Reserva reserva){
        this.reservas.add(reserva);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    /*
     * MÉTODO PARA RESERVAR
     */
    public void reservar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor ingrese su nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Por favor ingrese su DNI:");
        String dni = scanner.nextLine();

        Cliente cliente = buscarClientePorDni(dni);
        if (cliente == null) {
            cliente = new Cliente(nombre, dni);
            clientes.add(cliente);
        }

        System.out.println("Por favor ingrese la fecha de entrada (en formato YYYY-MM-DD):");
        String fechaEntrada = scanner.nextLine();

        System.out.println("Por favor ingrese la fecha de salida (en formato YYYY-MM-DD):");
        String fechaSalida = scanner.nextLine();

        System.out.println("Por favor ingrese el número de la habitación:");
        Integer numeroHabitacion = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Por favor ingrese el tipo de habitación \nSimple\nDoble\nSuite");
        String tipoDeHabitacion = scanner.nextLine();
        TipoHabitacion tipoHabitacion;
        switch (tipoDeHabitacion.toLowerCase()) {
            case "simple" -> tipoHabitacion = TipoHabitacion.SIMPLE;
            case "doble" -> tipoHabitacion = TipoHabitacion.DOBLE;
            case "suite" -> tipoHabitacion = TipoHabitacion.SUITE;
            default -> {
                System.out.println("Tipo de habitación no válida, se asignará Habitación SIMPLE por defecto");
                tipoHabitacion = TipoHabitacion.SIMPLE;
            }
        }

        System.out.println("Por favor ingrese el precio de la habitación:");
        float precio = scanner.nextFloat();
        scanner.nextLine();

        Reserva reserva = new Reserva(fechaEntrada, fechaSalida, new Habitacion(numeroHabitacion, tipoHabitacion, precio));
        cliente.agregarReserva(reserva);
        reservas.add(reserva);

        System.out.println("Reserva realizada con éxito.");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Reserva desde " + reserva.getFechaEntrada() + " hasta " + reserva.getFechaSalida());
        System.out.println("Tipo de habitación:" + tipoHabitacion);
        System.out.println("Precio:" + precio);
    }

    /*
     * MÉTODO PARA MOSTRAR RESERVAS
     */
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

    /*
     * MÉTODO PARA ASOCIAR SERVICIOS AL CLIENTE
     */

     public void serviciosCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el DNI del cliente: ");
        String dni = scanner.nextLine();

        Cliente cliente = buscarClientePorDni(dni);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.println("Ingrese el número de habitación: ");
        int numeroHabitacion = scanner.nextInt();
        scanner.nextLine();

        Habitacion habitacion = buscarHabitacionPorNumero(cliente, numeroHabitacion);
        if (habitacion == null) {
            System.out.println("Habitación no encontrada para el cliente dado.");
            return;
        }

        boolean continuar = true;
        while (continuar) {
            System.out.println("Ingrese el servicio a consumir (spa, restaurante, limpieza, otro): ");
            String servicioNombre = scanner.nextLine().trim().toLowerCase();
        
            Servicio servicio = null;
            switch (servicioNombre) {
                case "spa" -> servicio = Servicio.spa();
                case "restaurante" -> servicio = Servicio.restaurante();
                case "limpieza" -> servicio = Servicio.limpieza();
                case "otro" -> {
                    servicio = new ServicioDeHabitacion();
                    servicio.consumir();
                }
                default -> {
                    System.out.println("Servicio no válido.");
                    continue; // Continuar al siguiente ciclo del bucle
                }
            }
        
            System.out.println("----------------------------------------");
            if (servicio != null) {
                habitacion.agregarServicio(servicio);
                System.out.println("Servicio agregado: " + servicio.getNombre());
            }
            System.out.println("----------------------------------------");
        
            // Preguntar al usuario si desea agregar otro servicio
            System.out.println("¿Desea agregar otro servicio? (si/no): ");
            String respuesta = scanner.nextLine().toLowerCase();
            continuar = respuesta.equals("si");
        }
    }

    public void mostrarServiciosCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el DNI del cliente: ");
        String dni = scanner.nextLine();

        Cliente cliente = buscarClientePorDni(dni);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.println("Ingrese el número de habitación: ");
        int numeroHabitacion = scanner.nextInt();
        scanner.nextLine(); 

        Habitacion habitacion = buscarHabitacionPorNumero(cliente, numeroHabitacion);
        if (habitacion == null) {
            System.out.println("Habitación no encontrada para el cliente dado.");
            return;
        }

        System.out.println("----------------------------------------");
        System.out.println("Servicios consumidos en la habitación " + numeroHabitacion + ":");
        for (Servicio servicio : habitacion.getServicios()) {
            System.out.println("- " + servicio.getNombre());
        }
        System.out.println("----------------------------------------");
    }
    /*
     * MÉTODO PARA BUSCAR CLIENTE POR DNI
     */
    private Cliente buscarClientePorDni(String dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                return cliente;
            }
        }
        return null;
    }

    /*
     * MÉTODO PARA BUSCAR HABITACION POR NUMERO
     */

    private Habitacion buscarHabitacionPorNumero(Cliente cliente, int numeroHabitacion) {
        for (Reserva reserva : cliente.getReservas()) {
            Habitacion habitacion = reserva.getHabitacion();
            if (habitacion.getNumeroHabitacion() == numeroHabitacion) {
                return habitacion;
            }
        }
        return null; 
    }
}
