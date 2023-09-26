package test;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

import clases.Alumno;
import clases.CicloLectivo;
import clases.Comision;
import clases.Dia;
import clases.Materia;
import clases.Turnos;

public class TestAlumno {

	@Test
    public void queSePuedaAsignarMateriaAprobada() {
        // PREPARACION
        String nombreAlum = "Victoria", apellidoAlum = "Junco", nombreMat = "PB2";
        Integer dniAlum = 111, idMat = 5;
        Boolean resultadoDeLaEjecucion;

        // EJECUCION
        Alumno alumno = new Alumno(nombreAlum, apellidoAlum, dniAlum);
        Materia materia = new Materia(nombreMat, idMat);
        resultadoDeLaEjecucion = alumno.asignarMateriasAprobadas(materia);

        // VALIDACION
        assertTrue(resultadoDeLaEjecucion);
    }
@Test
    public void queSePuedaAsignarComision() {
        // PREPARACION
        String nombreAlum = "Victoria", apellidoAlum = "Junco", nombreMat = "PB2";
        Integer dniAlum = 111, idMat = 5;
        Boolean resultadoDeLaEjecucion;

        // EJECUCION
        Alumno alumno = new Alumno(nombreAlum, apellidoAlum, dniAlum);
        Materia materia = new Materia(nombreMat, idMat);
        CicloLectivo ciclo = new CicloLectivo(45, 2023, 4, 20, 12, 20);
        Comision comision = new Comision(15, materia, ciclo, Turnos.MAÑANA, Dia.JUEVES);
        resultadoDeLaEjecucion = alumno.asignarComision(comision);

        // VALIDACION
        assertTrue(resultadoDeLaEjecucion);
    }

}
