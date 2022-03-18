package prueba.razas;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import armas.Arma;
import unidades.Wrive;

public class PruebaWrives {

	private Wrive aliado;
	private Wrive enemigo;

	/**
	 * Inicializar un aliado y un enemigo Nortaichian para que peleen entre si
	 */
	@Before
	public void initialize() {
		aliado = new Wrive();
		enemigo = new Wrive();
	}

	/**
	 * Crea un Wrives
	 */
	@Test
	public void prueba001() {
		Assert.assertNotNull(aliado);
	}

	/**
	 * Verificar la salud inicial
	 */
	@Test
	public void prueba002() {
		Assert.assertEquals(108, aliado.obtenerSalud());
	}

	/**
	 * Verificar el danio de base
	 */
	@Test
	public void prueba003() {
		Assert.assertEquals(113, aliado.obtenerDanioBase());
	}

	/**
	 * Verificar el rango minimo
	 */
	@Test
	public void prueba004() {
		Assert.assertEquals(14, aliado.obtenerRangoMin());
	}

	/**
	 * Verificar el rango maximo
	 */
	@Test
	public void prueba005() {
		Assert.assertEquals(28, aliado.obtenerRangoMax());
	}

	/**
	 * Verificar el arma equipada
	 */
	@Test
	public void prueba006() {
		Assert.assertEquals(Arma.MAGIA, aliado.obtenerArma());
	}

	/**
	 * Verificar que no este desmayado mientras su vida sea mayor que cero
	 */
	@Test
	public void prueba007() {
		Assert.assertFalse(aliado.estaDesmayado());
	}

	/**
	 * Verificar que se desmaye si recibe un golpe que lo deje debajo de la vida
	 */
	@Test
	public void prueba008() {
		aliado.establecerSalud(1);
		enemigo.atacar(aliado);

		Assert.assertTrue(aliado.estaDesmayado());
	}

	/**
	 * Poner a un Wrives en modo de descanso
	 */
	@Test
	public void prueba009() {
		aliado.descansar();

		Assert.assertTrue(aliado.estaDescansando());
	}

	/**
	 * Verificar si esta meditando
	 */
	@Test
	public void prueba010() {
		aliado.descansar();

		Assert.assertTrue(aliado.estaMeditando());
	}

	/**
	 * Verificar que la salud aumente 50 puntos al descansar una vez
	 */
	@Test
	public void prueba011() {
		aliado.descansar();

		Assert.assertEquals(158, aliado.obtenerSalud());
	}

	/**
	 * Verificar que la salud aumente 100 puntos al descansar dos veces
	 */
	@Test
	public void prueba012() {
		aliado.descansar();
		aliado.descansar();

		Assert.assertEquals(208, aliado.obtenerSalud());
	}

	/**
	 * Verificar que no pueda atacar al estar meditando
	 */
	@Test
	public void prueba013() {
		aliado.descansar();
		aliado.atacar(enemigo);
	}

	/**
	 * Verificar que despierte cuando es atacado
	 */
	@Test
	public void prueba014() {
		aliado.descansar();
		enemigo.atacar(aliado);

		Assert.assertFalse(aliado.estaMeditando());
	}

	/**
	 * Verificar que el turno propio inicial es cero
	 */
	@Test
	public void prueba015() {
		Assert.assertEquals(0, aliado.obtenerTurnoPropio());
	}

	/**
	 * Avanzar el turno propio
	 */
	@Test
	public void prueba016() {
		aliado.siguienteTurnoPropio();

		Assert.assertEquals(1, aliado.obtenerTurnoPropio());
	}

	/**
	 * Resetear el turno propio
	 */
	@Test
	public void prueba017() {
		aliado.siguienteTurnoPropio();
		aliado.siguienteTurnoPropio();
		aliado.resetearTurnoPropio();

		Assert.assertEquals(0, aliado.obtenerTurnoPropio());
	}

	/**
	 * Verificar que el primer ataque haga el danio basico Nota: Los nortaichian
	 * reciben el doble de danio al no tener armadura
	 */
	@Test
	public void prueba018() {
		aliado.atacar(enemigo);
		aliado.siguienteTurnoPropio();

		Assert.assertEquals(-118, enemigo.obtenerSalud());
	}

	/**
	 * Verificar que el segundo ataque haga el danio basico Nota: Los nortaichian
	 * reciben el doble de danio al no tener armadura
	 */
	@Test
	public void prueba019() {
		for (int i = 0; i < 2; i++) {
			aliado.atacar(enemigo);
			aliado.siguienteTurnoPropio();
		}

		Assert.assertEquals(-344, enemigo.obtenerSalud());
	}

	/**
	 * Verificar que el tercer ataque haga el doble del danio basico Nota: Los
	 * nortaichian reciben el doble de danio al no tener armadura
	 */
	@Test
	public void prueba020() {
		for (int i = 0; i < 3; i++) {
			aliado.atacar(enemigo);
			aliado.siguienteTurnoPropio();
		}

		Assert.assertEquals(-796, enemigo.obtenerSalud());
	}

	/**
	 * Verificar que el cuarto ataque haga el danio basico Nota: Los nortaichian
	 * reciben el doble de danio al no tener armadura
	 */
	@Test
	public void prueba021() {
		for (int i = 0; i < 4; i++) {
			aliado.atacar(enemigo);
			aliado.siguienteTurnoPropio();
		}

		Assert.assertEquals(-1022, enemigo.obtenerSalud());
	}

	/**
	 * Verificar que el quinto ataque haga el danio basico Nota: Los nortaichian
	 * reciben el doble de danio al no tener armadura
	 */
	@Test
	public void prueba022() {
		for (int i = 0; i < 5; i++) {
			aliado.atacar(enemigo);
			aliado.siguienteTurnoPropio();
		}

		Assert.assertEquals(-1248, enemigo.obtenerSalud());
	}

	/**
	 * Verificar que el sexto ataque haga el doble del danio basico Nota: Los
	 * nortaichian reciben el doble de danio al no tener armadura
	 */
	@Test
	public void prueba023() {
		for (int i = 0; i < 6; i++) {
			aliado.atacar(enemigo);
			aliado.siguienteTurnoPropio();
		}

		Assert.assertEquals(-1700, enemigo.obtenerSalud());
	}

}
