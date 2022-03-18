package mapa;

import java.util.HashMap;
import ejercito.Ejercito;

public class Mapa {

	private static Mapa mapa;
	private String nombrePobladoInicial;
	private String nombrePobladoFinal;
	private HashMap<String, Poblado> poblados = new HashMap<String, Poblado>();
	private Poblado pobladoInicial;

	// Constructor privado (ya que es un Singleton).
	private Mapa() {}

	public static Mapa obtenerMapa() {
		if (mapa == null)
			mapa = new Mapa();
		return mapa;
	}

	public HashMap<String, Poblado> obtenerPoblados() {
		return poblados;
	}

	/**
	 * Agrega un camino al mapa pasandole el poblado inicial, el destino, y la
	 * cantidad de dias que tarda en recorrerse el camino entre esos dos poblados.
	 */
	public void agregarCamino(String inicio, String destino, int dias) {
		poblados.get(inicio).agregarCamino(new Camino(poblados.get(destino), dias));
	}

	public void agregarPoblado(String nombre, Ejercito ejercito, Bando bando) {
		poblados.put(nombre, new Poblado(nombre, ejercito, bando));
	}

	// Setters y Getters

	public String obtenerNombrePobladoInicial() {
		return nombrePobladoInicial;
	}

	public void establecerPobladoInicial(String nombrePobladoInicial) {
		this.nombrePobladoInicial = nombrePobladoInicial;
		pobladoInicial = poblados.get(nombrePobladoInicial);
	}

	public String obtenerNombrePobladoFinal() {
		return nombrePobladoFinal;
	}

	public Poblado obtenerPobladoInicial() {
		return pobladoInicial;
	}

	public void establecerNombrePobladoFinal(String pobladoFinal) {
		nombrePobladoFinal = pobladoFinal;
	}

}
