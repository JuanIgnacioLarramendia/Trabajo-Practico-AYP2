package unidades;

import armas.Arma;
import ejercito.Tropa;

public class Wrive extends Unidad {

	private boolean meditando;

	public Wrive() {
		super(108, 113, 14, 28, Arma.MAGIA);
	}

	private void meditar() {
		this.establecerSalud(obtenerSalud() + 50);
		meditando = true;
	}

	private void despertar() {
		meditando = false;
	}

	public boolean estaMeditando() {
		return meditando;
	}

	@Override
	public void descansar() {
		meditar();
		super.descansar();
	}

	@Override
	public void atacar(Tropa objetivo) {
		if (estaMeditando()) {
			// Si esta meditando, no hacer nada
			return;
		}

		objetivo.recibirAtaque(modificadorDeDanio());
	}

	/**
	 * Esta raza recibe el doble de danio
	 */
	@Override
	public void recibirAtaque(int ataque) {
		despertar();
		establecerSalud(obtenerSalud() - (ataque * 2));
	}

	/**
	 * Aplica un modificador de danio que duplica su ataque por dos turnos
	 */
	private int modificadorDeDanio() {
		if ((obtenerTurnoPropio() + 1) % 3 == 0)
			return obtenerDanioBase() * 2;

		return obtenerDanioBase();
	}

}
