package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Transaccion {

    private TipoTransaccion tipo;
    private Vehiculo vehiculo;
    private Cliente cliente;
    private Empleado empleado;
    private LocalDate fecha;
    private double valor;

    public Transaccion(TipoTransaccion tipo, Vehiculo vehiculo, Cliente cliente, Empleado empleado, LocalDate fecha,
            double valor) {
        this.tipo = tipo;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.empleado = empleado;
        this.fecha = fecha;
        this.valor = valor;
    }
    public TipoTransaccion getTipo() {
        return tipo;
    }
    @Override
    public String toString() {
        return "Transaccion [tipo=" + tipo + ", vehiculo=" + vehiculo + ", cliente=" + cliente +  " fecha=" + fecha + ", valor=" + valor + "]";
    }
    public void setTipo(TipoTransaccion tipo) {
        this.tipo = tipo;
    }
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Empleado getEmpleado() {
        return empleado;
    }
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

}
