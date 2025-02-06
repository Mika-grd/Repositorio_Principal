package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Optional;

public class Empresa {

    private String nombre;
    private LinkedList<Vehiculo> listaVehiculos;
    private LinkedList<Propietario> listaPropietarios;


    /**
     *  Metodo para obtener los propietrios con peso mayor a 
     * @param peso 
     * @return lista con los propietarios con peso mayor a 
     */
    public LinkedList<Propietario> obtenerPesoMayorA(float peso){
        LinkedList<Propietario> lista = new LinkedList<>();
        for (Propietario propietario : listaPropietarios) {
            if (propietario.getPeso() > peso) {
                lista.add(propietario);
            }
        }
        return lista;
    }

    /**
     *  Metodo para obtener los pasajeros de un vehiculo dando la placa y el dia
     * @param placa
     * @param fecha
     * @return numero de pasajeros 
     */
    public int obtenerPasajerosDia(String placa, LocalDate fecha){
        int numero = 0;
        for (Vehiculo vehiculo : listaVehiculos) {
            for (Viaje viaje : vehiculo.getListaViajes()) {
                if (viaje.getFecha().equals(fecha)) {
                    numero = numero + viaje.getNumeroPasajeros();
                }
            }
        }
        return numero;
    }

    /**
     *  obtener lista de propietarios con edad mayor a 
     * @param edad
     * @return lista con los propietarios mayores a 
     */
    public LinkedList<Propietario> obtenerEdadesMayoresA(int edad){
        LinkedList<Propietario> lista = new LinkedList<>();
        for (Propietario propietario : listaPropietarios) {
            if (propietario.getEdad() > edad) {
                lista.add(propietario);
            }
        }
        return lista;
    }


    /**
     *  obtener los propietarios con edad entre minimo y maximo
     * @param minimo
     * @param maximo
     * @return lista de propietarios con edades entre minimo y maximo
     */
    public LinkedList<Propietario> obtenerEdadesEntre(int minimo, int maximo){
        LinkedList<Propietario> lista = new LinkedList<>();
        for (Propietario propietario : listaPropietarios) {
            if (propietario.getEdad() > minimo && propietario.getEdad() < maximo) {
                lista.add(propietario);
            }
        }
        return lista;
    }

    // Create - agregrar propietario
    public void agregarPropietario(Propietario propietario) {
        listaPropietarios.add(propietario);
    }

    // ✅ READ - Obtener Propietario por ID
    public Propietario obtenerPropietario(String id) {
        for (Propietario p : listaPropietarios) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null; // No encontrado
    }

    // ✅ UPDATE - Modificar Propietario (por ID)
    public boolean actualizarPropietario(String id, String nuevoNombre, String nuevoEmail, String nuevoTelefono, int nuevaEdad, float nuevoPeso) {
        for (Propietario p : listaPropietarios) {
            if (p.getId().equals(id)) {
                p.setNombre(nuevoNombre);
                p.setEmail(nuevoEmail);
                p.setEdad(nuevaEdad);
                p.setPeso(nuevoPeso);
                return true; // Actualización exitosa
            }
        }
        return false; // No encontrado
    }

    // ✅ DELETE - Eliminar Propietario (y sus vehículos)
    @SuppressWarnings("unlikely-arg-type")
    public boolean eliminarPropietario(String id) {
        Optional<Propietario> propietarioAEliminar = listaPropietarios.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst();

        if (propietarioAEliminar.isPresent()) {
            listaPropietarios.remove(propietarioAEliminar);
            return true;
        }
        return false;
    }

    // ✅ CREATE - Agregar Vehículo
    public void agregarVehiculo(Vehiculo vehiculo) {
        listaVehiculos.add(vehiculo);
    }

    // ✅ READ - Obtener Vehículo por Placa
    public Vehiculo obtenerVehiculo(String placa) {
        for (Vehiculo v : listaVehiculos) {
            if (v.getPlaca().equals(placa)) {
                return v;
            }
        }
        return null; // No encontrado
    }

    // ✅ UPDATE - Modificar Vehículo (por Placa)
    public boolean actualizarVehiculo(String placa, String nuevoModelo, String nuevaMarca, String nuevoColor) {
        for (Vehiculo v : listaVehiculos) {
            if (v.getPlaca().equals(placa)) {
                v.setModelo(nuevoModelo);
                v.setMarca(nuevaMarca);
                v.setColor(nuevoColor);
                return true; // Actualización exitosa
            }
        }
        return false; // No encontrado
    }

    // ✅ DELETE - Eliminar Vehículo por Placa
    public boolean eliminarVehiculo(String placa) {
        return listaVehiculos.removeIf(v -> v.getPlaca().equals(placa));
    }

    //Constructor
    
    public Empresa(String nombre, LinkedList<Vehiculo> listaVehiculos, LinkedList<Propietario> listaPropietarios) {
        this.nombre = nombre;
        this.listaVehiculos = listaVehiculos;
        this.listaPropietarios = listaPropietarios;
    }

    //Setters & Getters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public LinkedList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }
    public void setListaVehiculos(LinkedList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }
    public LinkedList<Propietario> getListaPropietarios() {
        return listaPropietarios;
    }
    public void setListaPropietarios(LinkedList<Propietario> listaPropietarios) {
        this.listaPropietarios = listaPropietarios;
    }










}
