package mapa;

public class Camino {

	private Poblado PobladoDestino;
	private int dias;

	public Camino(Poblado destino, int dias) {
		this.PobladoDestino = destino;
		this.dias = dias;
	}

	public Poblado obtenerPobladoDestino() {
		return PobladoDestino;
	}

	public int obtenerDias() {
		return dias;
	}
}
