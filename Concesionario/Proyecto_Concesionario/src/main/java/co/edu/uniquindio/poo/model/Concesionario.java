package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

public class Concesionario {

    private static Concesionario instancia;

    private String nombre;
    private LinkedList<Empleado> listaEmpleados;
    private LinkedList<Cliente> listaClientes;
    private LinkedList<Vehiculo> listaVehiculos;
    private LinkedList<Reporte> listaReportes;

    public Concesionario(String nombre) {
        this.nombre = nombre;
        this.listaEmpleados = new LinkedList<Empleado>();
        this.listaClientes = new LinkedList<Cliente>();
        this.listaVehiculos = new LinkedList<Vehiculo>();
        this.listaReportes = new LinkedList<Reporte>();
    }

    public LinkedList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(LinkedList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public LinkedList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(LinkedList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public LinkedList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(LinkedList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public LinkedList<Reporte> getListaTransacciones() {
        return listaReportes;
    }

    public void setListaTransacciones(LinkedList<Reporte> listaReportes) {
        this.listaReportes = listaReportes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Reporte> getListaReportes() {
        return listaReportes;
    }

    public void setListaReportes(LinkedList<Reporte> listaReportes) {
        this.listaReportes = listaReportes;
    }
    
    public static Concesionario getInstancia() {
        if (instancia == null) {
            instancia = new Concesionario("Concesionario UQ");
        }
        return instancia;
    }

    // CRUDSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS

    

    
    // CRUD Empleado

    /**
     * Añadir Empleado
     * 
     * @param empleado
     * @return
     * @throws IllegalArgumentException
     */
    public String añadirEmpleado(Empleado empleado) throws IllegalArgumentException {
        String mensaje = "Se añadió correctamente";
        if (empleado == null) {
            throw new IllegalArgumentException("No se aceptan objetos nulos");
        }
        listaEmpleados.add(empleado);
        return mensaje;
    }

    /**
     * Eliminar Empleado
     * 
     * @param empleado
     * @return
     * @throws IllegalArgumentException
     */
    public String eliminarEmpleado(Empleado empleado) throws IllegalArgumentException {
        String mensaje = "Se eliminó correctamente";
        if (empleado == null) {
            throw new IllegalArgumentException("No se aceptan objetos nulos");
        }
        if (!listaEmpleados.contains(empleado)) {
            mensaje = "No se encuentra en la lista";
        }
        listaEmpleados.remove(empleado);
        return mensaje;
    }

    /**
     * Buscar Empleado por id
     * 
     * @param id
     * @return
     */
    public Empleado buscarEmpleado(String id) {
        return listaEmpleados.stream()
                .filter(empleadoAux -> empleadoAux.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Editar empleado, borra uno y añade el nuevo
     * 
     * @param empleado
     * @param nuevoEmpleado
     * @return
     * @throws IllegalArgumentException
     */
    public String editarEmpleado(Empleado empleado, Empleado nuevoEmpleado) throws IllegalArgumentException {
        String mensaje = "Editado correctamente";

        if (empleado == null || nuevoEmpleado == null) {
            throw new IllegalArgumentException("No se aceptan objetos nulos");
        }

        if (!listaEmpleados.contains(empleado)) {
            mensaje = "No se encuentra en la lista";
        }

        listaEmpleados.remove(empleado);
        listaEmpleados.add(nuevoEmpleado);
        return mensaje;
    }


    /**
     * Verfica que el empleado esté activo y sus credenciales sean correctas
     * @param s
     * @param c
     * @return
     */
    public Empleado verificarCredenciales(String s, String c) {
        for (Empleado empleado : listaEmpleados) {
            if (s.equals(empleado.getUsuario()) && c.equals(empleado.getContraseña()) && empleado.isActivo()) {
                return empleado;
            }
            
        }
        return null;    
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

    // CRUD Reporte

    /**
     * Añadir Reporte
     * 
     * @param reporte
     * @return
     * @throws IllegalArgumentException
     */
    public String añadirReporte(Reporte reporte) throws IllegalArgumentException {
        String mensaje = "Se añadió correctamente";
        if (reporte == null) {
            throw new IllegalArgumentException("No se aceptan objetos nulos");
        }
        listaReportes.add(reporte);
        return mensaje;
    }

    /**
     * Eliminar Reporte
     * 
     * @param reporte
     * @return
     * @throws IllegalArgumentException
     */
    public String eliminarReporte(Reporte reporte) throws IllegalArgumentException {
        String mensaje = "Se eliminó correctamente";
        if (reporte == null) {
            throw new IllegalArgumentException("No se aceptan objetos nulos");
        }
        if (!listaReportes.contains(reporte)) {
            mensaje = "No se encuentra en la lista";
        }
        listaReportes.remove(reporte);
        return mensaje;
    }

    /**
     * Buscar Reporte por id
     * 
     * @param id
     * @return
     */
    public Reporte buscarReporte(String id) {
        return listaReportes.stream()
                .filter(reporteAux -> reporteAux.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Editar Reporte, borra uno y añade el nuevo
     * 
     * @param reporte
     * @param nuevoReporte
     * @return
     * @throws IllegalArgumentException
     */
    public String editarReporte(Reporte reporte, Reporte nuevoReporte) throws IllegalArgumentException {
        String mensaje = "Editado correctamente";

        if (reporte == null || nuevoReporte == null) {
            throw new IllegalArgumentException("No se aceptan objetos nulos");
        }

        if (!listaReportes.contains(reporte)) {
            mensaje = "No se encuentra en la lista";
        }

        listaReportes.remove(reporte);
        listaReportes.add(nuevoReporte);
        return mensaje;
    }


}