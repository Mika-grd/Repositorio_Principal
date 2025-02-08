package co.edu.uniquindio.poo.model;

public class SUV extends Carro {
    private boolean tieneVelocidadDeCrucero;
    private boolean tieneSensoresDeColision;
    private boolean tieneSensorDeTráficoCruzado;
    private boolean tieneAsistenteDePermanenciaEnElCarril;
    private boolean es4x4;

    

    public SUV(String matricula, String marca, String modelo, boolean esNuevo, int numeroCambios,
            double velocidadMaxima, String cilindraje, double precio, double precioDia, boolean disponibilidad,
            Transmision transmision, Combustible combustible, int numeroDePasajeros, int númeroDePuertas,
            double capacidadDelMaletero, boolean tieneAireAcondicionado, boolean tieneCámaraDeReversa,
            int númeroDeBolsasDeAire, boolean tieneABS, boolean tieneVelocidadDeCrucero,
            boolean tieneSensoresDeColision, boolean tieneSensorDeTráficoCruzado,
            boolean tieneAsistenteDePermanenciaEnElCarril, boolean es4x4) {
        super(matricula, marca, modelo, esNuevo, numeroCambios, velocidadMaxima, cilindraje, precio, precioDia,
                disponibilidad, transmision, combustible, numeroDePasajeros, númeroDePuertas, capacidadDelMaletero,
                tieneAireAcondicionado, tieneCámaraDeReversa, númeroDeBolsasDeAire, tieneABS);
        this.tieneVelocidadDeCrucero = tieneVelocidadDeCrucero;
        this.tieneSensoresDeColision = tieneSensoresDeColision;
        this.tieneSensorDeTráficoCruzado = tieneSensorDeTráficoCruzado;
        this.tieneAsistenteDePermanenciaEnElCarril = tieneAsistenteDePermanenciaEnElCarril;
        this.es4x4 = es4x4;
    }

    public boolean isTieneVelocidadDeCrucero() {
        return tieneVelocidadDeCrucero;
    }

    public void setTieneVelocidadDeCrucero(boolean tieneVelocidadDeCrucero) {
        this.tieneVelocidadDeCrucero = tieneVelocidadDeCrucero;
    }

    public boolean isTieneSensoresDeColision() {
        return tieneSensoresDeColision;
    }

    public void setTieneSensoresDeColision(boolean tieneSensoresDeColision) {
        this.tieneSensoresDeColision = tieneSensoresDeColision;
    }

    public boolean isTieneSensorDeTráficoCruzado() {
        return tieneSensorDeTráficoCruzado;
    }

    public void setTieneSensorDeTráficoCruzado(boolean tieneSensorDeTráficoCruzado) {
        this.tieneSensorDeTráficoCruzado = tieneSensorDeTráficoCruzado;
    }

    public boolean isTieneAsistenteDePermanenciaEnElCarril() {
        return tieneAsistenteDePermanenciaEnElCarril;
    }

    public void setTieneAsistenteDePermanenciaEnElCarril(boolean tieneAsistenteDePermanenciaEnElCarril) {
        this.tieneAsistenteDePermanenciaEnElCarril = tieneAsistenteDePermanenciaEnElCarril;
    }

    public boolean isEs4x4() {
        return es4x4;
    }

    public void setEs4x4(boolean es4x4) {
        this.es4x4 = es4x4;
    }

    @Override
    public String toString() {
        return "SUV [tieneVelocidadDeCrucero=" + tieneVelocidadDeCrucero + ", tieneSensoresDeColision="
                + tieneSensoresDeColision + ", tieneSensorDeTráficoCruzado=" + tieneSensorDeTráficoCruzado
                + ", tieneAsistenteDePermanenciaEnElCarril=" + tieneAsistenteDePermanenciaEnElCarril + ", es4x4="
                + es4x4 + ", getMarca()=" + getMarca() + ", getModelo()=" + getModelo() + ", isEsNuevo()=" + isEsNuevo()
                + ", getNumeroDePasajeros()=" + getNumeroDePasajeros() + ", getNumeroCambios()=" + getNumeroCambios()
                + ", getVelocidadMaxima()=" + getVelocidadMaxima() + ", getCilindraje()=" + getCilindraje()
                + ", getNúmeroDePuertas()=" + getNúmeroDePuertas() + ", isTieneVelocidadDeCrucero()="
                + isTieneVelocidadDeCrucero() + ", getPrecio()=" + getPrecio() + ", isDisponibilidad()="
                + isDisponibilidad() + ", getCapacidadDelMaletero()=" + getCapacidadDelMaletero()
                + ", getTransmision()=" + getTransmision() + ", getCombustible()=" + getCombustible()
                + ", isTieneSensoresDeColision()=" + isTieneSensoresDeColision() + ", isTieneAireAcondicionado()="
                + isTieneAireAcondicionado() + ", isTieneSensorDeTráficoCruzado()=" + isTieneSensorDeTráficoCruzado()
                + ", isTieneCámaraDeReversa()=" + isTieneCámaraDeReversa()
                + ", isTieneAsistenteDePermanenciaEnElCarril()=" + isTieneAsistenteDePermanenciaEnElCarril()
                + ", getClass()=" + getClass() + ", getNúmeroDeBolsasDeAire()=" + getNúmeroDeBolsasDeAire()
                + ", getPrecioDia()=" + getPrecioDia() + ", isTieneABS()=" + isTieneABS() + ", isEs4x4()=" + isEs4x4()
                + ", getMatricula()=" + getMatricula() + ", toString()=" + super.toString() + ", hashCode()="
                + hashCode() + "]";
    }

    
}