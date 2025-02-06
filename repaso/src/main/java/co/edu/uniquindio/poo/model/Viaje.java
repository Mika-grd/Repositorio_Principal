package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Viaje {

    private LocalDate fecha;
    private String id;
    private TipoViaje tipo;
    private float pesoCarga;
    private int numeroPasajeros;


    public Viaje(LocalDate fecha, String id, TipoViaje tipo, float pesoCarga) {
        this.fecha = fecha;
        this.id = id;
        this.tipo = tipo;
        this.pesoCarga = pesoCarga;

    }
    public Viaje(LocalDate fecha, String id, TipoViaje tipo, int numeroPasajeros) {
        this.fecha = fecha;
        this.id = id;
        this.tipo = tipo;
        this.numeroPasajeros = numeroPasajeros;

    }

//Getters & Setters
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public TipoViaje getTipo() {
        return tipo;
    }
    public void setTipo(TipoViaje tipo) {
        this.tipo = tipo;
    }
    public float getPesoCarga() {
        return pesoCarga;
    }
    public void setPesoCarga(float pesoCarga) {
        this.pesoCarga = pesoCarga;
    }
    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }
    public void setNumeroPasajeros(int numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
    }

    
}
