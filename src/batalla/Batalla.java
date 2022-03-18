package batalla;

import ejercito.Ejercito;

public class Batalla {

	private Ejercito aliados;

	private Ejercito enemigos;

	public Batalla(Ejercito aliados, Ejercito enemigos) {

		this.aliados = aliados;
		this.enemigos = enemigos;

	}

	public void iniciar() {

		while (!finalizo()) {

			aliados.siguienteTurnoContiguo();

			aliados.atacar(enemigos);

			if (!enemigos.estaDesmayado()) {
				enemigos.atacar(aliados);
				aliados.siguienteTurnoContiguo();
			}
		}

		if (!aliados.estaDesmayado())
			aliados.reagruparse();

	}

	private boolean finalizo() {

		return aliados.estaDesmayado() || enemigos.estaDesmayado();

	}

}
