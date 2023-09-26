package clases;

import java.util.ArrayList;

public class Alumno {
	private String nombre;
	private Integer dni;
	private String apellido;
	private ArrayList<Materia> materiasAprobadas;
	private ArrayList<Comision> comisiones;
	private ArrayList<Materia> materiaQueFaltanCursar;

	public Alumno(String nombre, String apellido, Integer dni) {
		this.nombre = nombre;
		this.dni = dni;
		this.apellido = apellido;
		comisiones = new ArrayList<>();
		materiasAprobadas = new ArrayList<>();
		materiaQueFaltanCursar = new ArrayList<>();
	}

	public ArrayList<Materia> getMateriasAprobadas() {
		return materiasAprobadas;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getDni() {
		return dni;
	}

	public String getApellido() {
		return apellido;
	}

	public ArrayList<Materia> obtenerMateriasAprobadasParaUnAlumno() {
		return materiasAprobadas;
	}

	public Boolean asignarMateriasAprobadas(Materia materia) {
		return materiasAprobadas.add(materia);
	}

	public ArrayList<Comision> getComisiones() {
		return comisiones;
	}

	public Boolean asignarComision(Comision queYaTiene) {
		return comisiones.add(queYaTiene);

	}

	public ArrayList<Materia> getMateriaQueFaltanCursar() {
		return materiaQueFaltanCursar;
	}

	public Boolean asignarMateriaFaltanteParaCursar(Materia faltante) {
		return this.materiaQueFaltanCursar.add(faltante);
		
		
	}

}
