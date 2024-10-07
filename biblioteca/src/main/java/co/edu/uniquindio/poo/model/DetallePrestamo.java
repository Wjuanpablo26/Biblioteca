package co.edu.uniquindio.poo.model;

public class DetallePrestamo {
    private Libro libro;
    private int cantidad;
    private double subtotal;

    /*
     * Constructor de la clase DetallePrestamo
     */
    public DetallePrestamo(Libro libro, int cantidad) {
        this.libro = libro;
        this.cantidad = cantidad;
        this.subtotal = calcularSubtotal();
    }

    /*
     * Metodo para calcular el subtotal
     */
    private double calcularSubtotal() {
        return cantidad * libro.getPrecio(); 
    }

    /*
     * metodos gets y sets
     */
    public Libro getLibro() {
        return libro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getPrecio() {
        return libro.getPrecio();
    }
}



