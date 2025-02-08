package co.edu.uniquindio.poo.model;

public abstract class Vehiculo {
    private String matricula;
    private String marca;
    private String modelo;
    private boolean esNuevo;
    private int numeroCambios;
    private double velocidadMaxima;
    private String cilindraje;
    private double precio;
    private double precioDia;
    private boolean disponibilidad;
    private Transmision transmision;
    private Combustible combustible;

    public Vehiculo(String matricula, String marca, String modelo, boolean esNuevo, int numeroCambios,
            double velocidadMaxima,
            String cilindraje, double precio, double precioDia, boolean disponibilidad, Transmision transmision,
            Combustible combustible) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.esNuevo = esNuevo;
        this.numeroCambios = numeroCambios;
        this.velocidadMaxima = velocidadMaxima;
        this.cilindraje = cilindraje;
        this.precio = precio;
        this.disponibilidad = true;
        this.transmision = transmision;
        this.combustible = combustible;
        this.precioDia = precioDia;
    }



    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public boolean isEsNuevo() {
        return esNuevo;
    }

    public int getNumeroCambios() {
        return numeroCambios;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public Transmision getTransmision() {
        return transmision;
    }

    public Combustible getCombustible() {
        return combustible;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setEsNuevo(boolean esNuevo) {
        this.esNuevo = esNuevo;
    }

    public void setNumeroCambios(int numeroCambios) {
        this.numeroCambios = numeroCambios;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public double getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(double precioDia) {
        this.precioDia = precioDia;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public void setTransmision(Transmision transmision) {
        this.transmision = transmision;
    }

    public void setCombustible(Combustible combustible) {
        this.combustible = combustible;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", esNuevo=" + esNuevo
                + ", numeroCambios=" + numeroCambios + ", velocidadMaxima=" + velocidadMaxima + ", cilindraje="
                + cilindraje + ", precio=" + precio + ", precioDia=" + precioDia + ", disponibilidad=" + disponibilidad
                + ", transmision=" + transmision + ", combustible=" + combustible + "]";
    }

    
}