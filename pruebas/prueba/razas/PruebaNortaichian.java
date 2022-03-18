package prueba.razas;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import armas.Arma;
import unidades.Nortaichian;

public class PruebaNortaichian {

	private Nortaichian aliado;
	private Nortaichian enemigo;

	/**
	 * Inicializar un aliado y un enemigo Nortaichian para que peleen entre si
	 */
	@Before
	public void initialize() {
		aliado = new Nortaichian();
		enemigo = new Nortaichian();
	}

	/**
	 * Crea un Nortaichian
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
		Assert.assertEquals(66, aliado.obtenerSalud());
	}

	/**
	 * Verificar el danio de base
	 */
	@Test
	public void prueba003() {
		Assert.assertEquals(18, aliado.obtenerDanioBase());
	}

	/**
	 * Verificar el rango minimo
	 */
	@Test
	public void prueba004() {
		Assert.assertEquals(16, aliado.obtenerRangoMin());
	}

	/**
	 * Verificar el rango maximo
	 */
	@Test
	public void prueba005() {
		Assert.assertEquals(22, aliado.obtenerRangoMax());
	}

	/**
	 * Verificar el arma equipada
	 */
	@Test
	public void prueba006() {
		Assert.assertEquals(Arma.ARCO, aliado.obtenerArma());
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
	 * Poner a un Nortaichian en modo de descanso
	 */
	@Test
	public void prueba009() {
		aliado.descansar();
		Assert.assertTrue(aliado.estaDescansando());
	}

	/**
	 * Verificar si un Nortaichian esta enfurecido
	 */
	@Test
	public void prueba010() {
		Assert.assertFalse(aliado.estaEnfurecido());
	}

	/**
	 * Verificar si un Nortaichian esta petrificado
	 */
	@Test
	public void prueba011() {
		Assert.assertFalse(aliado.estaPetrificado());
	}

	/**
	 * Verificar que un Nortaichian no puede atacar estando petrificado
	 */
	@Test
	public void prueba012() {
		aliado.descansar();
		aliado.atacar(enemigo);

		Assert.assertEquals(66, enemigo.obtenerSalud());
	}

	/**
	 * Verificar que el Nortaichian se cure un 4% de salud al atacar cuando su vida
	 * actual mas el 4% sea menor a su salud maxima
	 */
	@Test
	public void prueba013() {
		enemigo.atacar(aliado);
		aliado.atacar(enemigo);

		Assert.assertEquals(49, aliado.obtenerSalud());
	}

	/**
	 * Verificar que el Nortaichian no se cure cuando su vida actual mas el 4% sea
	 * mayor o igual que su salud maxima
	 */
	@Test
	public void prueba014() {
		aliado.atacar(enemigo);

		Assert.assertEquals(66, aliado.obtenerSalud());
	}

	/**
	 * Verificar que el Nortaichian el danio base al no estar enfurecido
	 */
	@Test
	public void prueba015() {
		aliado.atacar(enemigo);

		Assert.assertEquals(48, enemigo.obtenerSalud());
	}

	/**
	 * Verificar que el Nortaichian haga el doble de danio al estar enfurecido
	 */
	@Test
	public void prueba016() {
		enemigo.atacar(aliado);
		aliado.atacar(enemigo);

		Assert.assertEquals(30, enemigo.obtenerSalud());
	}

	/**
	 * Verificar que el Nortaichian reciba la totalidad de danio al no estar
	 * petrificado
	 */
	@Test
	public void prueba017() {
		enemigo.atacar(aliado);

		Assert.assertEquals(48, aliado.obtenerSalud());
	}

	/**
	 * Verificar que el Nortaichian reciba la mitad de danio al estar petrificado
	 */
	@Test
	public void prueba018() {
		aliado.descansar();
		enemigo.atacar(aliado);

		Assert.assertEquals(57, aliado.obtenerSalud());
	}

	/**
	 * Verificar que el turno propio inicial es cero
	 */
	@Test
	public void prueba019() {
		Assert.assertEquals(0, aliado.obtenerTurnoPropio());
	}

	/**
	 * Avanzar el turno propio
	 */
	@Test
	public void prueba020() {
		aliado.siguienteTurnoPropio();

		Assert.assertEquals(1, aliado.obtenerTurnoPropio());
	}

	/**
	 * Resetear el turno propio
	 */
	@Test
	public void prueba021() {
		aliado.siguienteTurnoPropio();
		aliado.siguienteTurnoPropio();
		aliado.resetearTurnoPropio();

		Assert.assertEquals(0, aliado.obtenerTurnoPropio());
	}

	/**
	 * Verificar que luego de dos turnos contiguos deje de estar petrificado
	 */
	@Test
	public void prueba022() {
		aliado.descansar();
		aliado.atacar(enemigo);
		aliado.siguienteTurnoContiguo();
		enemigo.atacar(aliado);
		aliado.siguienteTurnoContiguo();

		Assert.assertFalse(aliado.estaPetrificado());
	}

	/**
	 * Verificar que luego de dos turnos propios deje de estar enfurecido
	 */
	@Test
	public void prueba023() {
		enemigo.atacar(aliado);
		aliado.siguienteTurnoPropio();
		aliado.siguienteTurnoPropio();

		Assert.assertFalse(aliado.estaEnfurecido());
	}
}
