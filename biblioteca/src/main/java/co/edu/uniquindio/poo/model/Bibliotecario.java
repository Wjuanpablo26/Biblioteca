package co.edu.uniquindio.poo.model;

public class Bibliotecario {
    private String nombre;
    private String cedula;
    private String telefono;
    private String correo;
    private double salario;
    private int Ingreso;

    /*
     * Constructor de la clase Bibliotecario
     */
    public Bibliotecario(String nombre, String cedula, String telefono, String correo, double salario, int Ingreso) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.salario = salario;
        this.Ingreso = Ingreso;
    }

    // Getters y Setters
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

    public double getSalario() {
        return salario;
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

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getIngreso() {
        return Ingreso;
    }

    public void setIngreso(int Ingreso) {
        this.Ingreso = Ingreso;
    }

    /*
     * Metodo para calcular el salario total del bibliotecario
     */
    public double calcularSalarioTotal(int añosAntiguedad, double totalPrestamos) {
        double comision = totalPrestamos * 0.2;
        double bonificacion = comision * 0.02 * añosAntiguedad;
        return salario + comision + bonificacion;
    }

    /*
     * Metodo para calcular la antiguedad del bibliotecario
     */
    public int calcularAntiguedad(int Ingreso) {
        return 2024 - Ingreso;
    }
}

