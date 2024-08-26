package co.edu.uniquindio.programacion2.Hotel.Model;

import co.edu.uniquindio.programacion2.Hotel.Services.TipoHabitacion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Hotel {
    private Scanner scanner;
    private Collection<Reserva>reservas=new ArrayList<>();
    private  Collection<Cliente>clientes=new ArrayList<>();
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

        System.out.println("Por favor ingrese el número de la habitación:");
        Integer numero = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Por favor ingrese el tipo de habitación \nSimple\nDoble\nSuite");
        String tipoDeHabitacion = scanner.nextLine();
        TipoHabitacion tipoHabitacion;
        switch (tipoDeHabitacion){
            case "simple":
                tipoHabitacion = TipoHabitacion.SIMPLE;
                break;
            case "doble":
                tipoHabitacion = TipoHabitacion.DOBLE;
                break;
            case "suite":
                tipoHabitacion = TipoHabitacion.SUITE;
                break;
            default:
                System.out.println("Tipo de habitación no valida, se le asignará el tipo de Habitación (SIMPLE) por defecto");
                tipoHabitacion = TipoHabitacion.SIMPLE;
                break;


        }
        System.out.println("Por favor ingrese el precio de la habitación:");
        float precio = scanner.nextFloat();
        scanner.nextLine();




        Cliente cliente = new Cliente(nombre, dni, cantidadReservas);
        Reserva reserva = new Reserva(fechaEntrada, fechaSalida,new Habitacion(numero,tipoHabitacion,precio));
        reservas.add(reserva);
        clientes.add(cliente);



        System.out.println("Reserva realizada con éxito.");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Reserva desde " + reserva.getFechaEntrada() + " hasta " + reserva.getFechaSalida());
        System.out.println("Tipo de habitación:"+tipoHabitacion);
        System.out.println("Precio:"+precio);

    }
    /*
    METODO PARA MOSTRAR RESERVAS
     */
    public void mostrarReservas() {
        System.out.println("Listado de reservas:");
        for(Cliente cliente : clientes){
            System.out.println("--------------------------------------");
            System.out.println("Nombre de la persona que reserva:"+cliente.getNombre());
            for (Reserva reserva : reservas) {
                System.out.println("Reserva desde " + reserva.getFechaEntrada() + " hasta " + reserva.getFechaSalida());
                System.out.println("--------------------------------------");
            }
        }


    }



}
