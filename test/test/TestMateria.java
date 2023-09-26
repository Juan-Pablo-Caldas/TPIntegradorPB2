package test;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.Materia;

public class TestMateria {

	@Test
    public void queSePuedaAgregarUnaMateriaCorrelativa() {
        // PREPARACION
        String nombreMat = "PB2", nombreCorrelativa = "PB1";
        Integer idMateria = 1231, idCorrelativa = 4564;
        Boolean resultadoDeLaEjecucion;

        // EJECUCION
        Materia materia = new Materia(nombreMat, idMateria);
        Materia correlativa = new Materia(nombreCorrelativa, idCorrelativa);
        resultadoDeLaEjecucion = materia.agregarMateriasCorrelativas(correlativa);

        // VALIDACION
        assertTrue(resultadoDeLaEjecucion);
    }

    @Test
    public void queNoSePuedaAsignarCorrelativa() {
        // PREPARACION
        Integer id = 20, id2 = 30;
        String nombre = "PB2";
        Boolean resultado;

        // EJECUCION
        Materia materia = new Materia(nombre, id);

        resultado = materia.asignarCorrelativa(id, id2);

        // VALIDACION
        assertFalse(resultado);
    }


}
