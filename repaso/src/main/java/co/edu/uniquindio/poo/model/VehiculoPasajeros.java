package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.LinkedList;

public class VehiculoPasajeros extends Vehiculo {

    private int capacidad;

    /**
     *  Metodo para hacer un viaje con el numero de pasajeros
     * @param fecha
     * @param id
     * @param tipo
     * @param numeroPasajeros
     */
    public void hacerViaje(LocalDate fecha, String id, TipoViaje tipo, int numeroPasajeros){
        Viaje newViaje = new Viaje(fecha, id, tipo, numeroPasajeros);
        getListaViajes().add(newViaje);
    }

    //Constructor
    public VehiculoPasajeros(String placa, String modelo, String marca, String color, LinkedList<Viaje> listaViajes,
            int capacidad) {
        super(placa, modelo, marca, color, listaViajes);
        this.capacidad = capacidad;
    }
    
    //Setters & Getters
    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

}
