package test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.Test;

import clases.CicloLectivo;

public class TestCicloLectivo {
	@Test
	public void queSeAsigneFechaDeInicio() {
		Integer id = 20, anio = 2023, mesInicio = 4, diaInicio = 12, mesFinalizacion = 8, diaFinalizacion = 27;
		LocalDate fechaAComparar = LocalDate.of(anio, mesInicio, diaInicio);
		LocalDate fechaEsperada;

		CicloLectivo ciclo = new CicloLectivo(id, anio, mesInicio, diaInicio, mesFinalizacion, diaFinalizacion);
		ciclo.ingresarFechaDeInscripcion(anio, mesInicio, diaInicio);

		fechaEsperada = ciclo.getFechaInicioInscripcion();

		assertEquals(fechaAComparar, fechaEsperada);

	}

	@Test
	public void queSeAsigneFechaFinalizacion() {
		Integer id = 20, anio = 2023, mesInicio = 4, diaInicio = 12, mesFinalizacion = 8, diaFinalizacion = 27;
		LocalDate fechaAComparar = LocalDate.of(anio, mesFinalizacion, diaFinalizacion);
		LocalDate fechaEsperada;

		CicloLectivo ciclo = new CicloLectivo(id, anio, mesInicio, diaInicio, mesFinalizacion, diaFinalizacion);
		// ciclo.ingresarFechaDeInscripcion(anio, 3, 4);
		ciclo.ingresarFechaDeFinalizacionDeLaInscripcion(anio, mesFinalizacion, diaFinalizacion);
		fechaEsperada = ciclo.getFechaFinalizacionCiclo();

		assertEquals(fechaAComparar, fechaEsperada);

	}

}
