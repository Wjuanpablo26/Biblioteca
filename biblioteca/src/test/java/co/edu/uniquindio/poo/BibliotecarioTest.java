package co.edu.uniquindio.poo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import co.edu.uniquindio.poo.model.Bibliotecario;

public class BibliotecarioTest {

    private static final Logger LOG = Logger.getLogger(BibliotecarioTest.class.getName());

    /*
     * Test para actualizar un bibliotecario
     */
    @Test
    public void testActualizarBibliotecario() {
        LOG.info("Iniciando test para actualizar un bibliotecario");
        Bibliotecario bibliotecario = new Bibliotecario("Pedro", "987654", "555-9876", "pedro@example.com", 3000.0,2022);

        assertEquals("Pedro", bibliotecario.getNombre());
        assertEquals("987654", bibliotecario.getCedula());
        assertEquals("555-9876", bibliotecario.getTelefono());
        assertEquals("pedro@example.com", bibliotecario.getCorreo());
        assertEquals(3000.0, bibliotecario.getSalario());
        assertEquals(2022, bibliotecario.getAnoIngreso());

        bibliotecario.setNombre("Luis");
        bibliotecario.setCedula("456789");
        bibliotecario.setTelefono("555-6789");
        bibliotecario.setCorreo("luis@example.com");
        bibliotecario.setSalario(3500.0);
        bibliotecario.setIngreso(2021);

        assertEquals("Luis", bibliotecario.getNombre());
        assertEquals("456789", bibliotecario.getCedula());
        assertEquals("555-6789", bibliotecario.getTelefono());
        assertEquals("luis@example.com", bibliotecario.getCorreo());
        assertEquals(3500.0, bibliotecario.getSalario());
        assertEquals(2021, bibliotecario.getAnoIngreso());
        LOG.info("Finalizando test para actualizar un bibliotecario");
    }

    /*
     * Test para crear un bibliotecario
     */
    @Test
    public void testCrearBibliotecario() {
        LOG.info("Iniciando test para crear un bibliotecario");
        Bibliotecario bibliotecario = new Bibliotecario("Maria", "321654", "555-3216", "maria@example.com", 4000.0,2021);

        assertNotNull(bibliotecario);
        assertEquals("Maria", bibliotecario.getNombre());
        assertEquals("321654", bibliotecario.getCedula());
        assertEquals("555-3216", bibliotecario.getTelefono());
        assertEquals("maria@example.com", bibliotecario.getCorreo());
        assertEquals(4000.0, bibliotecario.getSalario());
        assertEquals(2021, bibliotecario.getAnoIngreso());
        LOG.info("Finalizando test para crear un bibliotecario");
    }

    
}
