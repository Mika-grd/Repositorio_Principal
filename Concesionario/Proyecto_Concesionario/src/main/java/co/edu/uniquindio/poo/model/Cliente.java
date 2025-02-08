package co.edu.uniquindio.poo.model;

public class Cliente {

    private String idCliente;
    private String nombre;
    private String contacto;

    public Cliente(String idCliente, String nombre, String contacto) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.contacto = contacto;
    }

    public String getIdCliente() {
        return idCliente;
    }

    @Override
    public String toString() {
        return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", contacto=" + contacto + "]";
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

}
