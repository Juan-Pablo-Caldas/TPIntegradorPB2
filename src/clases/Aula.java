package clases;
public class Aula {
	private Integer capacidad;
	private final Integer CAPACIDAD_MAXIMA;
	private Integer id;

	public Aula(Integer capacidadMaxima, Integer id) {
		this.CAPACIDAD_MAXIMA = capacidadMaxima;
		this.capacidad = 0;
		this.id = id;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public Integer getCAPACIDAD_MAXIMA() {
		return CAPACIDAD_MAXIMA;
	}

	public void asignarCapacidad(Integer capacidad) {
		if (capacidad <= CAPACIDAD_MAXIMA && capacidad >= 40) {
			this.capacidad = capacidad;
		}

	}

	public Integer getId() {
		return id;
	}

}
