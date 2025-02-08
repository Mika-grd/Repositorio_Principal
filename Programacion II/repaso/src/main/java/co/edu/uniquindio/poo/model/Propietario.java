package co.edu.uniquindio.poo.model;

public class Propietario {

    private String nombre;
    private String id;
    private String email;
    private int edad;
    private float peso;
    private Vehiculo vehiculo;


        //Constructor
    public Propietario(String nombre, String id, String email, int edad, float peso, Vehiculo vehiculo) {
        this.nombre = nombre;
        this.id = id;
        this.email = email;
        this.edad = edad;
        this.peso = peso;
        this.vehiculo = vehiculo;
    }





    public String getNombre() {
        return nombre;
    }





    public void setNombre(String nombre) {
        this.nombre = nombre;
    }





    public String getId() {
        return id;
    }





    public void setId(String id) {
        this.id = id;
    }





    public String getEmail() {
        return email;
    }





    public void setEmail(String email) {
        this.email = email;
    }





    public int getEdad() {
        return edad;
    }





    public void setEdad(int edad) {
        this.edad = edad;
    }





    public float getPeso() {
        return peso;
    }





    public void setPeso(float peso) {
        this.peso = peso;
    }





    public Vehiculo getVehiculo() {
        return vehiculo;
    }





    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }


    //Getters & Setters

    

    
}
