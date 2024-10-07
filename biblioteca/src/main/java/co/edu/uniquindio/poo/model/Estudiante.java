package co.edu.uniquindio.poo.model;

public class Estudiante extends Persona {
    

    /*
     * Constructor de la clase Estudiante
     */
    public Estudiante(String nombre, String cedula, String telefono, String correo) {
        super(nombre, cedula, telefono, correo);
    }

    
    /*
     * Metodos gets y sets
     */
    public String getNombre() {
        return super.getNombre();
    }

    public String getCedula() {
        return super.getCedula();
    }

    public String getTelefono() {
        return super.getTelefono();
    }

    public String getCorreo() {
        return super.getCorreo();
    }

    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    public void setCedula(String cedula) {
        super.setCedula(cedula);
    }

    public void setTelefono(String telefono) {
        super.setTelefono(telefono);
    }

    public void setCorreo(String correo) {
        super.setCorreo(correo);
    }

    /*
     * Metodo para mostrar la informacion de un estudiante
     */
    @Override
    public String toString() {
        return "Estudiante [nombre=" + getNombre() + ", cedula=" + getCedula() + ", telefono=" + getTelefono() + ", correo=" + getCorreo() + "]";
    }
    
}

