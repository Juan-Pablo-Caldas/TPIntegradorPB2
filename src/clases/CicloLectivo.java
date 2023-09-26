package clases;

import java.time.LocalDate;

public class CicloLectivo {
	private Integer id;
	private LocalDate fechaInicioCiclo;
	private LocalDate fechaFinalizacionCiclo;
	private LocalDate fechaInicioInscripcion;
	private LocalDate fechaFinalizacionInscripcion;


	public CicloLectivo(Integer id, Integer anio, Integer mesInicio, Integer diaInicio, Integer mesFinal,
			Integer diaFinal) {
		this.id = id;
		this.fechaInicioCiclo = LocalDate.of(anio, mesInicio, diaInicio);
		this.fechaFinalizacionCiclo = LocalDate.of(anio, mesFinal, diaFinal);
		this.fechaInicioInscripcion = null;
		this.fechaFinalizacionInscripcion = null;
	}

	public void ingresarFechaDeInscripcion(Integer anio, Integer mes, Integer dia) {
		if (mes >= 1 && mes <= 12 && dia >= 1 && dia <= 31) {
			fechaInicioInscripcion = LocalDate.of(anio, mes, dia);
		}
	}

	public void ingresarFechaDeFinalizacionDeLaInscripcion(Integer anio, Integer mes, Integer dia) {
		if (mes >= 1 && mes <= 12 && dia >= 1 && dia <= 31) {
			fechaFinalizacionInscripcion = LocalDate.of(anio, mes, dia);
		}

	}

	public Integer getId() {
		return id;
	}

	public LocalDate getFechaInicioCiclo() {
		return fechaInicioCiclo;
	}

	public LocalDate getFechaFinalizacionCiclo() {
		return fechaFinalizacionCiclo;
	}

	public LocalDate getFechaInicioInscripcion() {
		return fechaInicioInscripcion;
	}

	public LocalDate getFechaFinalizacionInscripcion() {
		return fechaFinalizacionInscripcion;
	}

}
