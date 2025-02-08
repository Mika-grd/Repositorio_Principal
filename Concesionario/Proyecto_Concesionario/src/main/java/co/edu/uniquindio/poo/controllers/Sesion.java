package co.edu.uniquindio.poo.controllers;

public class Sesion {
    public static enum Rol{
        ADMIN, 
        EMPLEADO
    }
    private static Rol rolActual;

    public static void setRol(Rol rol) {
        rolActual = rol;
    }

    public static Rol getRol() {
        return rolActual;
    }

    private static String id;

    public static Rol getRolActual() {
        return rolActual;
    }

    public static void setRolActual(Rol rolActual) {
        Sesion.rolActual = rolActual;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        Sesion.id = id;
    }

    
}
