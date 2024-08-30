package co.edu.uniquindio.programacion2.Hotel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Crear una instancia del hotel
        Hotel hotel = new Hotel("Hotel Ejemplo");
        inicializarDatos(hotel);  // Inicializar los datos quemados con la instancia del hotel
        mostrarMenu(hotel);  // Pasar la instancia del hotel al menú
    }

    // Método para inicializar datos quemados
    public static void inicializarDatos(Hotel hotel) {
        // Crear clientes
        Cliente cliente1 = new Cliente("Juan Pérez", "12345678");
        Cliente cliente2 = new Cliente("Maria Lopez", "87654321");

        // Crear habitaciones
        Habitacion habitacion1 = new Habitacion(101, "Simple", 50.0f);
        Habitacion habitacion2 = new Habitacion(102, "Doble", 75.0f);

        // Crear reservas
        Reserva reserva1 = new Reserva(LocalDateTime.now(), LocalDateTime.now().plusDays(3), habitacion1);
        Reserva reserva2 = new Reserva(LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(4), habitacion2);

        // Agregar reservas a clientes
        cliente1.agregarReserva(reserva1);
        cliente2.agregarReserva(reserva2);

        // Agregar clientes al hotel
        hotel.agregarCliente(cliente1);
        hotel.agregarCliente(cliente2);

        // Agregar reservas al hotel
        hotel.agregarReserva(reserva1);
        hotel.agregarReserva(reserva2);

        // Crear servicios
        Servicio servicio1 = new Servicio("Desayuno", 15.0f);
        Servicio servicio2 = new Servicio("Spa", 30.0f);

        // Agregar servicios a las habitaciones
        habitacion1.agregarServicio(servicio1);
        habitacion2.agregarServicio(servicio2);
    }

    // Mostrar menú y manejar opciones
    public static void mostrarMenu(Hotel hotel) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Mostrar todas las reservas");
            System.out.println("2. Mostrar servicios de un cliente en una habitación");
            System.out.println("3. Calcular costo de estadía");
            System.out.println("4. Agregar servicios a una habitación de un cliente");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    hotel.mostrarReservas();  // Llama al método para mostrar todas las reservas
                    break;
                case 2:
                    hotel.mostrarServiciosCliente(hotel.getClientes().get(0), 101);  // Utiliza datos quemados
                    break;
                case 3:
                    Cliente cliente = hotel.getClientes().get(1);
                    Reserva reserva = cliente.getReservas().get(0);
                    hotel.costoEstadia(cliente, reserva);  // Utiliza datos quemados
                    break;
                case 4:
                    List<Servicio> servicios = new ArrayList<>();
                    servicios.add(new Servicio("Room Service", 20.0f)); // Ejemplo de servicio adicional
                    hotel.serviciosCliente(hotel.getClientes().get(0), 101, servicios);  // Utiliza datos quemados
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
