package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Date;

public class Biblioteca {
    private String nombre;
    private List<Bibliotecario> bibliotecarios;
    private List<Estudiante> estudiantes;
    private Map<String, Libro> libros;
    private Map<String, Prestamo> prestamos;

    /*
     * Constructor de la clase Biblioteca
     */
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.bibliotecarios = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
        this.libros = new HashMap<>();
        this.prestamos = new HashMap<>();
    }

    /*
     *  Metodos gets y sets
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Bibliotecario> getBibliotecarios() {
        return bibliotecarios;
    }

    public void setBibliotecarios(List<Bibliotecario> bibliotecarios) {
        this.bibliotecarios = bibliotecarios;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Map<String, Libro> getLibros() {
        return libros;
    }

    public void setLibros(Map<String, Libro> libros) {
        this.libros = libros;
    }

    public Map<String, Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Map<String, Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    /*
     * Metodo para crear un bibliotecario
     */
    public void crearBibliotecario(String nombre, String cedula, String telefono, String correo, double salario, int Ingreso) {
        bibliotecarios.add(new Bibliotecario(nombre, cedula, telefono, correo, salario, Ingreso));
    }
    
    /*
     * Metodo para crear un estudiante
     */
    public void crearEstudiante(String nombre, String cedula, String telefono, String correo) {
        estudiantes.add(new Estudiante(nombre, cedula, telefono, correo));
    }
    
    /*
     * Metodo para crear un libro
     */
    public void crearLibro(String codigo, String isbn, String autor, String titulo, String editorial, String fecha, int unidadesDisponibles,double precio) {
        libros.put(codigo, new Libro(codigo, isbn, autor, titulo, editorial, fecha, unidadesDisponibles, precio));
    }
    
    /*
     * Metodo para consultar un libro por su codigo
     */
    public Libro consultarLibroPorCodigo(String codigo) {
        return libros.get(codigo);
    }

    /*
     * Consultar un estudiante por su cedula
     */
    public Estudiante consultarEstudiantePorCedula(String cedula) {
        return estudiantes.stream()
                .filter(estudiante -> estudiante.getCedula().equals(cedula))
                .findFirst()
                .orElse(null);
    }

    /*
     * Metodo para consultar la cantidad de prestamos de un libro por su nombre
     */
    public int consultarCantidadPrestamosPorNombre(String nombre) {
        return (int) prestamos.values().stream()
                .flatMap(prestamo -> prestamo.getDetalles().stream())
                .filter(detalle -> detalle.getLibro().getTitulo().equals(nombre))
                .count();
    }
    
    /*
     * Metodo para reemplazar un libro por su codigo
     */
    public void reemplazarLibro(String codigo, Libro nuevoLibro) {
        libros.put(codigo, nuevoLibro);
    }

    /*
     * Metodo para crear un prestamo
     */
    public void crearPrestamo(String codigo, Estudiante estudiante, List<DetallePrestamo> detalles, Date fechaPrestamo, Date fechaEntrega) {
        Prestamo prestamo = new Prestamo(codigo, estudiante, detalles, fechaPrestamo, fechaEntrega);
        prestamos.put(codigo, prestamo);
        detalles.forEach(detalle -> detalle.getLibro().actualizarUnidadesDisponibles(-detalle.getCantidad()));
    }

    /*
     * Metodo para adicionar un libro al prestamo
     */
    public void adicionarLibroAlPrestamo(String codigoPrestamo, DetallePrestamo detalle) {
        Prestamo prestamo = prestamos.get(codigoPrestamo);
        prestamo.getDetalles().add(detalle);
        detalle.getLibro().actualizarUnidadesDisponibles(-detalle.getCantidad());
    }

    /*
     * Metodo para entregar un prestamo
     */
    public double entregarPrestamo(String codigoPrestamo, Date fechaDevolucion) {
        return prestamos.values().stream()
                .filter(prestamo -> prestamo.getCodigo().equals(codigoPrestamo))
                .findFirst()
                .map(prestamo -> {
                    prestamo.setFechaEntrega(fechaDevolucion);
                    return prestamo.calcularCosto();
                })
                .orElse(0.0);
    }

    /*
     * Metodo para consultar un prestamo por su codigo
     */
    public Prestamo consultarPrestamoPorCodigo(String codigo) {
        return prestamos.get(codigo);
    }

    /*
     * Metodo para mostrar la cantidad de libros prestados por cada empleado
     */
    public Map<Bibliotecario, Integer> cantidadLibrosPrestadosPorEmpleado() {
        return prestamos.values().stream()
                .collect(Collectors.toMap(
                        Prestamo::getBibliotecario,
                        prestamo -> prestamo.getDetalles().size(),
                        Integer::sum
                ));
    }

    /*
     * Metodo para consultar el estudiante con mas prestamos
     */
    public Estudiante estudianteConMasPrestamos() {
        return prestamos.values().stream()
                .collect(Collectors.groupingBy(Prestamo::getEstudiante, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    /*
     * Metodo para consultar el total de dinero recaudado por la biblioteca
     */
    public double totalDineroRecaudado() {
        return prestamos.values().stream()
                .mapToDouble(Prestamo::calcularCosto)
                .sum();
    }
    
    /*
     * Metodo para consultar el total de dinero a pagar a los bibliotecarios
     */
    public double totalDineroAPagarBibliotecarios() {
        return bibliotecarios.stream()
                .mapToDouble(bibliotecario -> {
                    double salarioBase = bibliotecario.getSalario();
                    double comision = prestamos.values().stream()
                            .filter(prestamo -> prestamo.getEstudiante().getCedula().equals(bibliotecario.getCedula()))
                            .mapToDouble(prestamo -> prestamo.calcularCosto() * 0.2)
                            .sum();
                    int antiguedad = bibliotecario.calcularAntiguedad(bibliotecario.getAnoIngreso());
                    return salarioBase + comision + (comision * 0.02 * antiguedad);
                })
                .sum();
    }
}

