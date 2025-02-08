package co.edu.uniquindio.poo.model;

public class PickUp extends Carro {
    private boolean es4x4;
    private double capacidadCajaDeCarga;

    

    public PickUp(String matricula, String marca, String modelo, boolean esNuevo, int numeroCambios,
            double velocidadMaxima, String cilindraje, double precio, double precioDia, boolean disponibilidad,
            Transmision transmision, Combustible combustible, int numeroDePasajeros, int númeroDePuertas,
            double capacidadDelMaletero, boolean tieneAireAcondicionado, boolean tieneCámaraDeReversa,
            int númeroDeBolsasDeAire, boolean tieneABS, boolean es4x4, double capacidadCajaDeCarga) {
        super(matricula, marca, modelo, esNuevo, numeroCambios, velocidadMaxima, cilindraje, precio, precioDia,
                disponibilidad, transmision, combustible, numeroDePasajeros, númeroDePuertas, capacidadDelMaletero,
                tieneAireAcondicionado, tieneCámaraDeReversa, númeroDeBolsasDeAire, tieneABS);
        this.es4x4 = es4x4;
        this.capacidadCajaDeCarga = capacidadCajaDeCarga;
    }

    public boolean isEs4x4() {
        return es4x4;
    }

    public void setEs4x4(boolean es4x4) {
        this.es4x4 = es4x4;
    }

    public double getCapacidadCajaDeCarga() {
        return capacidadCajaDeCarga;
    }

    public void setCapacidadCajaDeCarga(double capacidadCajaDeCarga) {
        this.capacidadCajaDeCarga = capacidadCajaDeCarga;
    }

    @Override
    public String toString() {
        return "PickUp [es4x4=" + es4x4 + ", capacidadCajaDeCarga=" + capacidadCajaDeCarga + ", isEs4x4()=" + isEs4x4()
                + ", getMarca()=" + getMarca() + ", getCapacidadCajaDeCarga()=" + getCapacidadCajaDeCarga()
                + ", getModelo()=" + getModelo() + ", isEsNuevo()=" + isEsNuevo() + ", getNumeroDePasajeros()="
                + getNumeroDePasajeros() + ", getNumeroCambios()=" + getNumeroCambios() + ", getVelocidadMaxima()="
                + getVelocidadMaxima() + ", getCilindraje()=" + getCilindraje() + ", getNúmeroDePuertas()="
                + getNúmeroDePuertas() + ", getPrecio()=" + getPrecio() + ", isDisponibilidad()=" + isDisponibilidad()
                + ", getCapacidadDelMaletero()=" + getCapacidadDelMaletero() + ", getTransmision()=" + getTransmision()
                + ", getCombustible()=" + getCombustible() + ", isTieneAireAcondicionado()="
                + isTieneAireAcondicionado() + ", isTieneCámaraDeReversa()=" + isTieneCámaraDeReversa()
                + ", getClass()=" + getClass() + ", getNúmeroDeBolsasDeAire()=" + getNúmeroDeBolsasDeAire()
                + ", getPrecioDia()=" + getPrecioDia() + ", isTieneABS()=" + isTieneABS() + ", getMatricula()="
                + getMatricula() + ", toString()=" + super.toString() + ", hashCode()=" + hashCode() + "]";
    }

    
}