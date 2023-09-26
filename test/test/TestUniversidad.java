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

	@Test
	public void queNoSePuedaIngresarMateriasConMismoId() {
		// PREPARACION

		String nombre = "UNLAM", nombreMateria = "PB2";
		Integer codigoMateria = 88, numeroEsperado = 1;

		// EJECUCION

		Universidad unlam = new Universidad(nombre);
		Materia materia = new Materia(nombreMateria, codigoMateria);
		Materia materia2 = new Materia(nombreMateria, codigoMateria);
		Boolean ingresoLaMateria;

		ingresoLaMateria = unlam.ingresarMateria(materia);
		ingresoLaMateria = unlam.ingresarMateria(materia2);

		// VALIDACION

		assertFalse(ingresoLaMateria);
		assertEquals(numeroEsperado, unlam.getCantidadDeMaterias());
	}

	@Test
	public void queSePuedaIngresarComision() {
		// PREPARACION

		String nombre = "UNLAM", nombreMateria = "PB2", diaCurso = "Miercoles";
		Integer codigoComision = 88, codigoMateria = 444, id = 20, anio = 2023, mesInicio = 4, diaInicio = 12,
				mesFinalizacion = 8, diaFinalizacion = 27;
		Turnos turno = Turnos.MAÑANA;
		Dia dia = Dia.SABADO;
		Boolean ingresoLaComision;

		// EJECUCION

		Universidad unlam = new Universidad(nombre);
		Materia materia = new Materia(nombreMateria, codigoMateria);
		CicloLectivo ciclo = new CicloLectivo(id, anio, mesInicio, diaInicio, mesFinalizacion, diaFinalizacion);
		Comision comision = new Comision(codigoComision, materia, ciclo, turno, dia);

		ingresoLaComision = unlam.ingresarComision(comision);

		// VALIDACION

		assertTrue(ingresoLaComision);
	}

	@Test
	public void queNoSePuedaIngresarComisionesConLaMismaMateriaMismoCicloYMismoTurno() {
		// PREPARACION

		String nombre = "UNLAM", nombreMateria = "PB2";
		Integer codigoComision = 88, codigoMateria = 444, esperado = 1, id = 20, anio = 2023, mesInicio = 4,
				diaInicio = 12, mesFinalizacion = 8, diaFinalizacion = 27;

		Turnos turno = Turnos.MAÑANA;
		Dia dia = Dia.SABADO;
		Boolean ingresoLaComision;

		// EJECUCION

		Universidad unlam = new Universidad(nombre);
		Materia materia = new Materia(nombreMateria, codigoMateria);
		CicloLectivo ciclo = new CicloLectivo(id, anio, mesInicio, diaInicio, mesFinalizacion, diaFinalizacion);
		Comision comision = new Comision(codigoComision, materia, ciclo, turno, dia);
		Comision comision2 = new Comision(codigoComision, materia, ciclo, turno, dia);

		ingresoLaComision = unlam.ingresarComision(comision);
		ingresoLaComision = unlam.ingresarComision(comision2);

		// VALIDACION

		assertFalse(ingresoLaComision);
		assertEquals(esperado, unlam.getCantidadDeComisiones());
	}
	
	@Test
    public void queSePuedaIngresarAula() {
        // PREPARACION

        String nombre = "UNLAM";
        Integer codigoAula = 40;
        Boolean ingresoElAula;

        // EJECUCION

        Universidad unlam = new Universidad(nombre);

        Aula aula = new Aula(20, codigoAula);

        ingresoElAula = unlam.ingresarAula(aula);

        // VALIDACION

        assertTrue(ingresoElAula);
    }
@Test
    public void queSePuedaIngresarUnCicloLectivo() {

        // PREPARACION

        String nombre = "unlam";
        Integer id = 20, anio = 2023, mesInicio = 4, diaInicio = 12, mesFinalizacion = 8, diaFinalizacion = 27;
        Boolean resultado;

        // EJECUCION

        CicloLectivo ciclo = new CicloLectivo(id, anio, mesInicio, diaInicio, mesFinalizacion, diaFinalizacion);
        ciclo.ingresarFechaDeInscripcion(anio, 5, 10);
        ciclo.ingresarFechaDeFinalizacionDeLaInscripcion(anio, 12, 28);

        Universidad unlam = new Universidad(nombre);
        resultado = unlam.ingresarCicloLectivo(ciclo);

        // VALIDACION

        assertTrue(resultado);

    }
@Test
    public void queNoSePuedaIngresarCiclosLectivosConMismoIDyMismosRangosDeFechas() {
        // PREPARACION
        String nombre = "unlam";
        Integer id = 20, numeroEsperado = 1, anio = 2023, mesInicio = 4, diaInicio = 12, mesFinalizacion = 8,
                diaFinalizacion = 27;
        Boolean resultado;

        // EJECUCION

        CicloLectivo ciclo = new CicloLectivo(id, anio, mesInicio, diaInicio, mesFinalizacion, diaFinalizacion);

        CicloLectivo ciclo2 = new CicloLectivo(id, anio, mesInicio, diaInicio, mesFinalizacion, diaFinalizacion);

        Universidad unlam = new Universidad(nombre);
        resultado = unlam.ingresarCicloLectivo(ciclo);
        resultado = unlam.ingresarCicloLectivo(ciclo2);

        // VALIDACION

        assertFalse(resultado);

        assertEquals(numeroEsperado, unlam.getCantidadDeCiclosLectivos());

    }

}
