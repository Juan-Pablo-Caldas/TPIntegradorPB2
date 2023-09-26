package clases;

import java.util.ArrayList;

public class Materia {
	private Integer id;
	private String nombre;
	private ArrayList<Materia> correlativas;

	public Materia(String nombre, Integer id) {
		this.id = id;
		this.nombre = nombre;
		correlativas = new ArrayList<>();

	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Boolean agregarMateriasCorrelativas(Materia materiaCorrelativa) {
		Boolean resultado = false;
		if (correlativas.size() >= 1) {
			for (int i = 0; i < correlativas.size(); i++) {
				if (correlativas.get(i).getId() != materiaCorrelativa.getId()) {
					resultado = correlativas.add(materiaCorrelativa);
				}

			}
		} else if (correlativas.size() == 0) {
			resultado = correlativas.add(materiaCorrelativa);
		}
		return resultado;

	}

	public Boolean asignarCorrelativa(Integer id, Integer id2) {
		Boolean resultado = false;
		for (int i = 0; i < correlativas.size(); i++) {
			if (this.id.equals(id) && correlativas.get(i).getId() == id2) {
				resultado = true;
			}
		}

		return resultado;

	}


	public ArrayList<Materia> getCorrelativas() {
		return correlativas;
	}

}
