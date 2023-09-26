package test;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.Nota;
import clases.TipoNota;

public class TestNota {

	@Test
	public void queSePuedaAsignarValorDeNota() {
		// PREPARACION
		Double valor = 7.0;
		TipoNota tipo = TipoNota.PRIMERPARCIAL;
		Boolean resultadoDeLaEjecucion;

		// EJECUCION
		Nota nota = new Nota(tipo);
		resultadoDeLaEjecucion = nota.asignarValorDeNota(valor);

		// VALIDACION
		assertTrue(resultadoDeLaEjecucion);
	}

	@Test
	public void queNoSePuedaAsignarValorDeNotaYaQueNoEstaEnParametros() {
		// PREPARACION
		Double valor = 11.0;
		TipoNota tipo = TipoNota.PRIMERPARCIAL;
		Boolean resultadoDeLaEjecucion;

		// EJECUCION
		Nota nota = new Nota(tipo);
		resultadoDeLaEjecucion = nota.asignarValorDeNota(valor);

		// VALIDACION
		assertFalse(resultadoDeLaEjecucion);
	}

}
