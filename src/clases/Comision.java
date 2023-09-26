package clases;

import java.util.ArrayList;

public class Comision {
	private Integer id;
	private Materia materia;
	private CicloLectivo ciclo;
	private ArrayList<Profe> profesores;
	private ArrayList<Alumno> alumnos;
	private Turnos turnos;
	private Dia dia;
	private Aula aula;

	public Comision(Integer id, Materia materia, CicloLectivo ciclo, Turnos turno, Dia dia) {
		this.id = id;
		this.materia = materia;
		this.ciclo = ciclo;
		profesores = new ArrayList<>();
		alumnos = new ArrayList<>();
		this.turnos = turno;
		this.aula = null;
		this.dia = dia;
	}

	public void ingresarAula(Aula aula) {
		this.aula = aula;
	}

	public Integer getId() {
		return id;
	}

	public Materia getMateria() {
		return materia;
	}

	public CicloLectivo getCiclo() {
		return ciclo;
	}

	public ArrayList<Profe> getProfesores() {
		return profesores;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public Turnos getTurnos() {
		return turnos;
	}

	public Aula getAula() {
		return aula;
	}

	public Alumno buscarAlumnoEnComisionPorDni(Integer dniAlumno) {
		Alumno buscado = null;
		for (int i = 0; i < this.alumnos.size(); i++) {
			if (this.alumnos.get(i).getDni().equals(dniAlumno)) {
				buscado = this.alumnos.get(i);
			}
		}
		return buscado;
	}

	public Dia getDia() {
		return dia;
	}

}
