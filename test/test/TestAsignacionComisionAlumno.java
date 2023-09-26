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

	@Test
	public void queSePuedaValidarQueLaComisionTengaDistintoDiaYTurno() {
		// PREPARACION
		String nombreMat = "PB2", nombreA = "Victoria", apellidoA = "Junco";
		Integer idComision = 2900, codigoMat = 1231, idCiclo = 45, anioCiclo = 2023, mesInicioCiclo = 3,
				diaInicioCiclo = 12, mesFinalCiclo = 7, diaFinalCiclo = 15, dniA = 45;
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
		Comision comisionAsignada = new Comision(3900, materia, ciclo, Turnos.NOCHE, Dia.LUNES);

		alumno.asignarComision(comisionAsignada);
		AsignacionComisionAlumno a = new AsignacionComisionAlumno(21321321, alumno, comision);
		resultadoDeLaEjecucion = a.validarQueElTurnoYDiaSeanNoSeanIguales(idComision, dniA);

		// VALIDACION
		assertTrue(resultadoDeLaEjecucion);
	}

	@Test
	public void queNoSePuedaValidarQueLaComisionTengaDistintoDiaYTurno() {
		// PREPARACION
		String nombreMat = "PB2", nombreA = "Victoria", apellidoA = "Junco";
		Integer idComision = 2900, codigoMat = 1231, idCiclo = 45, anioCiclo = 2023, mesInicioCiclo = 3,
				diaInicioCiclo = 12, mesFinalCiclo = 7, diaFinalCiclo = 15, dniA = 45;
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
		Comision comisionAsignada = new Comision(idComision, materia, ciclo, turno, dia);

		alumno.asignarComision(comisionAsignada);
		AsignacionComisionAlumno a = new AsignacionComisionAlumno(123123, alumno, comision);
		resultadoDeLaEjecucion = a.validarQueElTurnoYDiaSeanNoSeanIguales(idComision, dniA);

		// VALIDACION
		assertFalse(resultadoDeLaEjecucion);
	}

	@Test
	public void queSePuedaValidarQueTengaMateriasAprobadas() {
		// PREPARACION
		String nombreMat = "PB2", nombreA = "Victoria", apellidoA = "Junco";
		Integer idComision = 2900, codigoMat = 1231, idCiclo = 45, anioCiclo = 2023, mesInicioCiclo = 3,
				diaInicioCiclo = 12, mesFinalCiclo = 7, diaFinalCiclo = 15, dniA = 45;
		Turnos turno = Turnos.MAÑANA;
		Dia dia = Dia.JUEVES;
		Boolean resultadoDeLaEjecucion;

		// EJECUCION

		Alumno alumno = new Alumno(nombreA, apellidoA, dniA);
		Materia materia = new Materia(nombreMat, codigoMat);

		alumno.asignarMateriasAprobadas(materia);
		CicloLectivo ciclo = new CicloLectivo(idCiclo, anioCiclo, mesInicioCiclo, diaInicioCiclo, mesFinalCiclo,
				diaFinalCiclo);
		ciclo.ingresarFechaDeInscripcion(anioCiclo, 5, 30);
		ciclo.ingresarFechaDeFinalizacionDeLaInscripcion(anioCiclo, 12, 23);
		Comision comision = new Comision(idComision, materia, ciclo, turno, dia);
		AsignacionComisionAlumno a = new AsignacionComisionAlumno(1231231, alumno, comision);
		resultadoDeLaEjecucion = a.validarQueTengaMateriasAprobadas(dniA);

		// VALIDACION
		assertTrue(resultadoDeLaEjecucion);
	}

	@Test
	public void queNoSePuedaValidarQueTengaMateriasAprobadas() {
		// PREPARACION
		String nombreMat = "PB2", nombreA = "Victoria", apellidoA = "Junco";
		Integer idComision = 2900, codigoMat = 1231, idCiclo = 45, anioCiclo = 2023, mesInicioCiclo = 3,
				diaInicioCiclo = 12, mesFinalCiclo = 7, diaFinalCiclo = 15, dniA = 45;
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
		AsignacionComisionAlumno a = new AsignacionComisionAlumno(1231231, alumno, comision);
		resultadoDeLaEjecucion = a.validarQueTengaMateriasAprobadas(dniA);

		// VALIDACION
		assertFalse(resultadoDeLaEjecucion);
	}

	@Test
	public void queSePuedaValidarQueElIdDeLasMateriasAprobadasDelAlumnoSeanDistintasALasDeLaComision() {
		// PREPARACION
		String nombreMat = "PB2", nombreA = "Victoria", apellidoA = "Junco";
		Integer idComision = 2900, codigoMat = 1231, idCiclo = 45, anioCiclo = 2023, mesInicioCiclo = 3,
				diaInicioCiclo = 12, mesFinalCiclo = 7, diaFinalCiclo = 15, dniA = 45;
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
		Aula aula = new Aula(100, 15);
		aula.asignarCapacidad(50);

		comision.ingresarAula(aula);
		alumno.asignarMateriasAprobadas(materiaAprobada);
		AsignacionComisionAlumno a = new AsignacionComisionAlumno(123123, alumno, comision);
		resultadoDeLaEjecucion = a
				.validarQueElIdDeLasMateriasAprobadasDelAlumnoSeanDistintasALasDeLaComision(idComision, dniA);

		// VALIDACION
		assertTrue(resultadoDeLaEjecucion);
	}

	@Test
	public void queSePuedaValidarQueElTurnoYDiaSeanNoSeanIguales() {
		// PREPARACION
		String nombreMat = "PB2", nombreA = "Victoria", apellidoA = "Junco";
		Integer idComision = 2900, codigoMat = 1231, idCiclo = 45, anioCiclo = 2023, mesInicioCiclo = 3,
				diaInicioCiclo = 12, mesFinalCiclo = 7, diaFinalCiclo = 15, dniA = 45;
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
		Comision queYaTiene = new Comision(3900, materia, ciclo, Turnos.NOCHE, Dia.SABADO);
		Aula aula = new Aula(100, 14);
		aula.asignarCapacidad(50);

		comision.ingresarAula(aula);
		alumno.asignarComision(queYaTiene);
		AsignacionComisionAlumno a = new AsignacionComisionAlumno(21313, alumno, comision);
		resultadoDeLaEjecucion = a.validarQueElTurnoYDiaSeanNoSeanIguales(idComision, dniA);

		// VALIDACION
		assertTrue(resultadoDeLaEjecucion);
	}

	@Test
	public void queSePuedaAsignarUnaNotaDePrimerParcial() {
		// PREPARACION
		String nombreMat = "PB2", nombreA = "Victoria", apellidoA = "Junco";
		Integer idComision = 2900, codigoMat = 1231, idCiclo = 45, anioCiclo = 2023, mesInicioCiclo = 3,
				diaInicioCiclo = 12, mesFinalCiclo = 12, diaFinalCiclo = 15, dniA = 45;
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

		Aula aula = new Aula(100, 14);
		aula.asignarCapacidad(50);

		comision.ingresarAula(aula);
		Nota nota = new Nota(TipoNota.PRIMERPARCIAL);

		AsignacionComisionAlumno a = new AsignacionComisionAlumno(21313, alumno, comision);
		a.inscribirAlumnoAComision(dniA, idComision);

		resultadoDeLaEjecucion = a.ingresarNota(idComision, dniA, nota);

		// VALIDACION

		assertTrue(resultadoDeLaEjecucion);

	}

	@Test
	public void queNoSePuedaAsignarUnaNotaDePrimerParcialSiYaExiste() {
		// PREPARACION
		String nombreMat = "PB2", nombreA = "Victoria", apellidoA = "Junco";
		Integer idComision = 2900, codigoMat = 1231, idCiclo = 45, anioCiclo = 2023, mesInicioCiclo = 3,
				diaInicioCiclo = 12, mesFinalCiclo = 7, diaFinalCiclo = 15, dniA = 45, numeroEsperado = 1;
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

		Aula aula = new Aula(100, 14);
		aula.asignarCapacidad(50);

		comision.ingresarAula(aula);

		Nota nota = new Nota(TipoNota.PRIMERPARCIAL);
		Nota nota2 = new Nota(TipoNota.PRIMERPARCIAL);

		AsignacionComisionAlumno a = new AsignacionComisionAlumno(21313, alumno, comision);
		a.inscribirAlumnoAComision(dniA, idComision);

		a.ingresarNota(idComision, dniA, nota);
		resultadoDeLaEjecucion = a.ingresarNota(idComision, dniA, nota2);

		Integer numeroDeNotas = a.getNotas().size();

		// VALIDACION
		assertFalse(resultadoDeLaEjecucion);
		assertEquals(numeroEsperado, numeroDeNotas);
	}
	
	@Test
    public void queSePuedaEvaluarUnParcial() {
        // PREPARACION
        String nombreMat = "PB2", nombreA = "Victoria", apellidoA = "Junco";
        Integer idComision = 2900, codigoMat = 1231, idCiclo = 45, anioCiclo = 2023, mesInicioCiclo = 3,
                diaInicioCiclo = 12, mesFinalCiclo = 12, diaFinalCiclo = 15, dniA = 45;
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

        Aula aula = new Aula(100, 14);
        aula.asignarCapacidad(50);

        comision.ingresarAula(aula);
        Nota nota = new Nota(TipoNota.PRIMERPARCIAL);
        Nota nota2 = new Nota(TipoNota.SEGUNDOPARCIAL);
        Nota nota3 = new Nota(TipoNota.REC1PRIMER);
        Nota nota4 = new Nota(TipoNota.REC2PARCIAL);

        AsignacionComisionAlumno a = new AsignacionComisionAlumno(21313, alumno, comision);
        a.inscribirAlumnoAComision(dniA, idComision);

        a.ingresarNota(idComision, dniA, nota);
        a.ingresarNota(idComision, dniA, nota2);
        a.ingresarNota(idComision, dniA, nota3);
        a.ingresarNota(idComision, dniA, nota4);

        resultadoDeLaEjecucion = a.registrarNota(idComision, dniA, 7.0, TipoNota.PRIMERPARCIAL);
        resultadoDeLaEjecucion = a.registrarNota(idComision, dniA, 5.0, TipoNota.SEGUNDOPARCIAL);

        Double valorEsperadoDeNota1 = 7.0;
        Double valorEsperadoDeNota2 = 5.0;

        Double valorDeLaNota1 = a.getNotas().get(0).getValorDeNota();
        Double valorDeLaNota2 = a.getNotas().get(1).getValorDeNota();
        // VALIDACION
        assertTrue(resultadoDeLaEjecucion);
        assertEquals(valorEsperadoDeNota1, valorDeLaNota1);
        assertEquals(valorEsperadoDeNota2, valorDeLaNota2);

    }

	@Test
    public void queNoSePuedaEvaluarEl2doRecuperatorioSiElPrimeroYaSeEvaluo() {
        // PREPARACION
        String nombreMat = "PB2", nombreA = "Victoria", apellidoA = "Junco";
        Integer idComision = 2900, codigoMat = 1231, idCiclo = 45, anioCiclo = 2023, mesInicioCiclo = 3,
                diaInicioCiclo = 12, mesFinalCiclo = 12, diaFinalCiclo = 15, dniA = 45;
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

        Aula aula = new Aula(100, 14);
        aula.asignarCapacidad(50);

        comision.ingresarAula(aula);

        Nota nota = new Nota(TipoNota.PRIMERPARCIAL);
        Nota nota2 = new Nota(TipoNota.SEGUNDOPARCIAL);
        Nota nota3 = new Nota(TipoNota.REC1PRIMER);
        Nota nota4 = new Nota(TipoNota.REC2PARCIAL);

        AsignacionComisionAlumno a = new AsignacionComisionAlumno(21313, alumno, comision);
        a.inscribirAlumnoAComision(dniA, idComision);

        a.ingresarNota(idComision, dniA, nota);
        a.ingresarNota(idComision, dniA, nota2);
        a.ingresarNota(idComision, dniA, nota3);
        a.ingresarNota(idComision, dniA, nota4);

        a.registrarNota(idComision, dniA, 5.0, TipoNota.PRIMERPARCIAL);

        a.registrarNota(idComision, dniA, 7.0, TipoNota.REC1PRIMER);
        resultadoDeLaEjecucion = a.registrarNota(idComision, dniA, 5.0, TipoNota.REC2PARCIAL);

        Double valorEsperadoDeNota4 = 0.0;

        Double valorDeLaNota3 = a.getNotas().get(2).getValorDeNota();
        Double valorDeLaNota4 = a.getNotas().get(4).getValorDeNota();
        // VALIDACION
        assertFalse(resultadoDeLaEjecucion);
        assertEquals(valorEsperadoDeNota4, valorDeLaNota4);
    }

}
