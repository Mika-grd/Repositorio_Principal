package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

public abstract class Vehiculo {

    private String placa;
    private String modelo;
    private String marca;
    private String color;
    private LinkedList<Viaje> listaViajes;



    /**
     * Metodo para eliminar un viaje de la lista de viajes
     * @param {Viaje} viaje - viaje a eliminar
     */
    public void eliminarViaje(Viaje viaje){
        listaViajes.remove(viaje);
    }

        //Constructor
    public Vehiculo(String placa, String modelo, String marca, String color, LinkedList<Viaje> listaViajes) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.listaViajes = listaViajes;
    }


    //Getters & Setters

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LinkedList<Viaje> getListaViajes() {
        return listaViajes;
    }

    public void setListaViajes(LinkedList<Viaje> listaViajes) {
        this.listaViajes = listaViajes;
    }

    
}
