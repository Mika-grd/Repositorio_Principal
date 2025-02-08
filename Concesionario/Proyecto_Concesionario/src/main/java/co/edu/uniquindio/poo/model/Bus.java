package co.edu.uniquindio.poo.model;

public class Bus extends Carro {
    private int númeroDeEjes;
    private int númeroDeSalidasDeEmergencia;

    

    public Bus(String matricula, String marca, String modelo, boolean esNuevo, int numeroCambios,
            double velocidadMaxima, String cilindraje, double precio, double precioDia, boolean disponibilidad,
            Transmision transmision, Combustible combustible, int numeroDePasajeros, int númeroDePuertas,
            double capacidadDelMaletero, boolean tieneAireAcondicionado, boolean tieneCámaraDeReversa,
            int númeroDeBolsasDeAire, boolean tieneABS, int númeroDeEjes, int númeroDeSalidasDeEmergencia) {
        super(matricula, marca, modelo, esNuevo, numeroCambios, velocidadMaxima, cilindraje, precio, precioDia,
                disponibilidad, transmision, combustible, numeroDePasajeros, númeroDePuertas, capacidadDelMaletero,
                tieneAireAcondicionado, tieneCámaraDeReversa, númeroDeBolsasDeAire, tieneABS);
        this.númeroDeEjes = númeroDeEjes;
        this.númeroDeSalidasDeEmergencia = númeroDeSalidasDeEmergencia;
    }

    public int getNúmeroDeEjes() {
        return númeroDeEjes;
    }

    public void setNúmeroDeEjes(int númeroDeEjes) {
        this.númeroDeEjes = númeroDeEjes;
    }

    public int getNúmeroDeSalidasDeEmergencia() {
        return númeroDeSalidasDeEmergencia;
    }

    public void setNúmeroDeSalidasDeEmergencia(int númeroDeSalidasDeEmergencia) {
        this.númeroDeSalidasDeEmergencia = númeroDeSalidasDeEmergencia;
    }

    @Override
    public String toString() {
        return "Bus [númeroDeEjes=" + númeroDeEjes + ", númeroDeSalidasDeEmergencia=" + númeroDeSalidasDeEmergencia
                + ", getNúmeroDeEjes()=" + getNúmeroDeEjes() + ", getMarca()=" + getMarca() + ", getModelo()="
                + getModelo() + ", getNúmeroDeSalidasDeEmergencia()=" + getNúmeroDeSalidasDeEmergencia()
                + ", isEsNuevo()=" + isEsNuevo() + ", getNumeroDePasajeros()=" + getNumeroDePasajeros()
                + ", getNumeroCambios()=" + getNumeroCambios() + ", getVelocidadMaxima()=" + getVelocidadMaxima()
                + ", getCilindraje()=" + getCilindraje() + ", getNúmeroDePuertas()=" + getNúmeroDePuertas()
                + ", getPrecio()=" + getPrecio() + ", isDisponibilidad()=" + isDisponibilidad()
                + ", getCapacidadDelMaletero()=" + getCapacidadDelMaletero() + ", getTransmision()=" + getTransmision()
                + ", getCombustible()=" + getCombustible() + ", isTieneAireAcondicionado()="
                + isTieneAireAcondicionado() + ", isTieneCámaraDeReversa()=" + isTieneCámaraDeReversa()
                + ", getClass()=" + getClass() + ", getNúmeroDeBolsasDeAire()=" + getNúmeroDeBolsasDeAire()
                + ", getPrecioDia()=" + getPrecioDia() + ", isTieneABS()=" + isTieneABS() + ", getMatricula()="
                + getMatricula() + ", toString()=" + super.toString() + ", hashCode()=" + hashCode() + "]";
    }

}