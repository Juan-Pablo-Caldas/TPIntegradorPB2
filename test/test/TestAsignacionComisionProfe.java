package test;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.AsignacionComisionProfe;
import clases.Aula;
import clases.CicloLectivo;
import clases.Comision;
import clases.Dia;
import clases.Materia;
import clases.Profe;
import clases.Turnos;

public class TestAsignacionComisionProfe {

	@Test
	public void queSePuedaCrearAsignacionCursoProfesor() {
		// PREPARACION
		String nombreP = "Andres", apellidoP = "Bogota", nombreM = "PB2";
		Integer idAsignacion = 15, dniP = 4564, idM = 65;

		// EJECUCION
		Profe profesor = new Profe(nombreP, apellidoP, dniP);
		Materia materia = new Materia(nombreM, idM);
		CicloLectivo ciclo = new CicloLectivo(89, 2023, 5, 12, 12, 5);
		Comision comision = new Comision(85, materia, ciclo, Turnos.MAÑANA, Dia.JUEVES);
		AsignacionComisionProfe asig = new AsignacionComisionProfe(idAsignacion, profesor, comision);

		// VALIDACION
		assertNotNull(asig);
	}

	@Test
	public void queSePuedaAsignarProfesoresAComision() {
		// PREPARACION
		String nombreP = "Andres", apellidoP = "Bogota", nombreM = "PB2";
		Integer idAsignacion = 15, capacidadMaximaAula = 100, idAula = 45, dniP = 4564, idM = 65, idCom = 85;
		Boolean resultadodeLaEjecucion;

		// EJECUCION
		Profe profesor = new Profe(nombreP, apellidoP, dniP);
		Materia materia = new Materia(nombreM, idM);
		CicloLectivo ciclo = new CicloLectivo(89, 2023, 5, 12, 12, 5);
		Comision comision = new Comision(idCom, materia, ciclo, Turnos.MAÑANA, Dia.JUEVES);
		Aula aula = new Aula(capacidadMaximaAula, idAula);
		aula.asignarCapacidad(50);
		comision.ingresarAula(aula);
		AsignacionComisionProfe asig = new AsignacionComisionProfe(idAsignacion, profesor, comision);
		resultadodeLaEjecucion = asig.asignarProfesoresAComision(idCom, dniP);

		// VALIDACION
		assertTrue(resultadodeLaEjecucion);
	}

	@Test
	public void queNoSePuedaAsignarProfesoresAComisionYaAsignada() {
		// PREPARACION
		String nombreP = "Andres", apellidoP = "Bogota", nombreM = "PB2";
		Integer idAsignacion = 15, capacidadMaximaAula = 100, idAula = 45, dniP = 4564, idM = 65, idCom = 85;
		Boolean resultadodeLaEjecucion;

		// EJECUCION
		Profe profesor = new Profe(nombreP, apellidoP, dniP);
		Materia materia = new Materia(nombreM, idM);
		CicloLectivo ciclo = new CicloLectivo(89, 2023, 5, 12, 12, 5);
		Comision comision = new Comision(idCom, materia, ciclo, Turnos.MAÑANA, Dia.JUEVES);
		Aula aula = new Aula(capacidadMaximaAula, idAula);
		aula.asignarCapacidad(50);
		comision.ingresarAula(aula);
		AsignacionComisionProfe asig = new AsignacionComisionProfe(idAsignacion, profesor, comision);
		AsignacionComisionProfe asig2 = new AsignacionComisionProfe(66, profesor, comision);
		asig2.asignarProfesoresAComision(idCom, dniP);
		resultadodeLaEjecucion = asig.asignarProfesoresAComision(idCom, dniP);

		// VALIDACION
		assertFalse(resultadodeLaEjecucion);
	}

}
