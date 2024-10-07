package co.edu.uniquindio.poo.model;

public class Bibliotecario extends Persona{
    
    private double salario;
    private int anoIngreso;

    /*
     * Constructor de la clase Bibliotecario
     */
    public Bibliotecario(String nombre, String cedula, String telefono, String correo, double salario, int anoIngreso) {
        super(nombre, cedula, telefono, correo);
        this.salario = salario;
        this.anoIngreso = anoIngreso;
    }

    /*
     *  Metodos gets y sets
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

    public double getSalario() {
        return salario;
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

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getAnoIngreso() {
        return anoIngreso;
    }

    public void setIngreso(int anoIngreso) {
        this.anoIngreso = anoIngreso;
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
    public int calcularAntiguedad(int anoIngreso) {
        return 2024 - anoIngreso;
    }

    /*
     * Metodo para mostrar la informacion de un bibliotecario
     */
    @Override
    public String toString() {
        return "Bibliotecario [nombre=" + getNombre() + ", cedula=" + getCedula() + ", telefono=" + getTelefono() + ", correo=" + getCorreo() + ", salario=" + salario + ", anoIngreso=" + anoIngreso + "]";
    }

}

