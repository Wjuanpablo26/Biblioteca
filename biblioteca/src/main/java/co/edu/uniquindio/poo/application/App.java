package co.edu.uniquindio.poo.application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import co.edu.uniquindio.poo.model.Biblioteca;
import co.edu.uniquindio.poo.model.DetallePrestamo;
import co.edu.uniquindio.poo.model.Libro;
import co.edu.uniquindio.poo.model.Estudiante;

public class App {
    public static void main(String[] args) {
        // Crear biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca UQ");

        // Crear bibliotecarios
        biblioteca.crearBibliotecario("Juan Perez", "123456789", "555-1234", "juan@example.com", 3000.0,2022);
        biblioteca.crearBibliotecario("Ana Gomez", "987654321", "555-5678", "ana@example.com", 3200.0,2021);

        // Crear estudiantes
        biblioteca.crearEstudiante("Carlos Ruiz", "111222333", "555-8765", "carlos@example.com");
        biblioteca.crearEstudiante("Maria Lopez", "444555666", "555-4321", "maria@example.com");

        // Crear libros
        biblioteca.crearLibro("L001", "978-3-16-148410-0", "Gabriel Garcia Marquez", "Cien años de soledad", "Editorial De Medellin", "2023-01-01", 5,4);
        biblioteca.crearLibro("L002", "978-1-23-456789-7", "Justin Roilan", "Rick And Morty y sus aventuras", "Editorial De Bogota", "2023-02-01", 3,3);

        // Crear detalles de préstamo
        List<DetallePrestamo> detallesPrestamo1 = new ArrayList<>();
        detallesPrestamo1.add(new DetallePrestamo(biblioteca.consultarLibroPorCodigo("L001"), 3));
        detallesPrestamo1.add(new DetallePrestamo(biblioteca.consultarLibroPorCodigo("L002"), 3));

        // Crear préstamo
        biblioteca.crearPrestamo("P001", biblioteca.consultarEstudiantePorCedula("111222333"), detallesPrestamo1, new Date(), new Date());

        // Adicionar libro al préstamo
        DetallePrestamo detalleAdicional = new DetallePrestamo(biblioteca.consultarLibroPorCodigo("L001"), 1);
        biblioteca.adicionarLibroAlPrestamo("P001", detalleAdicional);

        // Entregar préstamo
        double costoPrestamo = biblioteca.entregarPrestamo("P001", new Date());
        System.out.println("Costo del préstamo: " + costoPrestamo);

        // Consultar datos de un libro
        Libro libroConsultado = biblioteca.consultarLibroPorCodigo("L001");
        System.out.println("Datos del libro consultado: " + libroConsultado.getTitulo() + ", Autor: " + libroConsultado.getAutor());

        // Consultar cantidad de préstamos por nombre del libro
        int cantidadPrestamos = biblioteca.consultarCantidadPrestamosPorNombre("Cien años de soledad");
        System.out.println("Cantidad de préstamos del libro "+ libroConsultado.getTitulo() + ": "   + cantidadPrestamos);

        // Reemplazar un libro
        Libro nuevoLibro = new Libro("L001", "978-3-16-148410-0", "Autor C", "Libro C", "Editorial C", "2024-01-01", 10,5);
        biblioteca.reemplazarLibro("L001", nuevoLibro);

        // Mostrar Estudiante con más préstamos
        Estudiante estudianteConMasPrestamos = biblioteca.estudianteConMasPrestamos();
        System.out.println("Estudiante con más préstamos: " + estudianteConMasPrestamos.getNombre());

        // Mostrar total de dinero recaudado
        double totalDineroRecaudado = biblioteca.totalDineroRecaudado();
        System.out.println("Total de dinero recaudado: " + totalDineroRecaudado);

        // Mostrar total de dinero a pagar a los bibliotecarios
        double totalDineroAPagarBibliotecarios = biblioteca.totalDineroAPagarBibliotecarios();
        System.out.println("Total de dinero a pagar a los bibliotecarios: " + totalDineroAPagarBibliotecarios);
    }

}

