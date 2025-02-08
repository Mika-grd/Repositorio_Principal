package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.LinkedList;

public class Reporte {

    private String id;
    private LinkedList<Transaccion> listaTransacciones;
    private Empleado empleado;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;

    public LinkedList<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(LinkedList<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Reporte(String id, LinkedList<Transaccion> listaTransacciones, Empleado empleado, LocalDate fechaInicio,
            LocalDate fechaFinal) {
        this.id = id;
        for (Transaccion transaccion : listaTransacciones) {
            if (!transaccion.getFecha().isAfter(fechaInicio) || !transaccion.getFecha().isBefore(fechaFinal)) {
                listaTransacciones.remove(transaccion);
            }
        }
        this.listaTransacciones = listaTransacciones;
        this.empleado = empleado;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    
}
