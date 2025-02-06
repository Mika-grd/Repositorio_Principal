/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;
import co.edu.uniquindio.poo.model.*;

public class EmpresaTest {
    private Empresa empresa;

    @BeforeEach
    void setUp() {
        // Crear listas de vehículos y propietarios
        LinkedList<Vehiculo> vehiculos = new LinkedList<>();
        LinkedList<Propietario> propietarios = new LinkedList<>();

        // Crear vehículos
        VehiculoPasajeros v1 = new VehiculoPasajeros("ABC123", "Toyota", "Corolla", "Rojo", new LinkedList<>(), 4);
        VehiculoPasajeros v2 = new VehiculoPasajeros("XYZ789", "Ford", "Fiesta", "Azul", new LinkedList<>(), 5);
        vehiculos.add(v1);
        vehiculos.add(v2);

        // Crear propietarios
        Propietario p1 = new Propietario("Juan", "P001", "juan@mail.com", 50, 80.5f, v1);
        Propietario p2 = new Propietario("Ana", "P002", "ana@mail.com", 30, 60.0f, null);
        Propietario p3 = new Propietario("Carlos", "P003", "carlos@mail.com", 40, 90.0f, v2);
        propietarios.add(p1);
        propietarios.add(p2);
        propietarios.add(p3);

        // Crear la empresa
        empresa = new Empresa("Transportes XYZ", vehiculos, propietarios);

        // Agregar viajes
        v1.hacerViaje(LocalDate.of(2024, 2, 5), "1345",  TipoViaje.PASAJEROS, 3);
        v1.hacerViaje(LocalDate.of(2024, 2, 5), "145",  TipoViaje.PASAJEROS, 2);
        v2.hacerViaje(LocalDate.of(2024, 2, 6), "135",  TipoViaje.PASAJEROS, 4);
    }

    @Test
    void testObtenerPesoMayorA() {
        LinkedList<Propietario> resultado = empresa.obtenerPesoMayorA(70.0f);
        assertEquals(2, resultado.size()); // Juan (80.5) y Carlos (90.0) deben estar
        assertTrue(resultado.stream().anyMatch(p -> p.getId().equals("P001")));
        assertTrue(resultado.stream().anyMatch(p -> p.getId().equals("P003")));
    }

    @Test
    void testObtenerPasajerosDia() {
        int pasajeros = empresa.obtenerPasajerosDia("ABC123", LocalDate.of(2024, 2, 5));
        assertEquals(5, pasajeros); // V1 tuvo dos viajes con 3 y 2 pasajeros
    }

    @Test
    void testObtenerEdadesMayoresA() {
        LinkedList<Propietario> resultado = empresa.obtenerEdadesMayoresA(35);
        assertEquals(2, resultado.size()); // Juan (50) y Carlos (40) deben estar
        assertTrue(resultado.stream().anyMatch(p -> p.getId().equals("P001")));
        assertTrue(resultado.stream().anyMatch(p -> p.getId().equals("P003")));
    }

    @Test
    void testObtenerEdadesEntre() {
        LinkedList<Propietario> resultado = empresa.obtenerEdadesEntre(30, 50);
        assertEquals(1, resultado.size()); // Carlos (40) debe estar
        assertTrue(resultado.stream().anyMatch(p -> p.getId().equals("P003")));
    }
}