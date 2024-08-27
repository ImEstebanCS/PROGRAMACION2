package co.edu.uniquindio.programacion2.Hotel.Model;

public class Servicio implements Consumible {
    private String nombre;
    

    public Servicio(String nombre) {
        this.nombre = nombre;
    
    }
    public Servicio(){

    }

    public String getNombre() {
        return nombre;
    }

    

    public static Servicio spa() {
        return new Servicio("Spa");
    }

    public static Servicio restaurante() {
        return new Servicio("Restaurante");
    }

    public static Servicio limpieza() {
        return new Servicio("Limpieza");
    }

    @Override
    public void consumir() {
        System.out.println("El servicio " + nombre + " ha sido consumido.");
    }

    @Override
    public String toString() {
        return "nombre:"+nombre ;
    }
}
