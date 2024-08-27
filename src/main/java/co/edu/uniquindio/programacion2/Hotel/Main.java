package co.edu.uniquindio.programacion2.Hotel;

import java.util.Scanner;

import co.edu.uniquindio.programacion2.Hotel.Model.Hotel;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();
        menu(hotel, scanner);
        scanner.close();
    }

    public static void menu(Hotel hotel, Scanner scanner) {
        int option = 0;
        while (option != 5) {
            mostrarMenu();
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    hotel.reservar();
                    break;
                case 2:
                    hotel.mostrarReservas();
                    break;
                case 3:
                    hotel.serviciosCliente();
                    break;
                case 4:
                    hotel.mostrarServiciosCliente();
                    break;
                case 5:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }

        }
    }

    public static void mostrarMenu(){
        System.out.println("--------------------------------");
        System.out.println("Por favor seleccione la opción que desea:");
        System.out.println("1. Reservar");
        System.out.println("2. Mostrar lista de reservas");
        System.out.println("3. Agregar servicios al cliente");
        System.out.println("4. Mostrar lista de servicios según cliente");
        System.out.println("5. Salir");
        System.out.println("--------------------------------");
    }

    
}

