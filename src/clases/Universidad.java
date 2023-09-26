package clases;

import java.util.ArrayList;
import java.util.Date;

public class Universidad {
	private String nombre;
	private ArrayList<Comision> comision;
	private ArrayList<Aula> aulas;
	private ArrayList<Profe> profesores;
	private ArrayList<Alumno> alumnos;
	private ArrayList<CicloLectivo> ciclosLectivos;
	private ArrayList<Materia> materias;
	private ArrayList<AsignacionComisionAlumno> asignacionesAlumnos;
	private ArrayList<AsignacionComisionProfe> asignacionesProfesores;

	public Universidad(String nombre) {
		this.nombre = nombre;
		this.comision = new ArrayList<>();
		this.aulas = new ArrayList<>();
		this.profesores = new ArrayList<>();
		this.alumnos = new ArrayList<>();
		this.ciclosLectivos = new ArrayList<>();
		this.materias = new ArrayList<>();
		this.asignacionesProfesores = new ArrayList<>();
		this.asignacionesAlumnos = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public Boolean ingresarMateria(Materia materia) {
		Boolean ingresoMateria = false;
		if (materias.size() >= 1) {
			for (int i = 0; i < materias.size(); i++) {
				if (materia.getId() != materias.get(i).getId()) {
					ingresoMateria = materias.add(materia);
				}

			}
		} else if (materias.size() <= 0) {
			ingresoMateria = materias.add(materia);
		}

		return ingresoMateria;
	}

	public Boolean ingresarAula(Aula aula) {

		return this.aulas.add(aula);
	}

	public Boolean ingresarCicloLectivo(CicloLectivo ciclo) {
		Boolean ingresoCicloLectivo = false;
		if (ciclosLectivos.size() >= 1) {
			for (int i = 0; i < ciclosLectivos.size(); i++) {
				if (ciclosLectivos.get(i).getId() != ciclo.getId()
						&& ciclosLectivos.get(i).getFechaInicioCiclo() != ciclo.getFechaInicioCiclo()
						&& ciclosLectivos.get(i).getFechaFinalizacionCiclo() != ciclo.getFechaFinalizacionCiclo()) {
					ingresoCicloLectivo = ciclosLectivos.add(ciclo);
				}

			}
		} else if (ciclosLectivos.size() == 0) {
			ingresoCicloLectivo = ciclosLectivos.add(ciclo);
		}

		return ingresoCicloLectivo;
	}

	public Boolean ingresarAlumno(Alumno alumno) {
		Boolean ingresoAlumno = false;
		if (alumnos.size() >= 1) {
			for (int i = 0; i < alumnos.size(); i++) {
				if (alumnos.get(i).getDni() != alumno.getDni()) {
					ingresoAlumno = alumnos.add(alumno);
				}

			}
		} else if (alumnos.size() == 0) {
			ingresoAlumno = alumnos.add(alumno);
		}
		return ingresoAlumno;
	}

	public Boolean ingresarProfesor(Profe profesor) {

		Boolean ingresoProfe = false;
		if (profesores.size() >= 1) {
			for (int i = 0; i < profesores.size(); i++) {
				if (profesores.get(i).getDni() != profesor.getDni()) {
					ingresoProfe = profesores.add(profesor);
				}

			}
		} else if (profesores.size() == 0) {
			ingresoProfe = profesores.add(profesor);
		}
		return ingresoProfe;
	}

	public Boolean ingresarComision(Comision comision) {
		Boolean ingresoComision = false;
		if (this.comision.size() >= 1) {
			for (int i = 0; i < this.comision.size(); i++) {
				if (this.comision.get(i).getMateria() != comision.getMateria()
						&& this.comision.get(i).getCiclo() != comision.getCiclo()
						&& this.comision.get(i).getTurnos() != comision.getTurnos()) {
					ingresoComision = this.comision.add(comision);
				}

			}
		} else if (this.comision.size() == 0) {
			ingresoComision = this.comision.add(comision);
		}
		return ingresoComision;
	}

	public Boolean ingresarAsignacionDeProfesor(AsignacionComisionProfe asig) {
		return this.asignacionesProfesores.add(asig);
	}

	public Boolean ingresarAsignacionDeAlumno(AsignacionComisionAlumno asig) {
		return this.asignacionesAlumnos.add(asig);
	}

	public Integer getCantidadDeMaterias() {
		return materias.size();
	}

	public Integer getCantidadDeAlumnos() {
		return alumnos.size();
	}

	public Integer getCantidadDeProfesores() {
		return profesores.size();
	}

	public Integer getCantidadDeCiclosLectivos() {
		return ciclosLectivos.size();
	}

	public Integer getCantidadDeComisiones() {
		return comision.size();
	}

	public Boolean asignarAulaAlaComision(Integer idComision, Integer dniDocente, Aula aula) {
		Comision comision = buscarComisionPorID(idComision);
		Boolean ingresoAula = false;
		if (comision != null && buscarProfePorDNI(dniDocente) != null) {
			comision.ingresarAula(aula);
			ingresoAula = true;

		}
		return ingresoAula;
	}

	public Comision buscarComisionPorID(Integer idComision) {
		Comision comisionBuscada = null;
		for (int i = 0; i < comision.size(); i++) {
			if (comision.get(i).getId() == idComision) {
				comisionBuscada = comision.get(i);
			}
		}
		return comisionBuscada;
	}

	public Profe buscarProfePorDNI(Integer dniDocente) {
		Profe profesorBuscado = null;
		for (int i = 0; i < profesores.size(); i++) {
			if (profesores.get(i).getDni() == dniDocente) {
				profesorBuscado = profesores.get(i);
			}
		}
		return profesorBuscado;
	}

	public Alumno buscarAlumnoPorDni(Integer dni) {
		Alumno buscado = null;
		for (int i = 0; i < this.alumnos.size(); i++) {
			if (this.alumnos.get(i).getDni().equals(dni)) {
				buscado = this.alumnos.get(i);
			}
		}
		return buscado;
	}

	public Boolean eliminarCorrelativa(Integer idMateria, Integer idCorrelativaAEliminar) {
		Boolean eliminado = false;
		Materia buscada = buscarMateriaPorId(idMateria);
		if (buscada != null) {
			for (int j = 0; j < this.materias.size(); j++) {
				for (int i = 0; i < this.materias.get(j).getCorrelativas().size(); i++) {
					if (buscada.getId().equals(idMateria)
							&& buscada.getCorrelativas().get(i).getId().equals(idCorrelativaAEliminar)) {
						eliminado = buscada.getCorrelativas().remove(buscada.getCorrelativas().get(i));
					}
				}
			}
		}
		return eliminado;
	}

	public Materia buscarMateriaPorId(Integer idMateriaBuscada) {
		Materia buscada = null;
		if (this.materias.size() >= 1) {
			for (int i = 0; i < this.materias.size(); i++) {
				if (this.materias.get(i).getId().equals(idMateriaBuscada)) {
					buscada = this.materias.get(i);
				}
			}
		}
		return buscada;
	}

	public Boolean agregarCorrelatividad(Integer idMateria, Integer idCorrelativa) {
		Boolean asignado = false;
		Materia buscada = buscarMateriaPorId(idMateria);
		if (buscada != null) {
			for (int j = 0; j < this.materias.size(); j++) {
				for (int i = 0; i < this.materias.get(j).getCorrelativas().size(); i++) {
					if (buscada.getId().equals(idMateria)
							&& buscada.getCorrelativas().get(i).getId().equals(idCorrelativa)) {
						asignado = true;
					}
				}
			}
		}
		return asignado;
	}

	public Boolean agregarMateriaCorrelativa(Materia materiaCorrelativa, Integer idMateriaAAgregar) {
		Materia buscada = buscarMateriaPorId(idMateriaAAgregar);
		Boolean resultado = buscada.agregarMateriasCorrelativas(materiaCorrelativa);
		return resultado;
	}


}
