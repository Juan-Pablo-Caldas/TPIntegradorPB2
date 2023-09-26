package test;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import clases.Alumno;
import clases.AsignacionComisionAlumno;
import clases.AsignacionComisionProfe;
import clases.Aula;
import clases.CicloLectivo;
import clases.Comision;
import clases.Dia;
import clases.Materia;
import clases.Profe;
import clases.Turnos;
import clases.Universidad;

public class TestUniversidad {
	@Test
	public void queSePuedaIngresarUnaUniversidad() {
		// PREPARACION
		String nombre = "UNLAM";
		// EJECUCION
		Universidad unlam = new Universidad(nombre);
		// VALIDACION
		assertNotNull(unlam);

	}

	@Test
	public void queSePuedaIngresarAlumno() {
		// PREPARACION
		String nombre = "UNLAM", nombreAlumno = "Juan", apellidoAlumno = "Caldas";
		Integer dniAlumno = 222;
		// EJECUCION
		Universidad unlam = new Universidad(nombre);
		Alumno alumno = new Alumno(nombreAlumno, apellidoAlumno, dniAlumno);
		Boolean ingresoElAlumno;

		ingresoElAlumno = unlam.ingresarAlumno(alumno);
		// VALIDACION
		assertTrue(ingresoElAlumno);
	}

	@Test
	public void queNoSePuedaIngresarAlumnosConMismosDNI() {
		// PREPARACION
		String nombre = "UNLAM", nombreAlumno = "Juan", apellidoAlumno = "Caldas";
		Integer dniAlumno = 222, numeroEsperado = 1;
		// EJECICION
		Universidad unlam = new Universidad(nombre);
		Alumno alumno = new Alumno(nombreAlumno, apellidoAlumno, dniAlumno);
		Alumno alumno2 = new Alumno(nombreAlumno, apellidoAlumno, dniAlumno);
		Boolean ingresoElAlumno;

		ingresoElAlumno = unlam.ingresarAlumno(alumno);
		ingresoElAlumno = unlam.ingresarAlumno(alumno2);
		// VALIDACION
		assertFalse(ingresoElAlumno);
		assertEquals(numeroEsperado, unlam.getCantidadDeAlumnos());
	}

}
