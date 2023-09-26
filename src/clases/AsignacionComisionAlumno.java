package clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AsignacionComisionAlumno {
	private Integer id;
	private Alumno alumno;
	private Comision comision;
	private ArrayList<Nota> notas;
	private Boolean recuperado;

	public AsignacionComisionAlumno(Integer id, Alumno alumno, Comision comision) {
		this.id = id;
		this.alumno = alumno;
		this.comision = comision;
		notas = new ArrayList<>();
		recuperado = false;
	}

	public Integer getId() {
		return id;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public Comision getComision() {
		return comision;
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}

	public Boolean inscribirAlumnoAComision(Integer dni, Integer idComision) {
		Boolean exitosa = false;
		Alumno alumnoBuscado = null;
		Comision comisionBuscada = null;
		if (alumno.getDni().equals(dni) && alumno != null && comision.getId().equals(idComision) && comision != null) {
			alumnoBuscado = alumno;
			comisionBuscada = comision;

			if (validarFechaDeInscripcion(idComision) == true) {

				if (validarCapacidadDeAula(idComision) == true) {
					if (validarQueTengaMateriasAprobadas(dni) == true) {
						if (validarQueElIdDeLasMateriasAprobadasDelAlumnoSeanDistintasALasDeLaComision(idComision,
								dni) == true) {
							if (validarQueElTurnoYDiaSeanNoSeanIguales(idComision, dni) == false) {
								comision.getAlumnos().add(alumnoBuscado);
								exitosa = alumnoBuscado.getComisiones().add(comisionBuscada);
							} else if (validarQueElTurnoYDiaSeanNoSeanIguales(idComision, dni) == true) {
								comision.getAlumnos().add(alumnoBuscado);
								exitosa = alumnoBuscado.getComisiones().add(comisionBuscada);

							}

						}

					} else if (validarQueTengaMateriasAprobadas(dni) == false) {
						if (validarQueElTurnoYDiaSeanNoSeanIguales(idComision, dni) == false) {
							comision.getAlumnos().add(alumnoBuscado);
							exitosa = alumnoBuscado.getComisiones().add(comisionBuscada);
						} else if (validarQueElTurnoYDiaSeanNoSeanIguales(idComision, dni) == true) {
							comision.getAlumnos().add(alumnoBuscado);
							exitosa = alumnoBuscado.getComisiones().add(comisionBuscada);

						}
					}

				}

			}

		}

		return exitosa;

	}

	public Boolean validarQueElIdDeLasMateriasAprobadasDelAlumnoSeanDistintasALasDeLaComision(Integer idComision,
			Integer dniAlumno) {
		Comision comisionBuscada = null;
		Boolean exitosa = false;
		Alumno alumnoBuscado = null;
		if (comision.getId().equals(idComision) && alumno.getDni().equals(dniAlumno) && comision != null
				&& alumno != null) {
			comisionBuscada = comision;
			alumnoBuscado = alumno;
			if (validarQueTengaMateriasAprobadas(dniAlumno) == true) {
				for (int i = 0; i < alumnoBuscado.getMateriasAprobadas().size(); i++) {
					if (alumnoBuscado.getMateriasAprobadas().get(i).getId() != comisionBuscada.getMateria().getId()) {
						exitosa = true;
					}
				}
			}

		}

		return exitosa;
	}

	public Boolean validarFechaDeInscripcion(Integer idComision) {

		LocalDate fechaActual = LocalDate.now();

		Comision comisionBuscada = null;

		Boolean resultado = false;
		if (comision.getId().equals(idComision) && comision != null) {
			comisionBuscada = comision;
			if (fechaActual.isAfter(comisionBuscada.getCiclo().getFechaInicioInscripcion())
					&& fechaActual.isBefore(comisionBuscada.getCiclo().getFechaFinalizacionInscripcion())) {
				resultado = true;
			}
		}

		return resultado;

	}

	public Boolean validarQueTengaMateriasAprobadas(Integer dniAlumno) {
		Boolean exitosa = false;
		Alumno alumnoBuscado = null;
		if (alumno != null && alumno.getDni().equals(dniAlumno)) {
			alumnoBuscado = alumno;
			if (alumnoBuscado.getMateriasAprobadas().size() >= 1) {
				exitosa = true;
			}
		}

		return exitosa;
	}

	public Boolean validarQueElTurnoYDiaSeanNoSeanIguales(Integer idComision, Integer dniAlumno) {
		Boolean validado = false;
		Alumno alumnoBuscado = null;
		Comision comisionBuscada = null;
		if (comision.getId().equals(idComision) && alumno.getDni().equals(dniAlumno) && comision != null
				&& alumno != null) {
			alumnoBuscado = alumno;
			comisionBuscada = comision;
			if (alumnoBuscado.getComisiones().size() >= 1) {
				for (int j = 0; j < alumnoBuscado.getComisiones().size(); j++) {
					if (alumnoBuscado.getComisiones().get(j).getTurnos() != comisionBuscada.getTurnos()
							|| alumnoBuscado.getComisiones().get(j).getDia() != comisionBuscada.getDia()) {
						validado = true;
					}
				}
			}
		}

		return validado;
	}

	public Boolean validarCapacidadDeAula(Integer idComision) {
		Comision comisionBuscada = null;
		Boolean resultado = false;
		if (comision.getId().equals(idComision) && comision != null) {
			comisionBuscada = comision;
			if (comisionBuscada.getAula().getCapacidad() > comisionBuscada.getAlumnos().size()) {
				resultado = true;
			}
		}

		return resultado;
	}

	public Boolean registrarNota(Integer idComision, Integer idAlumno, Double valorDeNota, TipoNota tipo) {
		Boolean registrado = false;
		Comision comisionBuscada = null;
		Alumno alumno = null;
		Nota notaParaEvaluar = null;
		if (comision.getId().equals(idComision)) {
			comisionBuscada = comision;
			alumno = comisionBuscada.buscarAlumnoEnComisionPorDni(idAlumno);
			notaParaEvaluar = buscarNotaPorTipo(tipo);
			if (alumno != null) {
				if (notaParaEvaluar.getTipoDeNota() == TipoNota.PRIMERPARCIAL) {
					registrado = notaParaEvaluar.asignarValorDeNota(valorDeNota);

				} else if (notaParaEvaluar.getTipoDeNota() == TipoNota.SEGUNDOPARCIAL) {
					registrado = notaParaEvaluar.asignarValorDeNota(valorDeNota);

				} else if (notaParaEvaluar.getTipoDeNota() == TipoNota.REC1PRIMER) {
					for (int j = 0; j < notas.size(); j++) {
						Nota notaAux = null;
						if (notas.get(j).getTipoDeNota() == TipoNota.PRIMERPARCIAL && recuperado == false) {
							notaAux = notas.get(j);
							if (notaAux.getValorDeNota() < 7 && notaAux.getValorDeNota() >= 4) {
								notaParaEvaluar.asignarValorDeNota(valorDeNota);
								registrado = notaAux.asignarValorDeNota(valorDeNota);

								recuperado = true;
							}
						}

					}

				} else if (notaParaEvaluar.getTipoDeNota() == TipoNota.REC2PARCIAL) {
					for (int k = 0; k < notas.size(); k++) {
						Nota notaAux = null;
						if (notas.get(k).getTipoDeNota() == TipoNota.SEGUNDOPARCIAL) {
							notaAux = notas.get(k);
							if (notaAux.getValorDeNota() < 7 && notaAux.getValorDeNota() >= 4) {
								notaParaEvaluar.asignarValorDeNota(valorDeNota);
								registrado = notaAux.asignarValorDeNota(valorDeNota);
								recuperado = true;
							}
						}

					}
				}
			}

		}

		return registrado;
	}

	public Nota buscarNotaPorTipo(TipoNota tipo) {
		Nota notaBuscada = null;
		for (int i = 0; i < notas.size(); i++) {
			if (notas.get(i).getTipoDeNota() == tipo) {
				notaBuscada = notas.get(i);
			}
		}
		return notaBuscada;
	}

	public Boolean ingresarNota(Integer idComision, Integer dniAlumno, Nota nota) {
		Boolean ingresado = false;
		Comision comisionBuscada = null;
		Alumno alumnoBuscado = null;
		if (comision.getId().equals(idComision) && comision != null) {
			comisionBuscada = comision;
			alumnoBuscado = comisionBuscada.buscarAlumnoEnComisionPorDni(dniAlumno);
			if (alumnoBuscado != null) {
				if (notas.size() >= 1) {
					for (int i = 0; i < notas.size(); i++) {
						if (nota.getTipoDeNota() == TipoNota.PRIMERPARCIAL
								&& notas.get(i).getTipoDeNota() != TipoNota.PRIMERPARCIAL) {
							ingresado = notas.add(nota);

						} else if (nota.getTipoDeNota() == TipoNota.SEGUNDOPARCIAL
								&& notas.get(i).getTipoDeNota() != TipoNota.SEGUNDOPARCIAL) {
							ingresado = notas.add(nota);

						} else if (nota.getTipoDeNota() == TipoNota.REC1PRIMER
								&& notas.get(i).getTipoDeNota() != TipoNota.REC1PRIMER) {
							ingresado = notas.add(nota);

						} else if (nota.getTipoDeNota() == TipoNota.REC2PARCIAL
								&& notas.get(i).getTipoDeNota() != TipoNota.REC2PARCIAL) {
							ingresado = notas.add(nota);

						} else if (nota.getTipoDeNota() == TipoNota.FINAL
								&& notas.get(i).getTipoDeNota() != TipoNota.FINAL) {
							ingresado = notas.add(nota);

						}
					}
				} else if (notas.size() == 0) {

					if (nota.getTipoDeNota() == TipoNota.PRIMERPARCIAL) {
						ingresado = notas.add(nota);

					} else if (nota.getTipoDeNota() == TipoNota.SEGUNDOPARCIAL) {
						ingresado = notas.add(nota);
					} else if (nota.getTipoDeNota() == TipoNota.REC1PRIMER) {
						ingresado = notas.add(nota);
					} else if (nota.getTipoDeNota() == TipoNota.REC2PARCIAL) {
						ingresado = notas.add(nota);
					} else if (nota.getTipoDeNota() == TipoNota.FINAL) {
						ingresado = notas.add(nota);

					}

				}

			}
		}
		return ingresado;
	}

	public ArrayList<Materia> obtenerMateriasAprobadasParaUnAlumno(Integer dniAlumno) {
		// Debe devolver un arreglo de materias
		ArrayList<Materia> aprobadas = null;
		if (this.alumno.getDni().equals(dniAlumno) == true) {
			aprobadas = this.alumno.getMateriasAprobadas();
		}
		return aprobadas;
	}

	public Double obtenerNota(Integer dniAlumno, Integer idMateria, TipoNota nota) {
		Double valorNotaBuscada = 0.0;
		if (this.alumno != null && this.comision != null) {
			if (this.alumno.getDni().equals(dniAlumno) && this.comision.getMateria().getId().equals(idMateria)) {
				Nota notaBuscada = buscarNotaPorTipo(nota);
				if (notaBuscada != null) {
					valorNotaBuscada = notaBuscada.getValorDeNota();
				}
			}
		}
		return valorNotaBuscada;
	}

	public Double calcularPromedio(Integer dniAlumno) {
		Double nota1P = 0.0;
		Double nota2P = 0.0;
		Integer cantidad = 2;
		Nota nota = null;
		if (this.alumno != null) {
			if (this.alumno.getDni().equals(dniAlumno) == true) {
				for (int i = 0; i < this.alumno.getComisiones().size(); i++) {
					if (this.alumno.getComisiones().get(i).equals(this.comision)) {
						for (int j = 0; j < this.notas.size(); j++) {
							if (this.notas.get(j).getTipoDeNota().equals(TipoNota.PRIMERPARCIAL)) {
								nota1P = this.notas.get(j).getValorDeNota();
							} else if (this.notas.get(j).getTipoDeNota().equals(TipoNota.SEGUNDOPARCIAL)) {
								nota2P = this.notas.get(j).getValorDeNota();
							}
						}
					}
				}
			}
		}
		Double promedio = (nota1P + nota2P) / cantidad;
		for (int i = 0; i < this.notas.size(); i++) {
			if (this.notas.get(i).getTipoDeNota() == TipoNota.FINAL) {
				nota = this.notas.get(i);
				nota.asignarValorDeNota(promedio);
				if (promedio >= 7 && promedio <= 10) {
					alumno.asignarMateriasAprobadas(comision.getMateria());
				}
			}
		}

		return promedio;
	}

	public ArrayList<Materia> obtenerMateriasQueFaltanCursarParaUnAlumno(Integer dniAlumno) {
		// Debe devolver un arreglo de materias
		ArrayList<Materia> faltantes = null;
		if (this.alumno.getDni().equals(dniAlumno) == true) {
			faltantes = this.alumno.getMateriaQueFaltanCursar();
		}
		return faltantes;
	}

}
