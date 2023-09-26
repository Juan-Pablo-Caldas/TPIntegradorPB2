package test;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.Aula;

public class TestAula {

	@Test
    public void queSePuedaAsignarCapacidadEntre40y100AUnAula() {
        // PREPARACION
        Integer numAula = 1, capacidadMaximaAula = 100, capacidadActual = 50, capacidadEsperada;

        // EJECUCION
        Aula aula = new Aula(capacidadMaximaAula, numAula);
        aula.asignarCapacidad(capacidadActual);
        capacidadEsperada = aula.getCapacidad();

        // VALIDACION
        assertEquals(capacidadActual, capacidadEsperada);
    }

    @Test
    public void queNoSePuedaAsignarCapacidadMenorDe40yMayorDe100AUnAula() {
        // PREPARACION
        Integer numAula = 1, capacidadMaximaAula = 100, capacidadActual = 300, capacidadEsperada;

        // EJECUCION
        Aula aula = new Aula(capacidadMaximaAula, numAula);
        aula.asignarCapacidad(capacidadActual);
        capacidadEsperada = aula.getCapacidad();

        // VALIDACION
        assertNotEquals(capacidadActual, capacidadEsperada);
    }


}
