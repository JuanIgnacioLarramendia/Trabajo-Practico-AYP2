package unidades;

import armas.Arma;
import ejercito.Tropa;

public class Reralope extends Unidad {

	private boolean concentrado;
	private boolean errarAtaque;

	public Reralope() {
		super(53, 27, 5, 46, Arma.CATAPULTA);
	}

	public boolean estaConcentrado() {
		return concentrado;
	}

	private void concentrar() {
		this.establecerDanioBase(27 * 2);
		concentrado = true;
	}

	private void desconcentrar() {
		this.establecerDanioBase(27);
		concentrado = false;
	}

	/**
	 * Alterna el ataque que se erra
	 */
	private void alternarAtaqueErrado() {
		errarAtaque = !errarAtaque;
	}

	@Override
	public void siguienteTurnoPropio() {
		super.siguienteTurnoPropio();

		if (obtenerTurnoPropio() >= 3) {
			establecerDanioBase(27);
		}
	}

	@Override
	public void descansar() {
		concentrar();
		super.descansar();
	}

	@Override
	public void atacar(Tropa objetivo) {
		if (errarAtaque) {
			// Si debe errar el ataque, alternar el flag y no hacer nada
			alternarAtaqueErrado();
			return;
		}

		alternarAtaqueErrado();
		objetivo.recibirAtaque(obtenerDanioBase());
	}

	@Override
	public void recibirAtaque(int ataque) {
		desconcentrar();
		establecerSalud(obtenerSalud() - ataque);
	}

}
