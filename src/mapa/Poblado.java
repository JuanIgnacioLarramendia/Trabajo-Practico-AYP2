package mapa;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ejercito.Ejercito;

public class Poblado {

	private HashMap<String, Camino> caminos = new HashMap<String, Camino>();
	private String nombre;
	private Bando bando;
	private Ejercito ejercito;

	public Poblado(String nombre, Ejercito ejercito, Bando bando) {
		this.nombre = nombre;
		this.ejercito = ejercito;
		this.bando = bando;
	}

	public void agregarCamino(Camino Camino) {
		caminos.put(Camino.obtenerPobladoDestino().nombre, Camino);
	}

	public Map<String, Camino> obtenerListaDeCaminos() {
		return Collections.unmodifiableMap(caminos);
	}

	public String obtenerNombre() {
		return nombre;
	}

	public Bando obtenerBando() {
		return this.bando;
	}

	public int obtenerCantidadHabitantes() {
		return ejercito.cantidadUnidades();
	}

	public Ejercito obtenerEjercito() {
		return ejercito;
	}

	@Override
	public String toString() {
		String buffer = "";
		for (Map.Entry<String, Camino> Camino : caminos.entrySet()) {
			buffer += "[" + Camino.getValue().obtenerPobladoDestino().nombre + ", " + Camino.getValue().obtenerDias()
					+ "] ";
		}
		return buffer;
	}

}
