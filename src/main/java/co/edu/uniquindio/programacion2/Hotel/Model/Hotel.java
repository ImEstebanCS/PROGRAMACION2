package co.edu.uniquindio.programacion2.Hotel.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Hotel {
    private Scanner scanner;
    private Collection<Reserva>reservas=new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }
    public Hotel() {
        this.scanner = new Scanner(System.in);
    }
public void inicializarDatos(){
    System.out.println("Inicializando datos");

}
/*
/METODO PARA RESERVAR
/
 */
    public void reservar() {
        System.out.println("Por favor ingrese su nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Por favor ingrese su DNI:");
        String dni = scanner.nextLine();

        System.out.println("Por favor ingrese la cantidad de reservas que tiene:");
        int cantidadReservas = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Por favor ingrese la fecha de entrada (en formato YYYY-MM-DD):");
        String fechaEntrada = scanner.nextLine();

        System.out.println("Por favor ingrese la fecha de salida (en formato YYYY-MM-DD):");
        String fechaSalida = scanner.nextLine();

        Cliente cliente = new Cliente(nombre, dni, cantidadReservas);
        Reserva reserva = new Reserva(fechaEntrada, fechaSalida);
        reservas.add(reserva);

        // Aquí puedes agregar la lógica para almacenar o procesar la reserva y el cliente

        System.out.println("Reserva realizada con éxito.");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Reserva desde " + reserva.getFechaEntrada() + " hasta " + reserva.getFechaSalida());

    }
    public void mostrarReservas() {
        System.out.println("Listado de reservas:");
        for (Reserva reserva : reservas) {
            System.out.println("Reserva desde " + reserva.getFechaEntrada() + " hasta " + reserva.getFechaSalida());
        }
    }


}
