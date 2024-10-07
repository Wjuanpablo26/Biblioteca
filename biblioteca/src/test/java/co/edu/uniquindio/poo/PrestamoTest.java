package co.edu.uniquindio.poo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import co.edu.uniquindio.poo.model.DetallePrestamo;
import co.edu.uniquindio.poo.model.Estudiante;
import co.edu.uniquindio.poo.model.Libro;
import co.edu.uniquindio.poo.model.Prestamo;

public class PrestamoTest {
    
    private static final Logger LOG = Logger.getLogger(BibliotecarioTest.class.getName());
    
    /*
     * Test para calcular el costo de un préstamo
     */
    @Test
    public void testCalcularCostoPrestamo() {
        LOG.info("Iniciando test para calcularCosto");
        Estudiante estudiante = new Estudiante("Carlos", "123456", "555-1234", "carlos@example.com");
        Libro libro1 = new Libro("001", "123-456-789", "Autor1", "Título1", "Editorial1", "1994", 10,2.0);
        Libro libro2 = new Libro("002", "987-654-321", "Autor2", "Título2", "Editorial2", "2005", 5,3.0);
        List<DetallePrestamo> detalles = Arrays.asList(new DetallePrestamo(libro1, 1), new DetallePrestamo(libro2, 1));
        Date fechaPrestamo = new Date();
        Date fechaEntrega = new Date(fechaPrestamo.getTime() + (5 * 24 * 60 * 60 * 1000));

        Prestamo prestamo = new Prestamo("P001", estudiante, detalles, fechaPrestamo, fechaEntrega);

        assertEquals(5.0, prestamo.calcularCosto());
        LOG.info("Finalizando test para calcularCosto");
    }

    /*
     * Test para crear un préstamo
     */
    @Test
    public void testCrearPrestamo() {
        LOG.info("Iniciando test para crear un préstamo");
        Estudiante estudiante = new Estudiante("Ana", "789012", "555-5678", "ana@example.com");
        Libro libro1 = new Libro("003", "111-222-333", "Autor3", "Título3", "Editorial3", "2006", 8,2.5);
        List<DetallePrestamo> detalles = Arrays.asList(new DetallePrestamo(libro1, 1));
        Date fechaPrestamo = new Date();
        Date fechaEntrega = new Date(fechaPrestamo.getTime() + (3 * 24 * 60 * 60 * 1000));

        Prestamo prestamo = new Prestamo("P002", estudiante, detalles, fechaPrestamo, fechaEntrega);

        assertNotNull(prestamo);
        assertEquals("P002", prestamo.getCodigo());
        assertEquals(estudiante, prestamo.getEstudiante());
        assertEquals(detalles, prestamo.getDetalles());
        assertEquals(fechaPrestamo, prestamo.getFechaPrestamo());
        assertEquals(fechaEntrega, prestamo.getFechaEntrega());
        assertEquals(2.5, prestamo.calcularCosto());
        LOG.info("Finalizando test para crear un préstamo");
    }
}
