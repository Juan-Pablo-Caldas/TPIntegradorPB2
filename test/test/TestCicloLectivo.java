package test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import clases.CicloLectivo;

public class TestCicloLectivo {
	@Test
	public void queSeAsigneFechaDeInicio() {
		//PREPARACION
		Integer id = 20, anio = 2023, mesInicio = 4, diaInicio = 12, mesFinalizacion = 8, diaFinalizacion = 27;
		LocalDate fechaAComparar = LocalDate.of(anio, mesInicio, diaInicio);
		LocalDate fechaEsperada;

		//EJECUCION
		CicloLectivo ciclo = new CicloLectivo(id, anio, mesInicio, diaInicio, mesFinalizacion, diaFinalizacion);
		ciclo.ingresarFechaDeInscripcion(anio, mesInicio, diaInicio);
		fechaEsperada = ciclo.getFechaInicioInscripcion();

		//VALIDACION
		assertEquals(fechaAComparar, fechaEsperada);
	}

	@Test
	public void queSeAsigneFechaFinalizacion() {
		//PREPACION
		Integer id = 20, anio = 2023, mesInicio = 4, diaInicio = 12, mesFinalizacion = 8, diaFinalizacion = 27;
		LocalDate fechaAComparar = LocalDate.of(anio, mesFinalizacion, diaFinalizacion);
		LocalDate fechaEsperada;

		//EJECUCION
		CicloLectivo ciclo = new CicloLectivo(id, anio, mesInicio, diaInicio, mesFinalizacion, diaFinalizacion);
		ciclo.ingresarFechaDeFinalizacionDeLaInscripcion(anio, mesFinalizacion, diaFinalizacion);
		fechaEsperada = ciclo.getFechaFinalizacionCiclo();

		//VALIDACION
		assertEquals(fechaAComparar, fechaEsperada);
	}

}
