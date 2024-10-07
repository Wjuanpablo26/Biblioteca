package co.edu.uniquindio.poo;
import co.edu.uniquindio.poo.model.Libro;
import org.junit.jupiter.api.Test;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;


public class LibroTest {

    private static final Logger LOG = Logger.getLogger(BibliotecarioTest.class.getName());

    /*
     * Test para crear un libro
     */
    @Test
    public void testCrearLibro() {
        LOG.info("Iniciando test para crear un libro");
        Libro libro = new Libro("001", "123456789", "Autor", "Titulo", "Editorial", "2023-01-01", 10, 99.99);
        assertEquals("001", libro.getCodigo());
        assertEquals("123456789", libro.getIsbn());
        assertEquals("Autor", libro.getAutor());
        assertEquals("Titulo", libro.getTitulo());
        assertEquals("Editorial", libro.getEditorial());
        assertEquals("2023-01-01", libro.getFecha());
        assertEquals(10, libro.getUnidadesDisponibles());
        assertEquals(99.99, libro.getPrecio());
        LOG.info("Finalizando test para crear un libro");
    }

    /*
     * Test para actualizar un libro
     */
    @Test
    public void testActualizarLibro() {
        LOG.info("Iniciando test para actualizar un libro");
        Libro libro = new Libro("001", "123456789", "Autor", "Titulo", "Editorial", "2023-01-01", 10, 99.99);
        libro.setCodigo("002");
        libro.setIsbn("987654321");
        libro.setAutor("Nuevo Autor");
        libro.setTitulo("Nuevo Titulo");
        libro.setEditorial("Nueva Editorial");
        libro.setFecha("2023-02-01");
        libro.setPrecio(79.99);

        assertEquals("002", libro.getCodigo());
        assertEquals("987654321", libro.getIsbn());
        assertEquals("Nuevo Autor", libro.getAutor());
        assertEquals("Nuevo Titulo", libro.getTitulo());
        assertEquals("Nueva Editorial", libro.getEditorial());
        assertEquals("2023-02-01", libro.getFecha());
        assertEquals(79.99, libro.getPrecio());
        LOG.info("Finalizando test para actualizar un libro");
    }

    /*
     * Test para actualizar las unidades disponibles
     */
    @Test
    public void testActualizarUnidadesDisponibles() {
        LOG.info("Iniciando test para actualizar las unidades disponibles de un libro");
        Libro libro = new Libro("001", "123456789", "Autor", "Titulo", "Editorial", "2023-01-01", 10, 99.99);
        libro.actualizarUnidadesDisponibles(5);
        assertEquals(15, libro.getUnidadesDisponibles());
        libro.actualizarUnidadesDisponibles(-3);
        assertEquals(12, libro.getUnidadesDisponibles());
        LOG.info("Finalizando test para actualizar las unidades disponibles de un libro");
    }

    /*
     * Test para prestar un libro
     */
    @Test
    public void testPrestar() {
        LOG.info("Iniciando test para prestar un libro");
        Libro libro = new Libro("001", "123456789", "Autor", "Titulo", "Editorial", "2023-01-01", 10, 99.99);
        libro.prestar();
        assertEquals(9, libro.getUnidadesDisponibles());
        LOG.info("Finalizando test para prestar un libro");
    }

    /*
     * Test para devolver un libro
     */
    @Test
    public void testDevolver() {
        LOG.info("Iniciando test para devolver un libro");
        Libro libro = new Libro("001", "123456789", "Autor", "Titulo", "Editorial", "2023-01-01", 10, 99.99);
        libro.devolver();
        assertEquals(11, libro.getUnidadesDisponibles());
        LOG.info("Finalizando test para devolver un libro");
    }
}
