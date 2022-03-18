package unidades;

import armas.Arma;
import ejercito.Tropa;

public class Radaiteran extends Unidad {

	private int cantidadDeAtaques;

	public Radaiteran() {
		super(36, 56, 17, 41, Arma.SHURIKEN);
	}

	public int obtenerCantidadDeAtaques() {
		return cantidadDeAtaques;
	}

	@Override
	public void atacar(Tropa objetivo) {
		int danioResultante = obtenerDanioBase() + (cantidadDeAtaques * 3);

		cantidadDeAtaques++;

		objetivo.recibirAtaque(danioResultante);
	}

	@Override
	public void recibirAtaque(int ataque) {
		this.establecerSalud(obtenerSalud() - ataque);
	}

}
