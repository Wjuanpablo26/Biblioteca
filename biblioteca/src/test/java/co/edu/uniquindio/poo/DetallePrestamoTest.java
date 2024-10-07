package co.edu.uniquindio.poo;
import co.edu.uniquindio.poo.model.DetallePrestamo;
import co.edu.uniquindio.poo.model.Libro;
import org.junit.jupiter.api.Test;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;


public class DetallePrestamoTest {


    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    /*
     * Test para crear un detalle de préstamo
     */
    @Test
    public void testCrearDetallePrestamo() {
        LOG.info("Iniciando test para constructor y getters de DetallePrestamo");
        Libro libro = new Libro("004", "ISBN004", "Autor4", "Titulo4", "Editorial4", "2023-01-01", 5, 150.0);
        DetallePrestamo detallePrestamo = new DetallePrestamo(libro, 2);

        assertEquals(libro, detallePrestamo.getLibro());
        assertEquals(2, detallePrestamo.getCantidad());
        assertEquals(300.0, detallePrestamo.getSubtotal());
        LOG.info("Finalizando test para constructor y getters de DetallePrestamo");
    }

    /*
     * Test para calcular el subtotal de un detalle de préstamo
     */
    @Test
    public void testCalcularSubtotal() {
        LOG.info("Iniciando test para calcular subtotal de DetallePrestamo");
        Libro libro = new Libro("004", "ISBN004", "Autor4", "Titulo4", "Editorial4", "2023-01-01", 5, 102.0);
        DetallePrestamo detallePrestamo = new DetallePrestamo(libro, 3);

        assertEquals(306.0, detallePrestamo.getSubtotal());
        LOG.info("Finalizando test para calcular subtotal de DetallePrestamo");
    }

    /*
     * Test para obtener el precio de un libro
     */
    @Test
    public void testGetPrecio() {
        LOG.info("Iniciando test para obtener precio de DetallePrestamo");
        Libro libro = new Libro("004", "ISBN004", "Autor4", "Titulo4", "Editorial4", "2023-01-01", 5, 50.0);
        DetallePrestamo detallePrestamo = new DetallePrestamo(libro, 1);

        assertEquals(50.0, detallePrestamo.getPrecio());
        LOG.info("Finalizando test para obtener precio de DetallePrestamo");
    }
}
