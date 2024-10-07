package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import java.util.logging.Logger;
import co.edu.uniquindio.poo.model.Estudiante;
import co.edu.uniquindio.poo.model.Libro;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import co.edu.uniquindio.poo.model.Biblioteca;
import co.edu.uniquindio.poo.model.DetallePrestamo;
import co.edu.uniquindio.poo.model.Prestamo;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class BibliotecaTest {

    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());
    private Biblioteca biblioteca;

    /*
     * Método para inicializar la biblioteca antes de cada test
     */
    @BeforeEach
    public void setUp() {
        biblioteca = new Biblioteca("Biblioteca Central");
    }

    /*
     * Test para consultar un libro por su codigo
     */
    @Test
    public void testConsultarLibroPorCodigo() {
        LOG.info("Iniciando test para consultar un libro por código");
        biblioteca.crearLibro("004", "ISBN004", "Autor4", "Titulo4", "Editorial4", "2023-01-01", 5, 150.0);
        Libro libro = biblioteca.consultarLibroPorCodigo("004");
        assertNotNull(libro);
        assertEquals("Titulo4", libro.getTitulo());
        LOG.info("Finalizando test para consultar un libro por código");
    }

    /*
     * Test para consultar un estudiante por su cedula
     */
    @Test
    public void testConsultarEstudiantePorCedula() {
        LOG.info("Iniciando test para consultar un estudiante por cédula");
        biblioteca.crearEstudiante("Ana", "321", "321654", "ana@example.com");
        Estudiante estudiante = biblioteca.consultarEstudiantePorCedula("321");
        assertNotNull(estudiante);
        assertEquals("Ana", estudiante.getNombre());
        LOG.info("Finalizando test para consultar un estudiante por cédula");
    }

    /*
     * Test para consultar la cantidad de prestamos por nombre
     */
    @Test
    public void testConsultarCantidadPrestamosPorNombre() {
        LOG.info("Iniciando test para consultar cantidad de préstamos por nombre de libro");
        Estudiante estudiante = new Estudiante("Luis", "987", "987654", "luis@example.com");
        Libro libro = new Libro("005", "ISBN005", "Autor5", "Titulo5", "Editorial5", "2023-01-01", 10, 200.0);

        List<DetallePrestamo> detalles = new ArrayList<>();
        detalles.add(new DetallePrestamo(libro, 1));

        biblioteca.crearPrestamo("P004", estudiante, detalles, new Date(), new Date());
        biblioteca.crearPrestamo("P005", estudiante, detalles, new Date(), new Date());

        int cantidad = biblioteca.consultarCantidadPrestamosPorNombre("Titulo5");
        assertEquals(2, cantidad);
        LOG.info("Finalizando test para consultar cantidad de préstamos por nombre de libro");
    }

    /*
     * Test para reemplazar un libro
     */
    @Test
    public void testReemplazarLibro() {
        LOG.info("Iniciando test para reemplazar un libro");
        biblioteca.crearLibro("006", "ISBN006", "Autor6", "Titulo6", "Editorial6", "2023-01-01", 5, 150.0);
        Libro nuevoLibro = new Libro("006", "ISBN006", "Autor6", "NuevoTitulo6", "Editorial6", "2023-01-01", 5, 150.0);
        biblioteca.reemplazarLibro("006", nuevoLibro);
        Libro libro = biblioteca.consultarLibroPorCodigo("006");
        assertEquals("NuevoTitulo6", libro.getTitulo());
        LOG.info("Finalizando test para reemplazar un libro");
    }

    /*
     * Test para crear un préstamo
     */
    @Test
    public void testCrearPrestamo() {
        LOG.info("Iniciando test para crear un préstamo");
        Estudiante estudiante = new Estudiante("Pedro", "654", "654987", "pedro@example.com");
        Libro libro = new Libro("007", "ISBN007", "Autor7", "Titulo7", "Editorial7", "2023-01-01", 10, 200.0);

        List<DetallePrestamo> detalles = new ArrayList<>();
        detalles.add(new DetallePrestamo(libro, 1));

        biblioteca.crearPrestamo("P006", estudiante, detalles, new Date(), new Date());
        Prestamo prestamo = biblioteca.consultarPrestamoPorCodigo("P006");
        assertNotNull(prestamo);
        assertEquals(estudiante, prestamo.getEstudiante());
        LOG.info("Finalizando test para crear un préstamo");
    }

    /*
     * Test para adicionar un libro a un préstamo
     */
    @Test
    public void testAdicionarLibroAlPrestamo() {
        LOG.info("Iniciando test para adicionar un libro a un préstamo");
        Estudiante estudiante = new Estudiante("Laura", "852", "852963", "laura@example.com");
        Libro libro1 = new Libro("008", "ISBN008", "Autor8", "Titulo8", "Editorial8", "2023-01-01", 10, 200.0);
        Libro libro2 = new Libro("009", "ISBN009", "Autor9", "Titulo9", "Editorial9", "2023-01-01", 10, 200.0);

        List<DetallePrestamo> detalles = new ArrayList<>();
        detalles.add(new DetallePrestamo(libro1, 1));

        biblioteca.crearPrestamo("P007", estudiante, detalles, new Date(), new Date());
        biblioteca.adicionarLibroAlPrestamo("P007", new DetallePrestamo(libro2, 1));

        Prestamo prestamo = biblioteca.consultarPrestamoPorCodigo("P007");
        assertEquals(2, prestamo.getDetalles().size());
        LOG.info("Finalizando test para adicionar un libro a un préstamo");
    }

    /*
     * Test para entregar un préstamo
     */
    @Test
    public void testEntregarPrestamo() {
        LOG.info("Iniciando test para entregar un préstamo");
        Estudiante estudiante = new Estudiante("Sofia", "963", "963852", "sofia@example.com");
        Libro libro = new Libro("010", "ISBN010", "Autor10", "Titulo10", "Editorial10", "2023-01-01", 10, 200.0);

        List<DetallePrestamo> detalles = new ArrayList<>();
        detalles.add(new DetallePrestamo(libro, 1));

        biblioteca.crearPrestamo("P008", estudiante, detalles, new Date(), new Date());
        double costo = biblioteca.entregarPrestamo("P008", new Date());
        assertTrue(costo > 0);
        LOG.info("Finalizando test para entregar un préstamo");
    }

    /*
     * Test para consultar un préstamo por código
     */
    @Test
    public void testConsultarPrestamoPorCodigo() {
        LOG.info("Iniciando test para consultar un préstamo por código");
        Estudiante estudiante = new Estudiante("Miguel", "741", "741852", "miguel@example.com");
        Libro libro = new Libro("011", "ISBN011", "Autor11", "Titulo11", "Editorial11", "2023-01-01", 10, 200.0);

        List<DetallePrestamo> detalles = new ArrayList<>();
        detalles.add(new DetallePrestamo(libro, 1));

        biblioteca.crearPrestamo("P009", estudiante, detalles, new Date(), new Date());
        Prestamo prestamo = biblioteca.consultarPrestamoPorCodigo("P009");
        assertNotNull(prestamo);
        assertEquals("P009", prestamo.getCodigo());
        LOG.info("Finalizando test para consultar un préstamo por código");
    }

    /*
     * Test para consultar el estudiante con más préstamos
     */
    @Test
    public void testEstudianteConMasPrestamos() {
        LOG.info("Iniciando test para consultar el estudiante con más préstamos");
        Estudiante estudiante1 = new Estudiante("Juan", "123", "123456", "juan@example.com");
        Estudiante estudiante2 = new Estudiante("Maria", "456", "654321", "maria@example.com");

        Libro libro1 = new Libro("001", "ISBN001", "Autor1", "Titulo1", "Editorial1", "2023-01-01", 10, 100.0);
        Libro libro2 = new Libro("002", "ISBN002", "Autor2", "Titulo2", "Editorial2", "2023-01-01", 10, 100.0);

        List<DetallePrestamo> detalles1 = new ArrayList<>();
        detalles1.add(new DetallePrestamo(libro1, 1));
        detalles1.add(new DetallePrestamo(libro2, 1));

        List<DetallePrestamo> detalles2 = new ArrayList<>();
        detalles2.add(new DetallePrestamo(libro1, 1));

        biblioteca.crearPrestamo("P001", estudiante1, detalles1, new Date(), new Date());
        biblioteca.crearPrestamo("P002", estudiante1, detalles2, new Date(), new Date());
        biblioteca.crearPrestamo("P003", estudiante2, detalles1, new Date(), new Date());

        Estudiante estudianteConMasPrestamos = biblioteca.estudianteConMasPrestamos();
        assertEquals(estudiante1, estudianteConMasPrestamos);
        LOG.info("Finalizando test para consultar el estudiante con más préstamos");
    }

    /*
     * Test para calcular el total de dinero recaudado
     */
    @Test
    public void testTotalDineroRecaudado() {
        LOG.info("Iniciando test para calcular el total de dinero recaudado");
        Estudiante estudiante = new Estudiante("Lucia", "159", "159753", "lucia@example.com");
        Libro libro = new Libro("012", "ISBN012", "Autor12", "Titulo12", "Editorial12", "2023-01-01", 10, 200.0);

        List<DetallePrestamo> detalles = new ArrayList<>();
        detalles.add(new DetallePrestamo(libro, 1));

        biblioteca.crearPrestamo("P010", estudiante, detalles, new Date(), new Date());
        biblioteca.entregarPrestamo("P010", new Date());

        double total = biblioteca.totalDineroRecaudado();
        assertTrue(total > 0);
        assertEquals(200.0, total);
        LOG.info("Finalizando test para calcular el total de dinero recaudado");
    }

    /*
     * Test para calcular el total de dinero a pagar a los bibliotecarios
     */
    @Test
    public void testTotalDineroAPagarBibliotecarios() {
        LOG.info("Iniciando test para calcular el total de dinero a pagar a los bibliotecarios");
        biblioteca.crearBibliotecario("Carlos", "123", "123456", "carlos@example.com", 1000.0, 2015);
        biblioteca.crearBibliotecario("Ana", "456", "654321", "ana@example.com", 1200.0, 2018);

        Estudiante estudiante = new Estudiante("Luis", "789", "789456", "luis@example.com");
        Libro libro = new Libro("013", "ISBN013", "Autor13", "Titulo13", "Editorial13", "2023-01-01", 10, 200.0);

        List<DetallePrestamo> detalles = new ArrayList<>();
        detalles.add(new DetallePrestamo(libro, 1));

        biblioteca.crearPrestamo("P011", estudiante, detalles, new Date(), new Date());
        biblioteca.entregarPrestamo("P011", new Date());

        double total = biblioteca.totalDineroAPagarBibliotecarios();
        assertTrue(total > 0);
        assertEquals(2200.0, total);
        LOG.info("Finalizando test para calcular el total de dinero a pagar a los bibliotecarios");
    }
}

