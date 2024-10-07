package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import co.edu.uniquindio.poo.model.Estudiante;

public class EstudianteTest {

    private static final Logger LOG = Logger.getLogger(EstudianteTest.class.getName());

    /*
     * Test para actualizar un estudiante
     */
    @Test
    public void testActualizarEstudiante() {
        LOG.info("Iniciando test para getters y setters de Estudiante");
        Estudiante estudiante = new Estudiante("Juan", "123456", "555-1234", "juan@example.com");

        assertEquals("Juan", estudiante.getNombre());
        assertEquals("123456", estudiante.getCedula());
        assertEquals("555-1234", estudiante.getTelefono());
        assertEquals("juan@example.com", estudiante.getCorreo());

        estudiante.setNombre("Carlos");
        estudiante.setCedula("654321");
        estudiante.setTelefono("555-4321");
        estudiante.setCorreo("carlos@example.com");

        assertEquals("Carlos", estudiante.getNombre());
        assertEquals("654321", estudiante.getCedula());
        assertEquals("555-4321", estudiante.getTelefono());
        assertEquals("carlos@example.com", estudiante.getCorreo());
        LOG.info("Finalizando test para getters y setters de Estudiante");
    }

    /*
     * Test para crear un estudiante
     */
    @Test
    public void testCrearEstudiante() {
        LOG.info("Iniciando test para constructor de Estudiante");
        Estudiante estudiante = new Estudiante("Ana", "789012", "555-5678", "ana@example.com");

        assertNotNull(estudiante);
        assertEquals("Ana", estudiante.getNombre());
        assertEquals("789012", estudiante.getCedula());
        assertEquals("555-5678", estudiante.getTelefono());
        assertEquals("ana@example.com", estudiante.getCorreo());
        LOG.info("Finalizando test para constructor de Estudiante");
    }
    
}
