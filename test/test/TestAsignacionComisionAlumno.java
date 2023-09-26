package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import clases.Alumno;
import clases.AsignacionComisionAlumno;
import clases.Aula;
import clases.CicloLectivo;
import clases.Comision;
import clases.Dia;
import clases.Materia;
import clases.Nota;
import clases.TipoNota;
import clases.Turnos;

public class TestAsignacionComisionAlumno {

	@Test
	public void queSePuedaInscribirUnAlumnoAlaComision() {
		// PREPARACION
		String nombre = "Juan", apellido = "Caldas", nombreMat = "PB2";
		Integer id = 5, dniAlumno = 5555, idComision = 5, codigoMat = 89, idCiclo = 29302, anio = 2023, diaInicio = 5,
				mesInicio = 3, mesFinalizacion = 12, diaFinalizacion = 27;
		Boolean resultado;
		Turnos turno = Turnos.MAÑANA;
		Dia dia = Dia.JUEVES;

		// EJECUCION
		Alumno alumno = new Alumno(nombre, apellido, dniAlumno);
		Aula aula = new Aula(100, 123123);
		Materia materia = new Materia(nombreMat, codigoMat);
		CicloLectivo ciclo = new CicloLectivo(idCiclo, anio, mesInicio, diaInicio, mesFinalizacion, diaFinalizacion);
		ciclo.ingresarFechaDeInscripcion(anio, 5, 30);
		ciclo.ingresarFechaDeFinalizacionDeLaInscripcion(anio, 12, 23);
		aula.asignarCapacidad(50);
		Comision comision = new Comision(idComision, materia, ciclo, turno, dia);
		comision.ingresarAula(aula);
		AsignacionComisionAlumno a = new AsignacionComisionAlumno(id, alumno, comision);
		resultado = a.inscribirAlumnoAComision(dniAlumno, idComision);

		// VALIDACION

		assertTrue(resultado);
	}

	@Test
	public void queSePuedaInscribirUnAlumnoAComisionConMateriaAprobadaDiferenteALaDeLaComision() {
		// PREPARACION
		String nombreMat = "PB2", nombreA = "Victoria", apellidoA = "Junco";
		Integer idComision = 2900, codigoMat = 1231, idCiclo = 45, anioCiclo = 2023, mesInicioCiclo = 3,
				diaInicioCiclo = 12, mesFinalCiclo = 12, diaFinalCiclo = 30, dniA = 45;
		Turnos turno = Turnos.MAÑANA;
		Dia dia = Dia.JUEVES;
		Boolean resultadoDeLaEjecucion;

		// EJECUCION

		Alumno alumno = new Alumno(nombreA, apellidoA, dniA);
		Materia materia = new Materia(nombreMat, codigoMat);
		Materia materiaAprobada = new Materia("Pb1", 789);
		CicloLectivo ciclo = new CicloLectivo(idCiclo, anioCiclo, mesInicioCiclo, diaInicioCiclo, mesFinalCiclo,
				diaFinalCiclo);
		ciclo.ingresarFechaDeInscripcion(anioCiclo, 5, 30);
		ciclo.ingresarFechaDeFinalizacionDeLaInscripcion(anioCiclo, 12, 23);

		Comision comision = new Comision(idComision, materia, ciclo, turno, dia);
		Comision queYaTiene = new Comision(3900, materiaAprobada, ciclo, Turnos.NOCHE, Dia.SABADO);
		Aula aula = new Aula(100, 15);
		aula.asignarCapacidad(50);
		comision.ingresarAula(aula);
		alumno.asignarMateriasAprobadas(materiaAprobada);
		alumno.asignarComision(queYaTiene);
		AsignacionComisionAlumno a = new AsignacionComisionAlumno(32323, alumno, comision);
		resultadoDeLaEjecucion = a.inscribirAlumnoAComision(dniA, idComision);

		// VALIDACION
		assertTrue(resultadoDeLaEjecucion);
	}

	@Test
	public void queSePuedaValidarFechasDeInscripcion() {
		// PREPARACION
		String nombreMat = "PB2", nombreA = "Juan", apellidoA = "Caldas";
		Integer idComision = 2900, codigoMat = 1231, idCiclo = 45, anioCiclo = 2023, mesInicioCiclo = 3,
				diaInicioCiclo = 12, mesFinalCiclo = 7, diaFinalCiclo = 15, dniA = 3333;
		Turnos turno = Turnos.MAÑANA;
		Dia dia = Dia.JUEVES;
		Boolean resultadoDeLaEjecucion;

		// EJECUCION
		Alumno alumno = new Alumno(nombreA, apellidoA, dniA);
		Materia materia = new Materia(nombreMat, codigoMat);
		CicloLectivo ciclo = new CicloLectivo(idCiclo, anioCiclo, mesInicioCiclo, diaInicioCiclo, mesFinalCiclo,
				diaFinalCiclo);
		ciclo.ingresarFechaDeInscripcion(anioCiclo, 5, 30);
		ciclo.ingresarFechaDeFinalizacionDeLaInscripcion(anioCiclo, 12, 23);
		Comision comision = new Comision(idComision, materia, ciclo, turno, dia);
		AsignacionComisionAlumno a = new AsignacionComisionAlumno(123123, alumno, comision);
		resultadoDeLaEjecucion = a.validarFechaDeInscripcion(idComision);

		// VALIDACION
		assertTrue(resultadoDeLaEjecucion); // FECHA ACTUAL PASADA DE TERMINO
	}

	@Test
	public void queSePuedaValidarCapacidadDeAula() { // VALIDAD CAPACIDAD LLENA
		// PREPARACION
		String nombreMat = "PB2", nombreA = "Juan", apellidoA = "Caldas";
		Integer idComision = 2900, codigoMat = 1231, idCiclo = 45, anioCiclo = 2023, mesInicioCiclo = 3,
				diaInicioCiclo = 12, mesFinalCiclo = 7, diaFinalCiclo = 15, dniA = 3333;
		Turnos turno = Turnos.MAÑANA;
		Dia dia = Dia.JUEVES;
		Boolean resultadoDeLaEjecucion;

		// EJECUCION
		Alumno alumno = new Alumno(nombreA, apellidoA, dniA);
		Materia materia = new Materia(nombreMat, codigoMat);
		CicloLectivo ciclo = new CicloLectivo(idCiclo, anioCiclo, mesInicioCiclo, diaInicioCiclo, mesFinalCiclo,
				diaFinalCiclo);
		ciclo.ingresarFechaDeInscripcion(anioCiclo, 5, 30);
		ciclo.ingresarFechaDeFinalizacionDeLaInscripcion(anioCiclo, 12, 23);
		Comision comision = new Comision(idComision, materia, ciclo, turno, dia);
		Aula aula = new Aula(100, 15);
		aula.asignarCapacidad(50);

		comision.ingresarAula(aula);
		AsignacionComisionAlumno a = new AsignacionComisionAlumno(23123, alumno, comision);
		resultadoDeLaEjecucion = a.validarCapacidadDeAula(idComision);

		// VALIDACION
		assertTrue(resultadoDeLaEjecucion);
	}

}
