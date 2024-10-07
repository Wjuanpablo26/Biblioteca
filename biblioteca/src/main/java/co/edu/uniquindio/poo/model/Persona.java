package co.edu.uniquindio.poo.model;

public class Persona {
    private String nombre;
    private String cedula;
    private String telefono;
    private String correo;

    /*
     * Constructor de la clase Persona
     */
    public Persona(String nombre, String cedula, String telefono, String correo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
    }

    /*
     *  Metodos gets y sets
     */
    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /*
     * Metodo para mostrar la informacion de una persona
     */
    public String toString() {
        return "Persona [nombre=" + nombre + ", cedula=" + cedula + ", telefono=" + telefono + ", correo=" + correo + "]";
    }
    
}
