package mapa;

public class Distancia implements Comparable<Distancia> {
	private String poblado;
	private Integer distancia;

	public Distancia(String poblado, int distancia) {
		this.poblado = poblado;
		this.distancia = distancia;
	}

	public int obtenerDistancia() {
		return distancia;
	}

	public String obtenerNombrePoblado() {
		return poblado;
	}

	@Override
	public int compareTo(Distancia otraDistancia) {
		return this.distancia.compareTo(otraDistancia.distancia);

	}

}
