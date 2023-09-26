package clases;
public class AsignacionComisionProfe {
	private Integer id;
	private Profe profesor;
	private Comision comision;

	public AsignacionComisionProfe(Integer id, Profe profesor, Comision comision) {
		this.id = id;
		this.profesor = profesor;
		this.comision = comision;
	}

	public Integer getId() {
		return id;
	}

	public Profe getProfesor() {
		return profesor;
	}

	public Comision getComision() {
		return comision;
	}

	public Boolean asignarProfesoresAComision(Integer idComision, Integer dniProfesor) {
		Boolean asignado = false;
		Profe profesorDeAlta = null;
		Comision comisionDeAlta = null;
		if (this.profesor != null && this.comision != null) {
			if (this.profesor.getDni().equals(dniProfesor) && this.comision.getId().equals(idComision)) {
				profesorDeAlta = this.profesor;
				comisionDeAlta = this.comision;
				Integer capacidadAula = comisionDeAlta.getAula().getCapacidad();
				// El mismo docente no puede ser profesor de la misma comisión 2 veces. !!!!!!
				if (comisionDeAlta.getProfesores().size() == 0) {
					if (20 < capacidadAula) {
						profesorDeAlta.agregarComisionesAlProfesor(comisionDeAlta);
						asignado = comisionDeAlta.getProfesores().add(profesorDeAlta);
					}
				} else if (comisionDeAlta.getProfesores().size() >= 1) {
					for (int i = 0; i < comisionDeAlta.getProfesores().size(); i++) {
						if (comisionDeAlta.getProfesores().get(i).getDni() != dniProfesor) {
							if (40 < capacidadAula && comisionDeAlta.getProfesores().size() == 1) {
								profesorDeAlta.agregarComisionesAlProfesor(comisionDeAlta);
								asignado = comisionDeAlta.getProfesores().add(profesorDeAlta);
							} else if (60 < capacidadAula && comisionDeAlta.getProfesores().size() == 2) {
								profesorDeAlta.agregarComisionesAlProfesor(comisionDeAlta);
								asignado = comisionDeAlta.getProfesores().add(profesorDeAlta);
							} else if (80 < capacidadAula && comisionDeAlta.getProfesores().size() == 3) {
								profesorDeAlta.agregarComisionesAlProfesor(comisionDeAlta);
								asignado = comisionDeAlta.getProfesores().add(profesorDeAlta);
							} else if (100 <= capacidadAula && comisionDeAlta.getProfesores().size() == 4) {
								profesorDeAlta.agregarComisionesAlProfesor(comisionDeAlta);
								asignado = comisionDeAlta.getProfesores().add(profesorDeAlta);
							}
						}
					}
				}
			}
		}
		return asignado;
	}
}
