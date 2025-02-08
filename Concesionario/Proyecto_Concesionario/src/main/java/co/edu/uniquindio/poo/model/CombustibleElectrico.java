package co.edu.uniquindio.poo.model;

public class CombustibleElectrico extends Combustible {

    private int autonomia;
    private int tiempoCarga;

    public CombustibleElectrico(int autonomia, int tiempoCarga) {
        this.autonomia = autonomia;
        this.tiempoCarga = tiempoCarga;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    public int getTiempoCarga() {
        return tiempoCarga;
    }

    public void setTiempoCarga(int tiempoCarga) {
        this.tiempoCarga = tiempoCarga;
    }

    @Override
    public String toString() {
        return "CombustibleElectrico [autonomia=" + autonomia + ", tiempoCarga=" + tiempoCarga + "]";
    }

    

}
