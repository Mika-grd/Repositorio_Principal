package co.edu.uniquindio.poo.App;

import java.time.LocalDate;
import java.util.LinkedList;
import co.edu.uniquindio.poo.model.*;

public class App {
    public static void main(String[] args) {
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
        Empresa empresa = new Empresa("Transportes XYZ", vehiculos, propietarios);

        // Agregar viajes
        v1.hacerViaje(LocalDate.of(2024, 2, 5), "1345", TipoViaje.PASAJEROS, 3);
        v1.hacerViaje(LocalDate.of(2024, 2, 5), "145", TipoViaje.PASAJEROS, 2);
        v2.hacerViaje(LocalDate.of(2024, 2, 6), "135", TipoViaje.PASAJEROS, 4);

        // Mostrar resultados de las pruebas
        mostrarResultados(empresa);
    }

    private static void mostrarResultados(Empresa empresa) {
        System.out.println("Prueba 1: Propietarios con peso mayor a 70.0f");
        LinkedList<Propietario> resultadoPesoMayorA = empresa.obtenerPesoMayorA(70.0f);
        System.out.println("Número de propietarios con peso mayor a 70.0: " + resultadoPesoMayorA.size());
        resultadoPesoMayorA.forEach(p -> System.out.println(p.getNombre() + " (" + p.getPeso() + " kg)"));

        System.out.println("\nPrueba 2: Número de pasajeros en el vehículo ABC123 el 5 de febrero de 2024");
        int pasajerosDia = empresa.obtenerPasajerosDia("ABC123", LocalDate.of(2024, 2, 5));
        System.out.println("Número de pasajeros en el vehículo ABC123: " + pasajerosDia);

        System.out.println("\nPrueba 3: Propietarios con edad mayor a 35");
        LinkedList<Propietario> resultadoEdadesMayoresA = empresa.obtenerEdadesMayoresA(35);
        System.out.println("Número de propietarios con edad mayor a 35: " + resultadoEdadesMayoresA.size());
        resultadoEdadesMayoresA.forEach(p -> System.out.println(p.getNombre() + " (" + p.getEdad() + " años)"));

        System.out.println("\nPrueba 4: Propietarios con edad entre 30 y 50 años");
        LinkedList<Propietario> resultadoEdadesEntre = empresa.obtenerEdadesEntre(30, 50);
        System.out.println("Número de propietarios con edad entre 30 y 50: " + resultadoEdadesEntre.size());
        resultadoEdadesEntre.forEach(p -> System.out.println(p.getNombre() + " (" + p.getEdad() + " años)"));
    }
}

