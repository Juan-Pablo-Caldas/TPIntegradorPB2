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

	@Test
	public void queSePuedaAsignarAulaAComision() { // NO CREO QUE SE PONGA ACA

		// PREPARACION

		String nombre = "unlam", nombreMateria = "PB2";
		Integer idComision = 4, dniProfe = 444, codigoMateria = 7, id = 20, anio = 2023, mesInicio = 4, diaInicio = 12,
				mesFinalizacion = 8, diaFinalizacion = 27;

		Boolean respuesta;

		// EJECUCION

		Universidad universidad = new Universidad(nombre);
		Profe profesor = new Profe("Andy", "A", dniProfe);
		Materia materia = new Materia(nombreMateria, codigoMateria);
		CicloLectivo ciclo = new CicloLectivo(id, anio, mesInicio, diaInicio, mesFinalizacion, diaFinalizacion);
		Turnos turno = Turnos.MAÑANA;
		Dia dia = Dia.MIERCOLES;
		Comision comision = new Comision(idComision, materia, ciclo, turno, dia);
		Aula aula = new Aula(100, id);
		aula.asignarCapacidad(50);

		universidad.ingresarComision(comision);
		universidad.ingresarProfesor(profesor);

		respuesta = universidad.asignarAulaAlaComision(idComision, dniProfe, aula);

		// VALIDACION

		assertTrue(respuesta);

	}

	@Test
	public void queSePuedaAgregarUnaMateriaCorrelativa() {
		// PREPARACION
		String nombreUni = "UnLam", nombreCorrelativa = "PB1", nombreMateria = "PB2";
		Integer idCorrelativa = 4564, idMateria = 1231;
		Boolean resultadoDeLaEjecucion;

		// EJECUCION
		Materia materia = new Materia(nombreMateria, idMateria);
		Materia correlativa = new Materia(nombreMateria, idCorrelativa);
		Universidad uni = new Universidad(nombreUni);
		uni.ingresarMateria(materia);
		resultadoDeLaEjecucion = uni.agregarMateriaCorrelativa(correlativa, idMateria);

		// VALIDACION
		assertTrue(resultadoDeLaEjecucion);
	}

	@Test
	public void queSePuedaAsignarUnaMateriaCorrelativa() {
		// PREPARACION
		String nombreMat = "PB2", nombreUni = "UnLam", nombreCorrelativa = "PB1";
		Integer idMateria = 1231, idCorrelativa = 4564;
		Boolean resultadoDeLaEjecucion;

		// EJECUCION
		Materia materia = new Materia(nombreMat, idMateria);
		Materia correlativa = new Materia(nombreMat, idCorrelativa);
		Universidad uni = new Universidad(nombreUni);
		uni.ingresarMateria(materia);
		uni.agregarMateriaCorrelativa(correlativa, idMateria);
		resultadoDeLaEjecucion = uni.agregarCorrelatividad(idMateria, idCorrelativa);

		// VALIDACION
		assertTrue(resultadoDeLaEjecucion);
	}

	@Test
	public void queSePuedaEliminarUnaMateriaCorrelativa() {
		// PREPARACION
		String nombreMat = "PB2", nombreUni = "UnLam", nombreCorrelativa = "PB1";
		Integer idMateria = 1231, idCorrelativa = 4564;
		Boolean resultadoDeLaEjecucion;

		// EJECUCION
		Materia materia = new Materia(nombreMat, idMateria);
		Materia correlativa = new Materia(nombreMat, idCorrelativa);
		Universidad uni = new Universidad(nombreUni);
		uni.ingresarMateria(materia);
		uni.agregarMateriaCorrelativa(correlativa, idMateria);
		uni.agregarCorrelatividad(idMateria, idCorrelativa);
		resultadoDeLaEjecucion = uni.eliminarCorrelativa(idMateria, idCorrelativa);

		// VALIDACION
		assertTrue(resultadoDeLaEjecucion);
	}

	@Test
	public void queSePuedaIngresarAsignacionComisionProfesor() {
		// PREPARACION
		String nombreP = "Andres", apellidoP = "Bogota", nombreM = "PB2", nombreUni = "UnLam";
		Integer idAsignacion = 15, dniP = 4564, idM = 65;
		Boolean resultadoDeLaEjecucion;

		// EJECUCION
		Universidad uni = new Universidad(nombreUni);
		Profe profesor = new Profe(nombreP, apellidoP, dniP);
		Materia materia = new Materia(nombreM, idM);
		CicloLectivo ciclo = new CicloLectivo(89, 2023, 5, 12, 12, 5);
		Comision comision = new Comision(85, materia, ciclo, Turnos.MAÑANA, Dia.JUEVES);
		AsignacionComisionProfe asig = new AsignacionComisionProfe(idAsignacion, profesor, comision);
		resultadoDeLaEjecucion = uni.ingresarAsignacionDeProfesor(asig);

		// VALIDACION
		assertTrue(resultadoDeLaEjecucion);
	}

	@Test
	public void queSePuedaIngresarAsignacionComisionAlumno() {
		// PREPARACION
		String nombreMat = "PB2", nombreA = "Victoria", apellidoA = "Junco", nombreUni = "UnLam";
		Integer idComision = 2900, codigoMat = 1231, idCiclo = 45, anioCiclo = 2023, mesInicioCiclo = 3,
				diaInicioCiclo = 12, mesFinalCiclo = 7, diaFinalCiclo = 15, dniA = 45325;
		Turnos turno = Turnos.MAÑANA;
		Dia dia = Dia.JUEVES;
		Boolean resultadoDeLaEjecucion;

		// EJECUCION
		Universidad uni = new Universidad(nombreUni);
		Materia materia = new Materia(nombreMat, codigoMat);
		Alumno alumno = new Alumno(nombreA, apellidoA, dniA);
		CicloLectivo ciclo = new CicloLectivo(idCiclo, anioCiclo, mesInicioCiclo, diaInicioCiclo, mesFinalCiclo,
				diaFinalCiclo);
		Comision comision = new Comision(idComision, materia, ciclo, turno, dia);
		AsignacionComisionAlumno asig = new AsignacionComisionAlumno(15, alumno, comision);
		resultadoDeLaEjecucion = uni.ingresarAsignacionDeAlumno(asig);

		// VALIDACION
		assertTrue(resultadoDeLaEjecucion);
	}

	@Test
	public void queSePuedaBuscarUnaMateriaPorId() {
		// PREPARACION
		String nombreUni = "UnLam", nombreMateria = "PB2";
		Integer idMateria = 1231;
		Materia resultadoDeLaEjecucion;

		// EJECUCION
		Materia materia = new Materia(nombreMateria, idMateria);
		Universidad uni = new Universidad(nombreUni);
		uni.ingresarMateria(materia);
		resultadoDeLaEjecucion = uni.buscarMateriaPorId(idMateria);

		// VALIDACION
		assertEquals(materia, resultadoDeLaEjecucion);
	}

	@Test
	public void queSePuedaBuscarUnaComisionDeUniversidad() {
		// PREPARACION
		String nombreMat = "PB2", nombreUni = "UnLam";
		Integer idComision = 2900, codigoMat = 1231, idCiclo = 45, anioCiclo = 2023, mesInicioCiclo = 3,
				diaInicioCiclo = 12, mesFinalCiclo = 7, diaFinalCiclo = 15;
		Turnos turno = Turnos.MAÑANA;
		Dia dia = Dia.JUEVES;
		Comision resultadoDeLaEjecucion;

		// EJECUCION
		Universidad uni = new Universidad(nombreUni);
		Materia materia = new Materia(nombreMat, codigoMat);
		CicloLectivo ciclo = new CicloLectivo(idCiclo, anioCiclo, mesInicioCiclo, diaInicioCiclo, mesFinalCiclo,
				diaFinalCiclo);
		Comision comision = new Comision(idComision, materia, ciclo, turno, dia);
		uni.ingresarComision(comision);
		resultadoDeLaEjecucion = uni.buscarComisionPorID(idComision);

		// VALIDACION
		assertEquals(comision, resultadoDeLaEjecucion);
	}

	@Test
	public void queSePuedaBuscarUnProfesorDeLaUniversidad() {
		// PREPARACION
		String nombreProf = "Andres", apellidoProf = "Borgeat", nombreUni = "UnLam";
		Integer legajoProf = 456;
		Profe resultadoDeLaEjecucion;

		// EJECUCION
		Universidad uni = new Universidad(nombreUni);
		Profe profesor = new Profe(nombreProf, apellidoProf, legajoProf);
		uni.ingresarProfesor(profesor);
		resultadoDeLaEjecucion = uni.buscarProfePorDNI(legajoProf);

		// VALIDACION
		assertEquals(profesor, resultadoDeLaEjecucion);
	}

	@Test
	public void queSePuedaAsignarProfesoresAComision() {
		// PREPARACION
		String nombreP = "Andres", apellidoP = "Bogota", nombreM = "PB2", nombreUni = "UnLam";
		Integer idAsignacion = 15, capacidadMaximaAula = 100, idAula = 45, dniP = 4564, idM = 65, idCom = 85;
		Boolean resultadodeLaEjecucion;

		// EJECUCION
		Universidad uni = new Universidad(nombreUni);
		Profe profesor = new Profe(nombreP, apellidoP, dniP);
		Materia materia = new Materia(nombreM, idM);
		CicloLectivo ciclo = new CicloLectivo(89, 2023, 5, 12, 12, 5);
		Comision comision = new Comision(idCom, materia, ciclo, Turnos.MAÑANA, Dia.JUEVES);
		uni.ingresarProfesor(profesor);
		uni.ingresarComision(comision);
		Aula aula = new Aula(capacidadMaximaAula, idAula);
		aula.asignarCapacidad(50);
		comision.ingresarAula(aula);
		AsignacionComisionProfe asig = new AsignacionComisionProfe(idAsignacion, uni.buscarProfePorDNI(dniP),
				uni.buscarComisionPorID(idCom));
		resultadodeLaEjecucion = asig.asignarProfesoresAComision(idCom, dniP);

		// VALIDACION
		assertTrue(resultadodeLaEjecucion);
	}

	@Test
	public void queSePuedaInscribirUnAlumnoAComisionQueNoTengaMateriasAprobadasNiComisiones() {
		// PREPARACION
		String nombreMat = "PB2", nombreA = "Victoria", apellidoA = "Junco", nombreUni = "UnLam";
		Integer idComision = 2900, codigoMat = 1231, idCiclo = 45, anioCiclo = 2023, mesInicioCiclo = 3,
				diaInicioCiclo = 12, mesFinalCiclo = 12, diaFinalCiclo = 15, dniA = 45;
		Turnos turno = Turnos.MAÑANA;
		Dia dia = Dia.JUEVES;
		Boolean resultadoDeLaEjecucion;

		// EJECUCION
		Universidad uni = new Universidad(nombreUni);
		Alumno alumno = new Alumno(nombreA, apellidoA, dniA);
		Materia materia = new Materia(nombreMat, codigoMat);
		CicloLectivo ciclo = new CicloLectivo(idCiclo, anioCiclo, mesInicioCiclo, diaInicioCiclo, mesFinalCiclo,
				diaFinalCiclo);
		ciclo.ingresarFechaDeInscripcion(anioCiclo, 5, 20);
		ciclo.ingresarFechaDeFinalizacionDeLaInscripcion(anioCiclo, 12, 22);
		Comision comision = new Comision(idComision, materia, ciclo, turno, dia);
		uni.ingresarAlumno(alumno);
		uni.ingresarComision(comision);
		AsignacionComisionAlumno asig = new AsignacionComisionAlumno(15, uni.buscarAlumnoPorDni(dniA),
				uni.buscarComisionPorID(idComision));
		Aula aula = new Aula(100, 15);
		aula.asignarCapacidad(50);
		comision.ingresarAula(aula);
		resultadoDeLaEjecucion = asig.inscribirAlumnoAComision(dniA, idComision);

		// VALIDACION
		assertTrue(resultadoDeLaEjecucion);
	}

}
