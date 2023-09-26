package test;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.Aula;
import clases.CicloLectivo;
import clases.Comision;
import clases.Dia;
import clases.Materia;
import clases.Profe;
import clases.Turnos;

public class TestProfe {

	@Test
    public void queSePuedaIngresarUnaComision() {
        // PREPARACION
        String nombreMat = "PB2", nombreProf = "Andres", apellidoProf = "Borgeat";
        Integer codigoMat = 1231, numAula = 1, capacidadMaximaAula = 100, legajoProf = 456, idCiclo = 45,
                anioCiclo = 2023, mesInicioCiclo = 3, diaInicioCiclo = 12, mesFinalCiclo = 7, diaFinalCiclo = 15;
        Boolean resultadoDeLaEjecucion;

        // EJECUCION
        Materia materia = new Materia(nombreMat, codigoMat);
        Aula aula = new Aula(numAula, capacidadMaximaAula);
        aula.asignarCapacidad(50);
        CicloLectivo ciclo = new CicloLectivo(idCiclo, anioCiclo, mesInicioCiclo, diaInicioCiclo, mesFinalCiclo,
                diaFinalCiclo);
        Comision comision = new Comision(222, materia, ciclo, Turnos.MAÑANA, Dia.JUEVES);
        Profe profesor = new Profe(nombreProf, apellidoProf, legajoProf);
        resultadoDeLaEjecucion = profesor.agregarComisionesAlProfesor(comision);

        // VALIDACION
        assertTrue(resultadoDeLaEjecucion);
    }

}
