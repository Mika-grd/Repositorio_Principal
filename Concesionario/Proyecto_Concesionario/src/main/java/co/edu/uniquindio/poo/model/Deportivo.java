package co.edu.uniquindio.poo.model;

public class Deportivo extends Carro {
    private int numeroCaballosDeFuerza;
    private double tiempoParaAlcanzar100KmH;
    
    public Deportivo(String matricula, String marca, String modelo, boolean esNuevo, int numeroCambios,
            double velocidadMaxima, String cilindraje, double precio, double precioDia, boolean disponibilidad,
            Transmision transmision, Combustible combustible, int numeroDePasajeros, int númeroDePuertas,
            double capacidadDelMaletero, boolean tieneAireAcondicionado, boolean tieneCámaraDeReversa,
            int númeroDeBolsasDeAire, boolean tieneABS, int numeroCaballosDeFuerza, double tiempoParaAlcanzar100KmH) {
        super(matricula, marca, modelo, esNuevo, numeroCambios, velocidadMaxima, cilindraje, precio, precioDia,
                disponibilidad, transmision, combustible, numeroDePasajeros, númeroDePuertas, capacidadDelMaletero,
                tieneAireAcondicionado, tieneCámaraDeReversa, númeroDeBolsasDeAire, tieneABS);
        this.numeroCaballosDeFuerza = numeroCaballosDeFuerza;
        this.tiempoParaAlcanzar100KmH = tiempoParaAlcanzar100KmH;
    }

    public int getNumeroCaballosDeFuerza() {
        return numeroCaballosDeFuerza;
    }

    public void setNumeroCaballosDeFuerza(int numeroCaballosDeFuerza) {
        this.numeroCaballosDeFuerza = numeroCaballosDeFuerza;
    }

    public double getTiempoParaAlcanzar100KmH() {
        return tiempoParaAlcanzar100KmH;
    }

    public void setTiempoParaAlcanzar100KmH(double tiempoParaAlcanzar100KmH) {
        this.tiempoParaAlcanzar100KmH = tiempoParaAlcanzar100KmH;
    }

    @Override
    public String toString() {
        return "Deportivo [numeroCaballosDeFuerza=" + numeroCaballosDeFuerza + ", tiempoParaAlcanzar100KmH="
                + tiempoParaAlcanzar100KmH + ", getNumeroCaballosDeFuerza()=" + getNumeroCaballosDeFuerza()
                + ", getMarca()=" + getMarca() + ", getModelo()=" + getModelo() + ", isEsNuevo()=" + isEsNuevo()
                + ", getNumeroDePasajeros()=" + getNumeroDePasajeros() + ", getNumeroCambios()=" + getNumeroCambios()
                + ", getTiempoParaAlcanzar100KmH()=" + getTiempoParaAlcanzar100KmH() + ", getVelocidadMaxima()="
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