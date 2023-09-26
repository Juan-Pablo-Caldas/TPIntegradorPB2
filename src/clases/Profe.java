package clases;

import java.util.ArrayList;

public class Profe {
	private String nombre;
	private String apellido;
	private Integer dni;
	private ArrayList<Comision> listaDeComisionesDelProfesor;

	public Profe(String nombre, String apellido, Integer dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		listaDeComisionesDelProfesor = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Integer getDni() {
		return dni;
	}

	public ArrayList<Comision> getListaComisionesDelProfesor() {
		return listaDeComisionesDelProfesor;
	}

	public Boolean agregarComisionesAlProfesor(Comision comision) {

		return this.listaDeComisionesDelProfesor.add(comision);
	}
}
