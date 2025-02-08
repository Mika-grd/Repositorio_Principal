package co.edu.uniquindio.poo.model;

public class Carro extends Vehiculo {
    private int numeroDePasajeros;
    private int númeroDePuertas;
    private double capacidadDelMaletero;
    private boolean tieneAireAcondicionado;
    private boolean tieneCámaraDeReversa;
    private int númeroDeBolsasDeAire;
    private boolean tieneABS;

    public Carro(String matricula, String marca, String modelo, boolean esNuevo, int numeroCambios,
            double velocidadMaxima, String cilindraje, double precio, double precioDia, boolean disponibilidad, Transmision transmision,
            Combustible combustible, int numeroDePasajeros, int númeroDePuertas, double capacidadDelMaletero,
            boolean tieneAireAcondicionado, boolean tieneCámaraDeReversa, int númeroDeBolsasDeAire, boolean tieneABS) {
        super(matricula, marca, modelo, esNuevo, numeroCambios, velocidadMaxima, cilindraje, precio, precioDia, disponibilidad,
                transmision, combustible);
        this.numeroDePasajeros = numeroDePasajeros;
        this.númeroDePuertas = númeroDePuertas;
        this.capacidadDelMaletero = capacidadDelMaletero;
        this.tieneAireAcondicionado = tieneAireAcondicionado;
        this.tieneCámaraDeReversa = tieneCámaraDeReversa;
        this.númeroDeBolsasDeAire = númeroDeBolsasDeAire;
        this.tieneABS = tieneABS;
    }

    public int getNumeroDePasajeros() {
        return numeroDePasajeros;
    }

    public void setNumeroDePasajeros(int numeroDePasajeros) {
        this.numeroDePasajeros = numeroDePasajeros;
    }

    public int getNúmeroDePuertas() {
        return númeroDePuertas;
    }

    public void setNúmeroDePuertas(int númeroDePuertas) {
        this.númeroDePuertas = númeroDePuertas;
    }

    public double getCapacidadDelMaletero() {
        return capacidadDelMaletero;
    }

    public void setCapacidadDelMaletero(double capacidadDelMaletero) {
        this.capacidadDelMaletero = capacidadDelMaletero;
    }

    public boolean isTieneAireAcondicionado() {
        return tieneAireAcondicionado;
    }

    public void setTieneAireAcondicionado(boolean tieneAireAcondicionado) {
        this.tieneAireAcondicionado = tieneAireAcondicionado;
    }

    public boolean isTieneCámaraDeReversa() {
        return tieneCámaraDeReversa;
    }

    public void setTieneCámaraDeReversa(boolean tieneCámaraDeReversa) {
        this.tieneCámaraDeReversa = tieneCámaraDeReversa;
    }

    public int getNúmeroDeBolsasDeAire() {
        return númeroDeBolsasDeAire;
    }

    public void setNúmeroDeBolsasDeAire(int númeroDeBolsasDeAire) {
        this.númeroDeBolsasDeAire = númeroDeBolsasDeAire;
    }

    public boolean isTieneABS() {
        return tieneABS;
    }

    public void setTieneABS(boolean tieneABS) {
        this.tieneABS = tieneABS;
    }

}
