package unidades;

import armas.Arma;
import ejercito.Tropa;

public class Nortaichian extends Unidad {

	private boolean enfurecido;
	private boolean petrificado;

	public Nortaichian() {
		super(66, 18, 16, 22, Arma.ARCO);
	}

	public boolean estaPetrificado() {
		return petrificado;
	}

	public boolean estaEnfurecido() {
		return enfurecido;
	}

	private void petrificar() {
		petrificado = true;
	}

	private void despetrificar() {
		if (obtenerTurnoContiguo() >= 1) {
			petrificado = false;
		}
	}

	private void enfurecer() {
		enfurecido = true;
	}

	private void calmar() {
		if (obtenerTurnoPropio() >= 2) {
			enfurecido = false;
		}
	}

	@Override
	public void descansar() {
		super.descansar();
		petrificar();
	}

	@Override
	public void atacar(Tropa objetivo) {
		despetrificar();

		if (estaPetrificado()) {
			// Si esta petrificado, no hacer nada
			return;
		}

		regenerarSaludAlAtacar();

		calmar();

		objetivo.recibirAtaque(estaEnfurecido() ? (obtenerDanioBase() * 2) : (obtenerDanioBase()));
	}

	/**
	 * Recibe danio en funcion de su condicion actual: si esta petrificado reduce el
	 * danio a la mitad
	 */
	@Override
	public void recibirAtaque(int ataque) {
		if (estaPetrificado()) {
			establecerSalud((int) (obtenerSalud() - ataque / 2));
			siguienteTurnoContiguo();
		} else {
			establecerSalud(obtenerSalud() - ataque);
		}

		despetrificar();
		enfurecer();
	}

	@Override
	public void siguienteTurnoPropio() {
		super.siguienteTurnoPropio();
		calmar();
	}

	private void regenerarSaludAlAtacar() {
		double saludResultante = obtenerSalud() * 1.04;

		saludResultante = (saludResultante >= obtenerSaludMaxima()) ? obtenerSaludMaxima() : saludResultante;

		establecerSalud((int) saludResultante);
	}
}
