package co.edu.uniquindio.poo.model;

public class CombustibleHibrido extends Combustible {

    private boolean esEnchufable;
    private boolean esHibridoLigero;

    public CombustibleHibrido(boolean esEnchufable) {
        this.esEnchufable = esEnchufable;
        this.esHibridoLigero = false;
    }

    public CombustibleHibrido(boolean esEnchufable, boolean esHibridoLigero) {
        this.esEnchufable = esEnchufable;
        this.esHibridoLigero = esEnchufable ? false : esHibridoLigero;
    }

    public boolean isEsEnchufable() {
        return esEnchufable;
    }

    public void setEsEnchufable(boolean esEnchufable) {
        this.esEnchufable = esEnchufable;
    }

    public boolean isEsHibridoLigero() {
        return esHibridoLigero;
    }

    public void setEsHibridoLigero(boolean esHibridoLigero) {
        this.esHibridoLigero = esHibridoLigero;
    }

    @Override
    public String toString() {
        return "CombustibleHibrido [esEnchufable=" + esEnchufable + ", esHibridoLigero=" + esHibridoLigero + "]";
    }

}
