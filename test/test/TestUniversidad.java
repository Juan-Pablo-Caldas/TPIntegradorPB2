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
	
	@Test
    public void queSePuedaIngresarProfe() {
        // PREPARACION
        String nombre = "UNLAM", nombreProfe = "Diego", apellidoProfe = "Diaz";
        Integer legajoProfe = 444;
        // EJECUCION
        Universidad unlam = new Universidad(nombre);
        Profe profesor = new Profe(nombreProfe, apellidoProfe, legajoProfe);
        Boolean ingresoElProfe;

        ingresoElProfe = unlam.ingresarProfesor(profesor);
        // VALIDACION
        assertTrue(ingresoElProfe);

    }
@Test
    public void queNoSePuedaIngresarProfesoresConMismoDNI() {
        // PREPARACION

        String nombre = "UNLAM", nombreProfe = "Diego", apellidoProfe = "Diaz";
        Integer dni = 444, numeroEsperado = 1;

        // EJECUCION

        Universidad unlam = new Universidad(nombre);
        Profe profesor = new Profe(nombreProfe, apellidoProfe, dni);
        Profe profesor2 = new Profe(nombreProfe, apellidoProfe, dni);
        Boolean ingresoElProfe;

        unlam.ingresarProfesor(profesor);
        ingresoElProfe = unlam.ingresarProfesor(profesor2);

        // VALIDACION

        assertFalse(ingresoElProfe);
        assertEquals(numeroEsperado, unlam.getCantidadDeProfesores());
    }
@Test
    public void queSePuedaIngresarMateria() {
        // PREPARACION

        String nombre = "UNLAM", nombreMateria = "PB2";
        Integer codigoMateria = 88;

        // EJECUCION

        Universidad unlam = new Universidad(nombre);
        Materia materia = new Materia(nombreMateria, codigoMateria);
        Boolean ingresoLaMateria;

        ingresoLaMateria = unlam.ingresarMateria(materia);

        // VALIDACION

        assertTrue(ingresoLaMateria);
    }

}
