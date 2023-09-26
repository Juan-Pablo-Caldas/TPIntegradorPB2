package clases;
public class Nota {
	TipoNota tipoDeNota;
	private Double valorDeNota;

	public Nota(TipoNota tipoDeNota) {
		this.tipoDeNota = tipoDeNota;
		valorDeNota = 0.0;

	}

	public Boolean asignarValorDeNota(Double valorDeLaNota) {
		Boolean asignarNota = false;
		if (valorDeLaNota >= 1 && valorDeLaNota <= 10) {
			valorDeNota = valorDeLaNota;
			asignarNota = true;
		}
		return asignarNota;
	}

	public TipoNota getTipoDeNota() {
		return tipoDeNota;
	}

	public Double getValorDeNota() {
		return valorDeNota;
	}

}
