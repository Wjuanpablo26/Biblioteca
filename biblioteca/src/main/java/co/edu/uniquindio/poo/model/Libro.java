package co.edu.uniquindio.poo.model;

public class Libro {
    private String codigo;
    private String isbn;
    private String autor;
    private String titulo;
    private String editorial;
    private String fecha;
    private int unidadesDisponibles;
    private double precio;

    /*
     * Constructor de la clase Libro
     */
    public Libro(String codigo, String isbn, String autor, String titulo, String editorial, String fecha, int unidadesDisponibles, double precio) {
        this.codigo = codigo;
        this.isbn = isbn;
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
        this.fecha = fecha;
        this.unidadesDisponibles = unidadesDisponibles;
        this.precio = precio;
    }

    /*
     * Metodos gets y sets
     */
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /*
     * Metodo para obtener las unidades disponibles
     */
    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    /*
     * Metodo para actualizar las unidades disponibles
     */
    public void actualizarUnidadesDisponibles(int cantidad) {
        this.unidadesDisponibles += cantidad;
    }

    /*
     * Metodo para prestar un libro
     */
    public void prestar() {
        unidadesDisponibles--;
    }

    /*
     * Metodo para devolver un libro
     */
    public void devolver() {
        unidadesDisponibles++;
    }
}



