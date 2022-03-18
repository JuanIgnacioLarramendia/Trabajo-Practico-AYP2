package unidades;

import armas.Arma;
import ejercito.Tropa;

public abstract class Unidad implements Tropa {

	private int salud;
	private int saludMaxima;
	private int danioBase;
	private int rangoMin;
	private int rangoMax;
	private Arma arma;
	private boolean estaDescansando;
	private int turnoPropio;
	private int turnoContiguo;

	public Unidad(int saludMaxima, int danioBase, int rangoMin, int rangoMax, Arma arma) {
		this.saludMaxima = saludMaxima;
		this.salud = saludMaxima;
		this.danioBase = danioBase;
		this.rangoMin = rangoMin;
		this.rangoMax = rangoMax;
		this.arma = arma;
	}

	@Override
	public abstract void atacar(Tropa objetivo);

	@Override
	public abstract void recibirAtaque(int ataque);

	public int obtenerSalud() {
		return salud;
	}

	public int obtenerSaludMaxima() {
		return saludMaxima;
	}

	public int obtenerDanioBase() {
		return danioBase;
	}

	public int obtenerRangoMin() {
		return rangoMin;
	}

	public int obtenerRangoMax() {
		return rangoMax;
	}

	public Arma obtenerArma() {
		return arma;
	}

	public boolean estaDescansando() {
		return estaDescansando;
	}

	public int obtenerTurnoPropio() {
		return turnoPropio;
	}

	public int obtenerTurnoContiguo() {
		return turnoContiguo;
	}

	public void establecerSalud(int salud) {
		this.salud = salud;
	}

	public void establecerDanioBase(int danio) {
		this.danioBase = danio;
	}

	@Override
	public boolean estaDesmayado() {
		return salud <= 0;
	}

	/**
	 * Un turno propio se considera el turno en el que la unidad ataca
	 */
	public void siguienteTurnoPropio() {
		turnoPropio++;
	}

	/**
	 * Un turno contiguo se considera el turno en que cualquier unidad ataca
	 */
	public void siguienteTurnoContiguo() {
		turnoContiguo++;
	}

	public void resetearTurnoPropio() {
		turnoPropio = 0;
	}

	public void resetearTurnoContiguo() {
		turnoContiguo = 0;
	}

	public void descansar() {
		this.estaDescansando = true;
	}

}
