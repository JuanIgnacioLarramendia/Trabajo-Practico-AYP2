package prueba.batalla;

import org.junit.Test;

import batalla.Batalla;
import ejercito.Ejercito;
import unidades.Nortaichian;
import unidades.Radaiteran;
import unidades.Reralope;
import unidades.Unidad;
import unidades.Wrive;

import org.junit.Assert;
import org.junit.Before;

public class PruebaBatalla {

	private Ejercito aliado;
	private Ejercito enemigo;
	private Batalla batalla;

	@Before
	public void initialize() {
		aliado = new Ejercito();
		enemigo = new Ejercito();
	}

	/**
	 * Combate entre 10 Wrives y 2 Radaiteran, chequeamos cuantos Wrives quedan en
	 * pie
	 */
	@Test
	public void prueba001() {
		int cantidadA = 10;
		int cantidadE = 2;
		for (int i = 0; i < cantidadA; i++) {
			aliado.agregarAlEjercito(new Wrive());
		}

		for (int i = 0; i < cantidadE; i++) {
			enemigo.agregarAlEjercito(new Reralope());
		}

		batalla = new Batalla(aliado, enemigo);
		batalla.iniciar();
		Assert.assertEquals(10, aliado.cantidadUnidades());
	}

	/**
	 * Combate entre 10 Wrives y 2 Radaiteran, chequeamos cuantos Reralopes quedan
	 * en pie
	 */
	@Test
	public void prueba002() {
		int cantidadA = 10;
		int cantidadE = 2;
		for (int i = 0; i < cantidadA; i++) {
			aliado.agregarAlEjercito(new Wrive());
		}

		for (int i = 0; i < cantidadE; i++) {
			enemigo.agregarAlEjercito(new Reralope());
		}

		batalla = new Batalla(aliado, enemigo);
		batalla.iniciar();
		Assert.assertEquals(0, enemigo.cantidadUnidades());
	}

	/**
	 * Combate entre 10 Wrives y 2 Radaiteran, chequeamos que los Wrives esten
	 * reagrupados (La primer unidad debe tener la vida completa)
	 */
	@Test
	public void prueba003() {
		int cantidadA = 10;
		int cantidadE = 2;
		for (int i = 0; i < cantidadA; i++) {
			aliado.agregarAlEjercito(new Wrive());
		}

		for (int i = 0; i < cantidadE; i++) {
			enemigo.agregarAlEjercito(new Reralope());
		}

		batalla = new Batalla(aliado, enemigo);
		batalla.iniciar();
		Assert.assertEquals(108, ((Unidad) aliado.obtenerTropas().get(0)).obtenerSalud());
	}

	/**
	 * Combate entre 10 Wrives y 2 Radaiteran, chequeamos que el último Wrive esté
	 * herido (La primer unidad debe tener la vida completa)
	 */
	@Test
	public void prueba004() {
		int cantidadA = 10;
		int cantidadE = 2;
		for (int i = 0; i < cantidadA; i++) {
			aliado.agregarAlEjercito(new Wrive());
		}

		for (int i = 0; i < cantidadE; i++) {
			enemigo.agregarAlEjercito(new Reralope());
		}

		batalla = new Batalla(aliado, enemigo);
		batalla.iniciar();
		Assert.assertEquals(54, ((Unidad) aliado.obtenerTropas().get(9)).obtenerSalud());
	}

	/**
	 * Combate entre 2 Nortaichian y 2 Radaiteran. Los Nortaichian están
	 * descansados. Chequeamos que los Nortaichian tengan 1 unidad en pie.
	 */
	@Test
	public void prueba010() {
		int cantidadA = 2;
		int cantidadE = 2;
		for (int i = 0; i < cantidadA; i++) {
			aliado.agregarAlEjercito(new Nortaichian());
		}

		for (int i = 0; i < cantidadE; i++) {
			enemigo.agregarAlEjercito(new Radaiteran());
		}

		aliado.descansar();
		batalla = new Batalla(aliado, enemigo);
		batalla.iniciar();

		Assert.assertEquals(1, aliado.cantidadUnidades());
	}

	/**
	 * Combate entre 2 Nortaichian y 2 Radaiteran. Los Nortaichian están
	 * descansados. Chequeamos que los Nortaichian tengan 1 unidad en pie.
	 */
	@Test
	public void prueba011() {
		int cantidadA = 2;
		int cantidadE = 2;
		for (int i = 0; i < cantidadA; i++) {
			aliado.agregarAlEjercito(new Nortaichian());
		}

		for (int i = 0; i < cantidadE; i++) {
			enemigo.agregarAlEjercito(new Radaiteran());
		}

		aliado.descansar();
		batalla = new Batalla(aliado, enemigo);
		batalla.iniciar();

		Assert.assertEquals(0, enemigo.cantidadUnidades());
	}

	/**
	 * Combate entre 2 Nortaichian y 2 Radaiteran. Los Nortaichian están
	 * descansados. Chequeamos que el Nortaichian en pie tenga la salud correcta.
	 */
	@Test
	public void prueba012() {
		int cantidadA = 2;
		int cantidadE = 2;
		for (int i = 0; i < cantidadA; i++) {
			aliado.agregarAlEjercito(new Nortaichian());
		}

		for (int i = 0; i < cantidadE; i++) {
			enemigo.agregarAlEjercito(new Radaiteran());
		}

		aliado.descansar();
		batalla = new Batalla(aliado, enemigo);
		batalla.iniciar();

		Assert.assertEquals(7, ((Unidad) aliado.obtenerTropas().get(0)).obtenerSalud());
	}

	/**
	 * Combate entre 2 Reralopes y 2 Radaiteran. Los Reralopes están descansados.
	 * Chequeamos que los Reralopes tengan 1 unidad en pie.
	 */
	@Test
	public void prueba013() {
		int cantidadA = 2;
		int cantidadE = 2;
		for (int i = 0; i < cantidadA; i++) {
			aliado.agregarAlEjercito(new Reralope());
		}

		for (int i = 0; i < cantidadE; i++) {
			enemigo.agregarAlEjercito(new Radaiteran());
		}

		aliado.descansar();
		batalla = new Batalla(aliado, enemigo);
		batalla.iniciar();

		Assert.assertEquals(1, aliado.cantidadUnidades());
	}

	/**
	 * Combate entre 2 Reralopes y 2 Radaiteran. Los Reralopes están descansados.
	 * Chequeamos que los Radaiteran tengan 0 unidades en pie.
	 */
	@Test
	public void prueba014() {
		int cantidadA = 2;
		int cantidadE = 2;
		for (int i = 0; i < cantidadA; i++) {
			aliado.agregarAlEjercito(new Reralope());
		}

		for (int i = 0; i < cantidadE; i++) {
			enemigo.agregarAlEjercito(new Radaiteran());
		}

		aliado.descansar();
		batalla = new Batalla(aliado, enemigo);
		batalla.iniciar();

		Assert.assertEquals(0, enemigo.cantidadUnidades());
	}

	/**
	 * Combate entre 2 Reralopes y 2 Radaiteran. Los Reralopes están descansados.
	 * Chequeamos que el Reralope en pie tenga la salud correcta.
	 */
	@Test
	public void prueba015() {
		int cantidadA = 2;
		int cantidadE = 2;
		for (int i = 0; i < cantidadA; i++) {
			aliado.agregarAlEjercito(new Reralope());
		}

		for (int i = 0; i < cantidadE; i++) {
			enemigo.agregarAlEjercito(new Radaiteran());
		}

		aliado.descansar();
		batalla = new Batalla(aliado, enemigo);
		batalla.iniciar();

		Assert.assertEquals(53, ((Unidad) aliado.obtenerTropas().get(0)).obtenerSalud());
	}

	/**
	 * Combate entre 3 Wrives y 2 Radaiteran. Los Wrives están descansados.
	 * Chequeamos que los Wrives tengan 1 unidad en pie.
	 */
	@Test
	public void prueba016() {
		int cantidadA = 2;
		int cantidadE = 2;
		for (int i = 0; i < cantidadA; i++) {
			aliado.agregarAlEjercito(new Wrive());
		}

		for (int i = 0; i < cantidadE; i++) {
			enemigo.agregarAlEjercito(new Radaiteran());
		}

		aliado.descansar();
		batalla = new Batalla(aliado, enemigo);
		batalla.iniciar();

		Assert.assertEquals(1, aliado.cantidadUnidades());
	}

}
