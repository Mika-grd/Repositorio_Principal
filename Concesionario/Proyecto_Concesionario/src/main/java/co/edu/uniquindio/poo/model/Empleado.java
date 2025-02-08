package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.LinkedList;

public class Empleado implements Autenticable {

    private Concesionario concesionario = Concesionario.getInstancia();
    private LinkedList<Cliente> listaClientes;
    private LinkedList<Transaccion> listaTransacciones;
    private LinkedList<Vehiculo> listaVehiculos;

    private String id;
    private String nombre;
    private boolean activo;
    private String email;
    private String usuario;
    private String contraseña;

    public Empleado(String id, String nombre, boolean activo, String email, String usuario, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.activo = activo;
        this.email = email;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.listaClientes = concesionario.getListaClientes();
        this.listaTransacciones = new LinkedList<Transaccion>();
        this.listaVehiculos = concesionario.getListaVehiculos();
    }

    
    @Override
    public String toString() {
        return "Empleado [listaClientes=" + listaClientes + ", listaTransacciones=" + listaTransacciones
                + ", listaVehiculos=" + listaVehiculos + ", id=" + id + ", nombre=" + nombre + ", activo=" + activo
                + ", email=" + email + ", usuario=" + usuario + ", contraseña=" + contraseña + "]";
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Concesionario getConcesionario() {
        return concesionario;
    }

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public LinkedList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(LinkedList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }


    /**
     * Metodo alquilar vehiculo a un cliente
     * @param vehiculo
     * @param dias
     * @return
     */
    public String alquilarVehiculo(Vehiculo vehiculo, int dias, Cliente cliente, LocalDate fecha){
        if (vehiculo.isDisponibilidad()) {
            vehiculo.setDisponibilidad(false);
            double valor = vehiculo.getPrecioDia() * dias;
            listaTransacciones.add(new Transaccion(TipoTransaccion.ALQUILER, vehiculo, cliente, this, fecha, valor));
            return "vehiculo" + vehiculo +" alquilado por " + dias;
        }
        return "Vehiculo no disponible";
    }

    /**
     * Metodo vender vehiculo a un cliente
     * @param vehiculo
     * @param cliente
     * @param fecha
     * @return
     */
    public String venderVehiculo(Vehiculo vehiculo,  Cliente cliente, LocalDate fecha){
        if (vehiculo.isDisponibilidad()) {
            vehiculo.setDisponibilidad(false);
            listaTransacciones.add(new Transaccion(TipoTransaccion.VENTA, vehiculo, cliente, this, fecha, vehiculo.getPrecio()));
            return "vehiculo" + vehiculo +" vendido";
        }
        return "Vehiculo no disponible";
    }

    /**
     * Metodo para comprar un vehiculo a un cliente
     * @param vehiculo
     * @param cliente
     * @param fecha
     * @param precio
     * @param revisionTecnica
     * @return
     */
    public String comprarVehiculo(Vehiculo vehiculo,  Cliente cliente, LocalDate fecha, double precio, boolean revisionTecnica){
        if (revisionTecnica) {
            listaTransacciones.add(new Transaccion(TipoTransaccion.COMPRA, vehiculo, cliente, this, fecha, precio));
            vehiculo.setPrecio(precio * 1.5);//ganancias :D
            return "Vehiculo "+ vehiculo + "comprado a" + cliente;
        }
        return "Aun no se ha completado la revision tecnica";
    }


    /**
     * Recuperar contra a partir de compara email
     * @param s
     * @return
     */
    public String recuperarContraseña(String s) {
        if (s.equals(getEmail())) {
            return "Contraseña: " + getContraseña() +" Correo de recuperación enviado a " + getEmail();
        }
        return "Contraseña incorrecta";
    }


    // CRUD Cliente

    /**
     * Añadir Cliente
     * 
     * @param cliente
     * @return
     * @throws IllegalArgumentException
     */
    public String añadirCliente(Cliente cliente) throws IllegalArgumentException {
        String mensaje = "Se añadió correctamente";
        if (cliente == null) {
            throw new IllegalArgumentException("No se aceptan objetos nulos");
        }
        listaClientes.add(cliente);
        return mensaje;
    }


    /**
     * Eliminar Cliente
     * 
     * @param cliente
     * @return
     * @throws IllegalArgumentException
     */
    public String eliminarCliente(Cliente cliente) throws IllegalArgumentException {
        String mensaje = "Se eliminó correctamente";
        if (cliente == null) {
            throw new IllegalArgumentException("No se aceptan objetos nulos");
        }
        if (!listaClientes.contains(cliente)) {
            mensaje = "No se encuentra en la lista";
        }
        listaClientes.remove(cliente);
        return mensaje;
    }

    /**
     * Buscar Cliente por id
     * 
     * @param cedula
     * @return
     */
    public Cliente buscarCliente(String cedula) {
        return listaClientes.stream().filter(clienteaux -> clienteaux.getIdCliente().equals(cedula)).findFirst()
                .orElse(null);
    }

    /**
     * Editar cliente, borra uno y añade el nuevo
     * 
     * @param cliente
     * @param nuevoCliente
     * @return
     * @throws IllegalArgumentException
     */
    public String editarCliente(Cliente cliente, Cliente nuevoCliente) throws IllegalArgumentException {
        String mensaje = "editado correctamente";

        if (cliente == null || nuevoCliente == null) {
            throw new IllegalArgumentException("No se aceptan objetos nulos");
        }

        if (!listaClientes.contains(cliente)) {
            mensaje = "No se encuentra en la lista";
        }

        listaClientes.remove(cliente);
        listaClientes.add(nuevoCliente);
        return mensaje;
    }

    /**
 * Eliminar Transacción
 * 
 * @param transaccion
 * @return
 * @throws IllegalArgumentException
 */
public String eliminarTransaccion(Transaccion transaccion) throws IllegalArgumentException {
    String mensaje = "Se eliminó correctamente";
    
    // Verificar si el objeto es nulo
    if (transaccion == null) {
        throw new IllegalArgumentException("No se aceptan objetos nulos");
    }
    
    // Verificar si la transacción existe en la lista
    if (!listaTransacciones.contains(transaccion)) {
        mensaje = "No se encuentra en la lista";
    } else {
        listaTransacciones.remove(transaccion); // Eliminar transacción de la lista
    }
    
    return mensaje;
}

/**
 * Buscar Transacción por vehículo (placa)
 * 
 * @param placaVehiculo
 * @return
 */
public Transaccion buscarTransaccionPorVehiculo(String placaVehiculo) {
    return listaTransacciones.stream()
                              .filter(transaccion -> transaccion.getVehiculo().getMatricula().equals(placaVehiculo))
                              .findFirst()
                              .orElse(null); // Retorna null si no se encuentra
}


    public LinkedList<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(LinkedList<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }
    
    // CRUD Vehículo

    /**
     * Añadir Vehículo
     * 
     * @param vehiculo
     * @return
     * @throws IllegalArgumentException
     */
    public String añadirVehiculo(Vehiculo vehiculo) throws IllegalArgumentException {
        String mensaje = "Se añadió correctamente";
        if (vehiculo == null) {
            throw new IllegalArgumentException("No se aceptan objetos nulos");
        }
        listaVehiculos.add(vehiculo);
        return mensaje;
    }

    /**
     * Eliminar Vehículo
     * 
     * @param vehiculo
     * @return
     * @throws IllegalArgumentException
     */
    public String eliminarVehiculo(Vehiculo vehiculo) throws IllegalArgumentException {
        String mensaje = "Se eliminó correctamente";
        if (vehiculo == null) {
            throw new IllegalArgumentException("No se aceptan objetos nulos");
        }
        if (!listaVehiculos.contains(vehiculo)) {
            mensaje = "No se encuentra en la lista";
        }
        listaVehiculos.remove(vehiculo);
        return mensaje;
    }

    /**
     * Buscar Vehículo por matrícula
     * 
     * @param matricula
     * @return
     */
    public Vehiculo buscarVehiculo(String matricula) {
        return listaVehiculos.stream()
                .filter(vehiculoAux -> vehiculoAux.getMatricula().equals(matricula))
                .findFirst()
                .orElse(null);
    }

    /**
     * Editar Vehículo, borra uno y añade el nuevo
     * 
     * @param vehiculo
     * @param nuevoVehiculo
     * @return
     * @throws IllegalArgumentException
     */
    public String editarVehiculo(Vehiculo vehiculo, Vehiculo nuevoVehiculo) throws IllegalArgumentException {
        String mensaje = "Editado correctamente";

        if (vehiculo == null || nuevoVehiculo == null) {
            throw new IllegalArgumentException("No se aceptan objetos nulos");
        }

        if (!listaVehiculos.contains(vehiculo)) {
            mensaje = "No se encuentra en la lista";
        }

        listaVehiculos.remove(vehiculo);
        listaVehiculos.add(nuevoVehiculo);
        return mensaje;
    }
}
