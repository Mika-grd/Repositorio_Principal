package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.LinkedList;

public class Administrador extends Empleado {

    private Concesionario concesionario = Concesionario.getInstancia();
    private LinkedList<Empleado> listaEmpleados;
    private LinkedList<Reporte> listaReportes;

    public Administrador(String id, String nombre, boolean activo, String email, String usuario, String contraseña) {
        super(id, nombre, activo, email, usuario, contraseña);
        this.listaEmpleados = concesionario.getListaEmpleados();
        this.listaReportes = concesionario.getListaReportes();
    }

    public String bloquearEmpleado(Empleado empleado) {
        if (empleado.isActivo()) {
            empleado.setActivo(false);
            return "bloqueado con exito";
        }
        return "No se encontró o ya está inactivo";
    }

    // Crear listaReportes
    public Reporte crearReporte(String id, Empleado empleado, LocalDate fechaInicio, LocalDate fechaFinal) {
        return new Reporte(id, empleado.getListaTransacciones(), empleado, fechaInicio, fechaFinal);
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

}
