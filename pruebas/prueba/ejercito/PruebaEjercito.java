package prueba.ejercito;

import org.junit.Assert;
import org.junit.Test;

import ejercito.Ejercito;
import unidades.Nortaichian;
import unidades.Radaiteran;
import unidades.Reralope;
import unidades.Unidad;
import unidades.Wrive;

public class PruebaEjercito {

	/* CREACION */
	/**
	 * Se crea un ejercito de un Wrive
	 */
	@Test
	public void prueba001() {
		Ejercito ejercito = new Ejercito();
		ejercito.agregarAlEjercito(new Wrive());

		Assert.assertEquals(1, ejercito.cantidadUnidades());
	}

	/**
	 * Se crea un ejercito de 100 Wrives
	 */
	@Test
	public void prueba002() {
		Ejercito ejercito = new Ejercito();
		int cantidad = 100;
		for (int i = 0; i < cantidad; i++) {
			ejercito.agregarAlEjercito(new Wrive());
		}

		Assert.assertEquals(cantidad, ejercito.cantidadUnidades());
	}

	/**
	 * Se crea ejercito de 10000 Wrives, se confirma la raza de la unidad
	 */
	@Test
	public void prueba003() {
		Ejercito ejercito = new Ejercito();
		int cantidad = 10000;
		for (int i = 0; i < cantidad; i++) {
			ejercito.agregarAlEjercito(new Wrive());
		}

		Assert.assertTrue(ejercito.obtenerTropas().get(0) instanceof Wrive);
		;
	}

	/**
	 * Creo ejercito de 100 Reralopes
	 */
	@Test
	public void prueba004() {
		Ejercito ejercito = new Ejercito();
		int cantidad = 100;
		for (int i = 0; i < cantidad; i++) {
			ejercito.agregarAlEjercito(new Reralope());
		}

		Assert.assertEquals(cantidad, ejercito.cantidadUnidades());
	}

	/**
	 * Creo ejercito de 100 Radaiteran
	 */
	@Test
	public void prueba005() {
		Ejercito ejercito = new Ejercito();
		int cantidad = 100;
		for (int i = 0; i < cantidad; i++) {
			ejercito.agregarAlEjercito(new Radaiteran());
		}

		Assert.assertEquals(cantidad, ejercito.cantidadUnidades());
	}

	/**
	 * Creo ejercito de 100 Reralopes
	 */
	@Test
	public void prueba006() {
		Ejercito ejercito = new Ejercito();
		int cantidad = 100;
		for (int i = 0; i < cantidad; i++) {
			ejercito.agregarAlEjercito(new Nortaichian());
		}

		Assert.assertEquals(cantidad, ejercito.cantidadUnidades());
	}

	/* ATAQUE */

	/**
	 * Ejercito de Nortaichian atacan Ejercito de Wrives
	 */
	@Test
	public void prueba007() {
		Ejercito ejercitoAliado = new Ejercito();
		Ejercito ejercitoEnemigo = new Ejercito();

		ejercitoAliado.agregarAlEjercito(new Nortaichian());
		ejercitoEnemigo.agregarAlEjercito(new Wrive());

		ejercitoAliado.atacar(ejercitoEnemigo);

		Assert.assertEquals(72, ((Unidad) ejercitoEnemigo.obtenerTropas().get(0)).obtenerSalud());
	}

	/**
	 * Ejercito de Nortaichian atacan Ejercito de Reralope
	 */
	@Test
	public void prueba008() {
		Ejercito ejercitoAliado = new Ejercito();
		Ejercito ejercitoEnemigo = new Ejercito();

		ejercitoAliado.agregarAlEjercito(new Nortaichian());
		ejercitoEnemigo.agregarAlEjercito(new Reralope());

		ejercitoAliado.atacar(ejercitoEnemigo);

		Assert.assertEquals(35, ((Unidad) ejercitoEnemigo.obtenerTropas().get(0)).obtenerSalud());
	}

	/* DESCANSO DE TROPAS */
	/**
	 * Ejercito manda a todas su unidades a descansar
	 */
	@Test
	public void prueba009() {
		Ejercito ejercito = new Ejercito();
		int cantidad = 10;
		for (int i = 0; i < cantidad; i++) {
			ejercito.agregarAlEjercito(new Wrive());
		}

		ejercito.descansar();

		Assert.assertTrue(((Unidad) ejercito.obtenerTropas().get(0)).estaDescansando());
	}

	/* RECIBIR ATAQUES */
	/**
	 * Ejercito Radaiteran recibe daño
	 */
	@Test
	public void prueba010() {
		Ejercito ejercito = new Ejercito();
		ejercito.agregarAlEjercito(new Radaiteran());
		int danio = 10;

		ejercito.recibirAtaque(danio);
		Assert.assertEquals(26, ((Unidad) ejercito.obtenerTropas().get(0)).obtenerSalud());
	}

	/**
	 * Ejercito Radaiteran recibe daño letal y elimina sus desmayados
	 */
	@Test
	public void prueba011() {
		Ejercito ejercito = new Ejercito();
		ejercito.agregarAlEjercito(new Radaiteran());
		ejercito.agregarAlEjercito(new Radaiteran());
		int danio = 100;

		ejercito.recibirAtaque(danio);
		Assert.assertEquals(1, ejercito.cantidadUnidades());
	}

	/**
	 * Ejercito compuesto por unidades se reagrupa.
	 */
	@Test
	public void prueba012() {
		Ejercito ejercito = new Ejercito();
		ejercito.agregarAlEjercito(new Radaiteran());
		ejercito.agregarAlEjercito(new Wrive());
		ejercito.agregarAlEjercito(new Reralope());

		ejercito.reagruparse();
		Assert.assertTrue(ejercito.obtenerTropas().get(0) instanceof Wrive);
	}

	/**
	 * Ejercito compuesto por unidades y un subEjercito se reagrupa. El primer
	 * Nortaichian debera ir a la ultima posicion del ejercito
	 */
	@Test
	public void prueba013() {
		Ejercito ejercito = new Ejercito();
		Ejercito subEjercito = new Ejercito();
		int cantidad = 10;

		for (int i = 0; i < cantidad; i++) {
			subEjercito.agregarAlEjercito(new Nortaichian());
		}

		ejercito.agregarAlEjercito(subEjercito);
		ejercito.agregarAlEjercito(new Radaiteran());
		ejercito.agregarAlEjercito(new Wrive());
		ejercito.agregarAlEjercito(new Reralope());

		ejercito.reagruparse();

		Assert.assertTrue(ejercito.obtenerTropas().get(ejercito.cantidadUnidades() - 1) instanceof Nortaichian);
	}

	/**
	 * Avanzo el turno de todas las unidades
	 */
	@Test
	public void prueba014() {
		Ejercito ejercito = new Ejercito();

		ejercito.agregarAlEjercito(new Nortaichian());
		ejercito.agregarAlEjercito(new Wrive());

		ejercito.siguienteTurnoContiguo();

		Assert.assertEquals(1, ((Unidad) ejercito.obtenerTropas().get(0)).obtenerTurnoContiguo());
	}

	/**
	 * Reseteo el turno de todas las unidades
	 */
	@Test
	public void prueba015() {
		Ejercito ejercito = new Ejercito();
		int cantidad = 10;

		for (int i = 0; i < cantidad; i++) {
			ejercito.agregarAlEjercito(new Nortaichian());
		}

		ejercito.resetearTurnoContiguo();

		Assert.assertEquals(0, ((Unidad) ejercito.obtenerTropas().get(0)).obtenerTurnoContiguo());
	}

	/**
	 * Chequeo si el ejército "esta desmayado", es decir, no contiene más unidades
	 */
	@Test
	public void prueba016() {
		Ejercito ejercito = new Ejercito();

		Assert.assertTrue(ejercito.estaDesmayado());
	}

	/**
	 * Ejército añade Ejército aliado y lo forma al principio, pues serán los
	 * próximos en combatir
	 */
	@Test
	public void prueba017() {
		Ejercito ejercito = new Ejercito();
		Ejercito aliado = new Ejercito();
		int cantidad = 10;

		for (int i = 0; i < cantidad; i++) {
			ejercito.agregarAlEjercito(new Nortaichian());
		}

		aliado.agregarAlEjercito(new Reralope());

		ejercito.agregarAliadosAlEjercito(aliado);

		Assert.assertTrue(ejercito.obtenerTropas().get(0) instanceof Ejercito);
	}

	/**
	 * Ejército añade unidad aliada y la forma al principio, pues serán los próximos
	 * en combatir
	 */
	@Test
	public void prueba018() {
		Ejercito ejercito = new Ejercito();
		int cantidad = 10;

		for (int i = 0; i < cantidad; i++) {
			ejercito.agregarAlEjercito(new Nortaichian());
		}

		ejercito.agregarAliadosAlEjercito(new Wrive());

		Assert.assertTrue(ejercito.obtenerTropas().get(0) instanceof Wrive);
	}

	/**
	 * Se desmaya la última unidad, por lo que queda el elemento vacío
	 */
	@Test
	public void prueba019() {
		Ejercito ejercito = new Ejercito();
		int cantidad = 2;

		for (int i = 0; i < cantidad; i++) {
			ejercito.agregarAlEjercito(new Wrive());
		}

		ejercito.recibirAtaque(100);
		ejercito.recibirAtaque(100);

		Assert.assertTrue(ejercito.estaDesmayado());
	}

	/**
	 * Cuando el Ejército descansa, se comprueba que la unidad siguiente a la
	 * primera está descansando
	 */
	@Test
	public void prueba020() {
		Ejercito ejercito = new Ejercito();
		int cantidad = 10;

		for (int i = 0; i < cantidad; i++) {
			ejercito.agregarAlEjercito(new Wrive());
		}

		ejercito.descansar();
		ejercito.recibirAtaque(100);

		Assert.assertTrue(((Unidad) ejercito.obtenerTropas().get(0)).estaDescansando());
	}
}