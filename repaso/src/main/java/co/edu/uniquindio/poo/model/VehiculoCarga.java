package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.LinkedList;

public class VehiculoCarga extends Vehiculo {

    private float capacidad;
    private int numeroEjes;
    

    /**
     *  Metodo para hacer un viaje con el peso de la carga
     * @param fecha
     * @param id
     * @param tipo
     * @param pesoCarga
     */
    public void hacerViaje(LocalDate fecha, String id, TipoViaje tipo, float pesoCarga){
        Viaje newViaje = new Viaje(fecha, id, tipo, pesoCarga);
        getListaViajes().add(newViaje);
    }

        //Constructor
    public VehiculoCarga(String placa, String modelo, String marca, String color, LinkedList<Viaje> listaViajes,
            float capacidad, int numeroEjes) {
        super(placa, modelo, marca, color, listaViajes);
        this.capacidad = capacidad;
        this.numeroEjes = numeroEjes;
    }

    //Getters & Setters
    public float getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(float capacidad) {
        this.capacidad = capacidad;
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }

    public void setNumeroEjes(int numeroEjes) {
        this.numeroEjes = numeroEjes;
    }


}
